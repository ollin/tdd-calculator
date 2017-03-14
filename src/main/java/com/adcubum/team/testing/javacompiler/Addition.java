package com.adcubum.team.testing.javacompiler;

/**
 * Created by ollin on 07.03.17.
 */
public class Addition implements Expr {

    private final Expr lhs;
    private final Expr rhs;

    public Addition(Expr lhs, Expr rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }


    @Override
    public int calculate() {
        return lhs.calculate() + rhs.calculate();
    }
}
