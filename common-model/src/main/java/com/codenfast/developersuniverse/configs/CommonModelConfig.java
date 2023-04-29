package com.codenfast.developersuniverse.configs;

import com.codenfast.developersuniverse.service.EncryptService;
import com.codenfast.developersuniverse.service.EncryptServiceImpl;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@EnableFeignClients(basePackages = "com.codenfast.developersuniverse.feignclients")
@EnableDiscoveryClient
@Slf4j
public class CommonModelConfig implements RabbitListenerConfigurer {
    @Bean
    public MappingJackson2MessageConverter jackson2Converter() {
        return new MappingJackson2MessageConverter();
    }

    @Bean
    public DefaultMessageHandlerMethodFactory mqHandlerMethodFactory(MappingJackson2MessageConverter jackson2Converter) {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        factory.setMessageConverter(jackson2Converter);
        return factory;
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory(mqHandlerMethodFactory(jackson2Converter()));
    }

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        mapper.registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);// will remove value properties
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);
        return mapper;
    }

    @Bean
    public MessageConverter jsonMessageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean("executorService")
    public ExecutorService executorService() {
        ExecutorService executorService = Executors.newFixedThreadPool(70);
        return executorService;
    }

    @Bean("executor")
    public Executor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(30);
        executor.setMaxPoolSize(90);
        executor.setQueueCapacity(Integer.MAX_VALUE);
        executor.setKeepAliveSeconds(120);
        executor.setThreadNamePrefix("codenfastExecutorThread");
        executor.initialize();
        return executor;
    }

    @Bean
    public EncryptService encryptService(ObjectMapper objectMapper) {
        return new EncryptServiceImpl(objectMapper);
    }

    /*
        https://stackoverflow.com/questions/17659510/core-pool-size-vs-maximum-pool-size-in-threadpoolexecutor
        IF running threads > corePoolSize & < maxPoolSize, then create a new Thread if Total task queue is full and new one is arriving.
        From doc: (If there are more than corePoolSize but less than maximumPoolSize threads running, a new thread will be created only if the queue is full.)
        Now, Take a simple example,
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(5, 10, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(50));
        Here, 5 is the corePoolSize - means Jvm will create new thread for new task for first 5 tasks. and other tasks will be added to the queue until queue is getting full (50 tasks).
        10 is the maxPoolSize - JVM can create max 10 threads. Means if there are already 5 task/thread is running and queue is full with 50 pending tasks and if one more new request/task is arriving in queue then JVM will create new thread up to 10 (total threads=previous 5 + new 5);
        new ArrayBlockingQueue(50) = is a total queue size - it can queue 50 tasks in it.
        once all 10 threads are running and if new task is arriving then that new task will be rejected.
        Rules for creating Threads internally by SUN:
        If the number of threads is less than the corePoolSize, create a new Thread to run a new task.
        If the number of threads is equal (or greater than) the corePoolSize, put the task into the queue.
        If the queue is full, and the number of threads is less than the maxPoolSize, create a new thread to run tasks in.
        If the queue is full, and the number of threads is greater than or equal to maxPoolSize, reject the task.
        Hope, This is HelpFul.. and please correct me if i'm wrong...
     */

    @Service
    public class JwtGenerator {

        public String generateJwt(String id,String payload) {
            Date issuedAt = new Date();
            Calendar calendar = Calendar.getInstance();
            SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

            calendar.add(Calendar.MINUTE, 5);
            return Jwts.builder()
                    .setIssuer("Codenfast - Developers Universe")
                    .setSubject(id)
                    .claim("value", payload)
                    .setIssuedAt(issuedAt)
                    .setExpiration(calendar.getTime())
                    .signWith(key,SignatureAlgorithm.HS256)
                    .compact();
        }

        //TODO: Create secret
        public String generateJwt(String payload) throws InvalidKeyException, NoSuchAlgorithmException {
            String header = "{\"alg\": \"HS256\", \"typ\": \"JWT\"}";
            String part1 = Base64.getEncoder().encodeToString(header.getBytes(StandardCharsets.UTF_8));
            String part2 = Base64.getEncoder().encodeToString(payload.getBytes(StandardCharsets.UTF_8));
            String part1_part2 = part1 + "." + part2;

            Date issuedAt = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
            String time = sdf.format(issuedAt);

//            char[] randomSecret = new char[time.length()+id.length()];
//            for(int a=0, b=0, i=0; a < time.toCharArray().length || b < id.toCharArray().length ;i++) {
//                if(i % 2 == 0 && a < time.toCharArray().length || b >= id.toCharArray().length) {
//                    randomSecret[i] = time.toCharArray()[a];
//                    a++;
//                } else {
//                    randomSecret[i] = id.toCharArray()[b];
//                    b++;
//                }
//            }

            String part3 = Base64.getEncoder().encodeToString((doHMACSHA256(part1_part2, new char[]{'W','h','a','t'})).getBytes(StandardCharsets.UTF_8));
            String jwt_token = part1_part2 + "." + part3;
            return jwt_token;
        }

        private String doHMACSHA256(String part1AndPart2, char[] secretKey)
                throws NoSuchAlgorithmException, InvalidKeyException {
            Mac mac = Mac.getInstance("HmacSHA256");
            byte[] secByte = new byte[secretKey.length];
            for(int i=0 ; i < secretKey.length ; i++) {
                secByte[i] = (byte) secretKey[i];
            }
            mac.init(new SecretKeySpec(secByte, "HS256"));
            byte[] hashBytes = mac.doFinal(part1AndPart2.getBytes());
            String hash = Base64.getEncoder().encodeToString(hashBytes);
            return hash;
        }

        //TODO: Create secret and validate
        public boolean validateJwt(String jwt) {
            try {
                if (StringUtils.isBlank(jwt)) {
                    return Boolean.FALSE;
                }
                String[] parts = jwt.split("\\.");


                String part3 = parts[2];
                String part1_part2 = parts[0] + "." + parts[1];
                String jwtSignature = Base64.getEncoder().encodeToString(
                        (doHMACSHA256(part1_part2, new char[]{'W','h','a','t'})).getBytes(StandardCharsets.UTF_8));
                return jwtSignature.equals(part3);
            } catch (InvalidKeyException | NoSuchAlgorithmException e) {
                return Boolean.FALSE;
            }
        }

        public String getValueFromJWT(String jwt) {
            String[] parts = jwt.split("\\.");
            String part2 = new String(Base64.getDecoder().decode((parts[1].getBytes(StandardCharsets.UTF_8))),
                    StandardCharsets.UTF_8);
            return part2;
        }

    }
}
