package com.Ebook.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.Ebook.api.service.AuthFilter;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

//import io.swagger.v3.oas.annotations.OpenAPIDefinition;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@Configuration

@OpenAPIDefinition(info = @Info(title = "E-BOOK BACKEND API", version = "1.0", description = "This is a collection of all RESTFULL API's  "
        + "\n"
        + "Some are secured and require login jwt token ", license = @License(name = "DEV:Jackson N." + "\n"+"Tell:+250788445849 ", url = "https://www.santechrwanda.com/"), contact = @Contact(url = "https://www.santechrwanda.com/", name = "SANTECH LTD", email = "info@santechrwanda.com")))

@SpringBootApplication

@EnableJpaAuditing
public class E_BOOK {
    public static void main(String[] args) {
        SpringApplication.run(E_BOOK.class, args);
    }

    @Configuration
    public class CorsConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {

            registry.addMapping("/**").allowedOrigins("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
                    .allowCredentials(true);

        }

    }

    @Bean
    public FilterRegistrationBean<AuthFilter> filterRegistrationBean() {
        FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
        AuthFilter authFilter = new AuthFilter();
        registrationBean.setFilter(authFilter);
        registrationBean.addUrlPatterns(
                "/api/v1/staffs/*",
                "/api/v1/agents/*",
                "/api/v1/clients/*",
                "/api/v1/branches/*",
                "/api/v1/logs/*",
                "/api/v1/User/setrole/*",
                "/api/v1/User/logout");
        return registrationBean;
    }
}