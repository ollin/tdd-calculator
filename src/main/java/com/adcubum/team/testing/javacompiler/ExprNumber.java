package com.adcubum.team.testing.javacompiler;

public class ExprNumber implements Expr {

    private final int anInt;

    public ExprNumber(int anInt) {
        this.anInt = anInt;
    }

    @Override
    public int calculate() {
        return anInt;
    }
}
