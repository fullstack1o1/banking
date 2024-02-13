package com.example.springdatajdbc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@Testcontainers
class SpringDataJdbcApplicationTests {

	@Container
	@ServiceConnection
	static final PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>(PostgreSQLContainer.IMAGE);

	@Test
	void contextLoads() {
	}

}
