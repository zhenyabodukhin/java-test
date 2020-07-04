package com.test.java;

import com.test.java.config.core.DatabaseConfig;
import com.test.java.config.core.JpaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAspectJAutoProxy
@EnableTransactionManagement(proxyTargetClass = true)
@SpringBootApplication(scanBasePackages = {"com.test.java"},
        exclude = {
                JacksonAutoConfiguration.class,
                HibernateJpaAutoConfiguration.class
        })
@Import({
        DatabaseConfig.class,
        JpaConfig.class
})
public class StartApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}

