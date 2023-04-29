package com.codenfast.developersuniverse.common.service;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.StringTemplateResolver;

import java.io.Serializable;
import java.util.Map;

@Service
@SuppressWarnings("squid:S1948")
public class PageRenderer implements Serializable {
    private final TemplateEngine templateEngine;
    private final TemplateEngine stringTemplateEngine;

    public PageRenderer(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
        stringTemplateEngine = new TemplateEngine();
        StringTemplateResolver templateResolver = new StringTemplateResolver();
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCacheable(Boolean.FALSE);
        templateResolver.setOrder(1);
        stringTemplateEngine.setTemplateResolver(templateResolver);
    }

    public String build(String templateName, Map<String, Object> bodyValues) {
        Context context = new Context();
        bodyValues.forEach(context::setVariable);
        return templateEngine.process(templateName, context);
    }

    public String buildFromStringTemplate(String templateHtmlString, Map<String, Object> bodyValues) {
        Context context = new Context();
        bodyValues.forEach(context::setVariable);
        return stringTemplateEngine.process(templateHtmlString, context);
    }
}
