package com.minsait.emprestimos.enumeration;

import java.math.BigDecimal;
import java.math.MathContext;

public enum EnumClientType {
    BRONZE(3) {
        @Override
        public BigDecimal totalLoan(BigDecimal totalAmount, Integer totalLoans) {
            BigDecimal tax = new BigDecimal(1.8);
            return totalAmount.multiply(tax, MathContext.DECIMAL32);
        }
    },
    PRATA(2) {
        @Override
        public BigDecimal totalLoan(BigDecimal totalAmount, Integer totalLoans) {
            BigDecimal tax = BigDecimal.ZERO;
            if (totalAmount.compareTo(new BigDecimal("5000")) > 0) {
                tax = new BigDecimal("1.4");
            } else  {
                tax = new BigDecimal("1.6");
            }
            return totalAmount.multiply(tax, MathContext.DECIMAL32);
        }

    },
    OURO(1) {
        @Override
        public BigDecimal totalLoan(BigDecimal totalAmount, Integer totalLoans) {
            BigDecimal tax;

            if (totalLoans <= 1) {
                return totalAmount.multiply(new BigDecimal("1.2"), MathContext.DECIMAL32);
            } else {
                return totalAmount.multiply(new BigDecimal("1.3"), MathContext.DECIMAL32);
            }
        }

    };

    private final int digit;

    EnumClientType(int digit) {
        this.digit = digit;
    }


    public abstract BigDecimal totalLoan(BigDecimal totalAmount, Integer totalLoans);


}
