package com.xiomara.task_manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class TaskManagerApplicationTests {

	@Test
	void contextLoads() {
		// Este test verifica que el contexto de Spring (Beans, Configuración)
		// se levante correctamente sin lanzar excepciones.
		assertDoesNotThrow(() -> {});
	}
}
