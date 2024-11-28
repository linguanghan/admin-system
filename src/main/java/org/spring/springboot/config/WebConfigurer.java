package org.spring.springboot.config;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * 全局配置
 *
 * @Author : zhoubin
 * @Date : 2022-12-27 16:36
 */
@Configuration
public class WebConfigurer implements ServletContextInitializer {

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //  你需要跨域的地址
        // * 表示对所有的地址都可以访问
        corsConfiguration.addAllowedOrigin("https://wxwebpelbs.yfqp.shop");
        corsConfiguration.addAllowedOrigin("http://mgrtest.yfqp.shop");
        corsConfiguration.addAllowedOrigin("http://mgrylc.yfqp.shop");
        corsConfiguration.addAllowedOrigin("http://localhost:7456");
        corsConfiguration.addAllowedOrigin("http://127.0.0.1:7456");

        //  跨域的请求头
        corsConfiguration.addAllowedHeader("*");
        //  跨域的请求方法
        corsConfiguration.addAllowedMethod("*");
        //加上了这一句，大致意思是可以携带 cookie
        //最终的结果是可以 在跨域请求的时候获取同一个 session
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }

    /**
     * 跨域设置
     * @return corsFilter
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //配置 可以访问的地址
        source.registerCorsConfiguration("/**", buildConfig());
        source.registerCorsConfiguration("/*/**", buildConfig());
        return new CorsFilter(source);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

    }
}
