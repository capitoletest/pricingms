package com.capitole.inditex.pricingms.infrastructure.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(DatabaseConfig.class)
class DatabaseConfigTest {

    @Test
    void contextLoads() {
        assertThat(true).isTrue();
    }
}