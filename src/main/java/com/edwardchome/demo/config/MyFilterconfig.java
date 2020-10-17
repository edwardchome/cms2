package com.edwardchome.demo.config;


import com.edwardchome.demo.filter.MyNewFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterconfig {
    @Bean
    public FilterRegistrationBean<MyNewFilter> registrationBean(){
        FilterRegistrationBean<MyNewFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new MyNewFilter());
        registrationBean.addUrlPatterns("/customers/*");

        return registrationBean;
    }
}
