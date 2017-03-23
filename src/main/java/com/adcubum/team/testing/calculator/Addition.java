package com.adcubum.team.testing.calculator;

public class Addition implements Expr {

    private final Expr lhs;
    private final Expr rhs;

    Addition(Expr lhs, Expr rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }


    @Override
    public int calculate() {
        return lhs.calculate() + rhs.calculate();
    }
}
