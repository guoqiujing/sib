package cn.myzqu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ajax跨域请求配置
 * Created by 的川 on 2018/5/18.
 */
@Configuration
public class CustomCorsConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置了可以被跨域访问的路径和可以被哪些主机跨域访问
       // registry.addMapping("/**").allowedOrigins("http://localhost:8081", "http://localhost:8082");
        registry.addMapping("/**").allowedOrigins("*");
    }
}
