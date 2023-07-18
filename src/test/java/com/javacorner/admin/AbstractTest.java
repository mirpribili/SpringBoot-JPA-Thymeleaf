package com.javacorner.admin;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;

public class AbstractTest {
    // FIX "Container is started, but cannot be accessed by (JDBC URL: jdbc:mysql"
    //private static MySQLContainer container = new MySQLContainer<>("mysql:latest")
    private static MySQLContainer container = new MySQLContainer<>("mysql:8.0.28")
            //driver.connect("jdbc:tc:mysql:5.7:///?TC_TMPFS=/var/lib/mysql:rw", info);
            .withReuse(true);

    @DynamicPropertySource
    public static void overrideProps(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
    }

    @BeforeAll
    public static void setUp() {
        container.start();
    }
}