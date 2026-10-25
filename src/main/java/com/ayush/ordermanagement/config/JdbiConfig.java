
package com.ayush.ordermanagement.config;

import javax.sql.DataSource;

import org.jdbi.v3.core.Jdbi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdbiConfig {

    @Bean
    public Jdbi jdbi(DataSource dataSource) {
        System.out.println("Initializing JDBI bean...");

        return Jdbi.create(dataSource);
    }
}
