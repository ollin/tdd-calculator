package com.adcubum.team.testing.calculator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * unit test.
 */
public class AdditionTest {

    @Test
    public void should1To3Result4() {
        // given
        Expr one = new ExprNumber(1);
        Expr three = new ExprNumber(3);

        Addition sut = new Addition(one, three);
        // when
        int result = sut.calculate();

        // then
        assertThat(result, is(4));
    }

    @Test
    public void should1ToMinus3Result4() {
        // given
        Expr one = new ExprNumber(1);
        Expr three = new ExprNumber(-3);

        Addition sut = new Addition(one, three);
        // when
        int result = sut.calculate();

        // then
        assertThat(result, is(-2));
    }

}