package iris.platform.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@EnableWebMvc
@Configuration
public class WebResourceConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/login.html").addResourceLocations("classpath:/templates/login.html");
        registry.addResourceHandler("/index.html").addResourceLocations("classpath:/templates/index.html");

        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}
