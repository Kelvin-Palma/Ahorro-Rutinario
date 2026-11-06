package com.ahorrorutinario;

import com.ahorrorutinario.domain.Challenge;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.time.Year;
import java.time.YearMonth;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AhorroRutinarioApplicationTests {
	AhorroRutinarioApplication Service = new  AhorroRutinarioApplication();
	Challenge Noviembre = new Challenge(YearMonth.of(2026, 11), BigDecimal.valueOf(1000));
	Challenge Febrero = new Challenge(YearMonth.of(2024, 2), BigDecimal.valueOf(1000));

	@Test
	void aceptaLimiteInferiorExacto() {
		assertEquals(BigDecimal.valueOf(1000), Noviembre.amountForDay(1, BigDecimal.valueOf(1000)));
	}

	@Test
	void aceptaLimiteSuperiorExacto() {
		assertEquals(BigDecimal.valueOf(31000), Noviembre.amountForDay(31, BigDecimal.valueOf(1000)));
	}

	@Test
	void rechazaLimiteInferiorMenosUno() {
		assertThrows(IllegalArgumentException.class, () -> Noviembre.amountForDay(0, BigDecimal.valueOf(1000)));
	}

	@Test
	void rechazaLimiteSuperiorMasUno() {
		assertThrows(IllegalArgumentException.class, () -> Noviembre.amountForDay(32, BigDecimal.valueOf(1000)));
	}

	@Test
	void rechazaLimiteSuperiorCasoEspecial() {
		assertThrows(IllegalArgumentException.class, () -> Febrero.amountForDay(30, BigDecimal.valueOf(1000)));
	}
}