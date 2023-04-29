package com.codenfast.developersuniverse.user;

import com.codenfast.developersuniverse.common.configs.CommonConfig;
import com.codenfast.developersuniverse.common.entity.user.*;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.user.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
@EnableAsync
@EnableDiscoveryClient
public class UserApplication extends CommonConfig {

    static {
        System.setProperty("java.awt.headless", "false");
    }

    public static void main(String[] args) {
        Locale.setDefault(new Locale("tr", "TR"));
        System.setProperty("file.encoding", "UTF-8");
        log.info("Default Locale:{}", Locale.getDefault());
        log.info("Default Charset:{}", Charset.defaultCharset());
        log.info("file.encoding:{}", System.getProperty("file.encoding"));
        log.info("sun.jnu.encoding:{}", System.getProperty("sun.jnu.encoding"));
        log.info("Default Encoding:{}", new InputStreamReader(new ByteArrayInputStream(new byte[]{'D'})).getEncoding());
        new SpringApplicationBuilder(UserApplication.class).headless(Boolean.FALSE).run(args);
    }


    @Bean
    public CommandLineRunner init(
            UserService userService,
            PasswordEncoder passwordEncoder,
            RoleService roleService,
            UserRoleService userRoleService,
            RoleAuthService roleAuthService,
            AuthService authService) {
        return arg -> {
            try {
                List<User> userList = userService.grid(RequestGrid.getByProperty("username","guest"));
                if (CollectionUtils.isEmpty(userList)) {
                    User guestUser = new User();
                    guestUser.setUsername("guest");
                    guestUser.setPassword(passwordEncoder.encode("guest"));
                    guestUser = userService.save(guestUser);
                    userList.add(guestUser);
                }
                List<Role> roleList = roleService.grid(RequestGrid.getByProperty("name","guest"));
                if (CollectionUtils.isEmpty(roleList)) {
                    Role role = new Role();
                    role.setName("guest");
                    role = roleService.save(role);

                    UserRole userRole = new UserRole();
                    userRole.setUser(userList.get(0));
                    userRole.setRole(role);
                    userRole = userRoleService.save(userRole);
                }

                userList = userService.grid(RequestGrid.getByProperty("username","admin"));
                if (CollectionUtils.isEmpty(userList)) {
                    User adminUser = new User();
                    adminUser.setUsername("admin");
                    adminUser.setPassword(passwordEncoder.encode("admin"));
                    adminUser = userService.save(adminUser);
                    userList.add(adminUser);
                }
                roleList = roleService.grid(RequestGrid.getByProperty("name","admin"));
                if (CollectionUtils.isEmpty(roleList)) {
                    Role role = new Role();
                    role.setName("admin");
                    role = roleService.save(role);

                    UserRole userRole = new UserRole();
                    userRole.setUser(userList.get(0));
                    userRole.setRole(role);
                    userRole = userRoleService.save(userRole);


                    Auth auth = new Auth();
                    auth.setName("admin");
                    auth = authService.save(auth);

                    RoleAuth roleAuth = new RoleAuth();
                    roleAuth.setRole(role);
                    roleAuth.setAuth(auth);
                    roleAuthService.save(roleAuth);
                }
            } catch (CodenfastException e) {
                e.printStackTrace();
            }
        };
    }
}
