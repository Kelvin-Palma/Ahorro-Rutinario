package com.ahorrorutinario.domain;

import java.math.BigDecimal;
import java.time.YearMonth;

public class Challenge {
    private final YearMonth period; // Un mes con sus dias
    private final BigDecimal baseAmount;

    public Challenge(YearMonth period, BigDecimal montoBase) {
        if (montoBase.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto base debe ser mayor a 0");
        }
        this.period = period;
        this.baseAmount = montoBase;
    }

    public BigDecimal amountForDay(int day) {
        if (day < 1 || day > period.lengthOfMonth()) {
            throw new IllegalArgumentException("El dia debe estar entre 1 y " + period.lengthOfMonth());
        }

        return baseAmount.multiply(BigDecimal.valueOf(day));
    }
}

