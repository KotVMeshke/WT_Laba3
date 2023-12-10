package org.education.config;

import org.education.beans.*;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import static java.lang.Boolean.TRUE;
import static org.hibernate.cfg.JdbcSettings.*;

@Configuration
@ComponentScan("org.education")
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {

    @Bean
    @Scope("singleton")
    public SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration()
                .addAnnotatedClass(CategoryEnt.class)
                .addAnnotatedClass(OrderProductEnt.class)
                .addAnnotatedClass(OrdersEnt.class)
                .addAnnotatedClass(ProductCategoryEnt.class)
                .addAnnotatedClass(ProductEnt.class)
                .addAnnotatedClass(UserEnt.class)
                .setProperty(DRIVER, "com.mysql.cj.jdbc.Driver")
                .setProperty(URL, "jdbc:mysql://localhost:3306/mydb?serverTimezone=Europe/Moscow&useSSL=false")
                .setProperty(USER, "root")
                .setProperty(PASS, "123456")
                .setProperty("hibernate.agroal.maxSize", "20")
                .setProperty(SHOW_SQL, TRUE.toString())
                .setProperty(FORMAT_SQL, TRUE.toString())
                .setProperty(HIGHLIGHT_SQL, TRUE.toString())
                .buildSessionFactory();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("main");
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/view/");
        bean.setSuffix(".jsp");
        return bean;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/");
    }
}
