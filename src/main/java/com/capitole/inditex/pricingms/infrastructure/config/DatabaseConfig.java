package com.capitole.inditex.pricingms.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Configuration class for setting up JPA repositories.
 * This class enables the
 * JPA repositories in the specified package.
 * It is used to scan for repository interfaces
 * and enable Spring Data JPA features.
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.capitole.inditex.pricingms.infrastructure.adapter.out.jpa")
public class DatabaseConfig {

}