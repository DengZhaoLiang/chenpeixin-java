package com.chenpeixin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 静态资源
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置静态资源处理
        registry.addResourceHandler("/image/**")
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/image/");

        //配置静态资源处理
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

    /**
     * 跨域
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600);
    }

    /**
     * admin 拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * user 拦截器
         */
        registry.addInterceptor(new UserInterceptor())
                .addPathPatterns("/api/user/**")
                .excludePathPatterns("/api/user/login", "/api/user/register", "/css/*", "/img/*", "/js/*");
    }
}
