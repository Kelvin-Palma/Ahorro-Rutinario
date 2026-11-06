package com.ahorrorutinario.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.YearMonth;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChallengeTest {
    Challenge diciembre = new Challenge(YearMonth.of(2026, 12), BigDecimal.valueOf(1000));
    Challenge febrero = new Challenge(YearMonth.of(2024, 2), BigDecimal.valueOf(1000));

    @Test
    void aceptaLimiteInferiorExacto() {
        assertThat(diciembre.amountForDay(1)).isEqualByComparingTo(BigDecimal.valueOf(1000));
    }

    @Test
    void aceptaLimiteSuperiorExacto() {
        assertThat(diciembre.amountForDay(31)).isEqualByComparingTo(BigDecimal.valueOf(31000));
    }

    @Test
    void rechazaLimiteInferiorMenosUno() {
        assertThrows(IllegalArgumentException.class, () -> diciembre.amountForDay(0));
    }

    @Test
    void rechazaLimiteSuperiorMasUno() {
        assertThrows(IllegalArgumentException.class, () -> diciembre.amountForDay(32));
    }

    @Test
    void rechazaLimiteSuperiorCasoEspecial() {
        assertThrows(IllegalArgumentException.class, () -> febrero.amountForDay(30));
    }

    @Test
    void rechazaMesConMontoCero() {
        assertThrows(IllegalArgumentException.class, () -> new Challenge(YearMonth.of(2022, 1), BigDecimal.ZERO));
    }
}
