package com.ahorrorutinario.domain;

import java.math.BigDecimal;
import java.time.Year;
import java.time.YearMonth;

public class Challenge {
    private final YearMonth fecha;
    private final BigDecimal montoBase;

    public Challenge(YearMonth fecha, BigDecimal montoBase) {
        this.fecha = fecha;
        this.montoBase = montoBase;
    }

    public static BigDecimal amountForDay(int day, BigDecimal montoBase) {
        if (day < 1 || day > 31) {
            // Esto debe lanzar IllegalArgumentException
            throw new IllegalArgumentException("ERROR: El dia debe de estar entre 1 y 31\n");

        } else if (fecha.getMonth() == 2 && ((Year.isLeap(fecha.getYear()) && day > 29) || (!Year.isLeap(fecha.getYear()) && day >= 29))) {
            // Esto debe lanzar IllegalArgumentException
            throw new IllegalArgumentException("ERROR: El dia debe de estar entre 1 y 28 o ser 31\n");

        }
            
        else {
            // Esto debe de devolver la cantidad de dinero que se debe recaudar para dicho dia
            return montoBase.multiply(BigDecimal.valueOf(day));
        }
    }
}

