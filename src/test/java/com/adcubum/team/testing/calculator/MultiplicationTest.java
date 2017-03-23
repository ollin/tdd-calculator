package com.adcubum.team.testing.calculator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * unit test.
 */
public class MultiplicationTest {

    @Test
    public void should3m4r12() {
        // given
        Expr three = new ExprNumber(3);
        Expr four = new ExprNumber(4);

        Multiplication sut = new Multiplication(three, four);
        // when
        int result = sut.calculate();
        // then
        assertThat(result, is(12));
    }

    @Test
    public void shouldMinus3m4r12() {
        // given
        Expr three = new ExprNumber(-3);
        Expr four = new ExprNumber(4);

        Multiplication sut = new Multiplication(three, four);
        // when
        int result = sut.calculate();
        // then
        assertThat(result, is(-12));
    }

}