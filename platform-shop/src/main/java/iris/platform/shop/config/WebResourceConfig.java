package iris.platform.shop.config;

import iris.platform.interceptor.AuthorizationInterceptor;
import iris.platform.resolver.LoginUserHandlerMethodArgumentResolver;
import iris.platform.shop.velocity.VelocityConfig;
import iris.platform.shop.velocity.VelocityConfigurer;
import iris.platform.shop.velocity.VelocityToolboxView;
import iris.platform.shop.velocity.VelocityViewResolver;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;
import java.util.Properties;

@EnableWebMvc
@Configuration
public class WebResourceConfig implements WebMvcConfigurer {

    @Autowired
    AuthorizationInterceptor authorizationInterceptor;

    @Autowired
    LoginUserHandlerMethodArgumentResolver loginResolver;

    @Autowired
    private final ResourceLoader resourceLoader = new DefaultResourceLoader();

    @Bean
    public VelocityConfig velocityConfig() {
        VelocityConfigurer cfg = new VelocityConfigurer();
        cfg.setResourceLoader(resourceLoader);
        Properties properties = new Properties();
        properties.setProperty("input.encoding","UTF-8");
        properties.setProperty("output.encoding","UTF-8");
        cfg.setVelocityProperties(properties);
        cfg.setResourceLoaderPath("classpath:/template/");
        return cfg;
    }

    @Bean
    public ViewResolver viewResolver() {
        VelocityViewResolver resolver = new VelocityViewResolver();
        resolver.setViewClass(VelocityToolboxView.class);
        resolver.setPrefix("");
        resolver.setSuffix(".html");
        resolver.setContentType("text/html;charset=UTF-8");
        resolver.setRequestContextAttribute("rc");

        resolver.setDateToolAttribute("date");
        return resolver;
    }


//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        configurer.favorPathExtension(false).
//                favorParameter(false).
//                ignoreAcceptHeader(false).
//                useJaf(false).
//                defaultContentType(MediaType.TEXT_HTML).
//                mediaType("json", MediaType.APPLICATION_JSON);
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/login.html").addResourceLocations("classpath:/template/login.html");
        registry.addResourceHandler("/index.html").addResourceLocations("classpath:/template/index.html");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");


    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(loginResolver);
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/api/**");
    }
}
