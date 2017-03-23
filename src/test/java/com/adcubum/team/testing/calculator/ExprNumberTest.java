package com.adcubum.team.testing.calculator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ExprNumberTest {

    @Test
    public void shouldReturnGivenValue34() {
        // given
        int givenValue = 34;
        Expr sut = new ExprNumber(givenValue);

        // when
        int result = sut.calculate();

        // then
        assertThat(result, is(givenValue));
    }

    @Test
    public void shouldReturnGivenValueMinusThree() {
        // given
        int givenValue = -3;
        Expr sut = new ExprNumber(givenValue);

        // when
        int result = sut.calculate();

        // then
        assertThat(result, is(givenValue));
    }

}