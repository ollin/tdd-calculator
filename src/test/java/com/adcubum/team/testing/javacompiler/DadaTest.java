package com.adcubum.team.testing.javacompiler;

import org.junit.Test;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.copyOfRange;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DadaTest {

    @Test
    public void emptyStringShouldGiveZero() {
        // given
        String givenTwo = "";

        // when
        int result = calculate(givenTwo);

        // then
        assertThat(result, is(0));
    }

    @Test
    public void twoShouldBeTwo() {
        // given
        String givenTwo = "2";

        // when
        int result = calculate(givenTwo);

        // then
        assertThat(result, is(2));
    }

    @Test
    public void fourShouldBeFour() {
        // given
        String givenTwo = "4";

        // when
        int result = calculate(givenTwo);

        // then
        assertThat(result, is(4));
    }

    @Test
    public void fourWithSpaceShouldBeFour() {
        // given
        String givenTwo = "4 ";

        // when
        int result = calculate(givenTwo);

        // then
        assertThat(result, is(4));
    }

    @Test
    public void add1And2ShouldGive3() {

        // given
        String givenTwo = "1 + 2";

        // when
        int result = calculate(givenTwo);

        // then
        assertThat(result, is(3));
    }

    @Test
    public void subtract4minus1ShouldGive3() {

        // given
        String givenTwo = "4 - 1";

        // when
        int result = calculate(givenTwo);

        // then
        assertThat(result, is(3));
    }

    @Test
    public void add2And3ShouldGive5() {

        // given
        String givenTwo = "2 + 3";

        // when
        int result = calculate(givenTwo);

        // then
        assertThat(result, is(5));
    }

    @Test
    public void add2And3Minus4ShouldGive1() {

        // given
        String givenTwo = "2 + 3 - 4";

        // when
        int result = calculate(givenTwo);

        // then
        assertThat(result, is(1));
    }

    @Test
    public void multiply4And3ShouldGive12() {

        // given
        String givenTwo = "4 * 3";

        // when
        int result = calculate(givenTwo);

        // then
        assertThat(result, is(12));
    }


    @Test
    public void multiply4And3Plus2ShouldGive14() {
        // given
        String givenTwo = "4 * 3 + 2";

        // when
        int result = calculate(givenTwo);

        // then
        assertThat(result, is(14));
    }


    private int calculate(String givenExpression) {
        if ("".equals(givenExpression)) {
            return 0;
        }
        else if (givenExpression.trim().contains(" ")) {
            String[] tokens = tokenize(givenExpression);
            return calculate(tokens);
        }
        return getAnInt(givenExpression);
    }

    private String[] tokenize(String givenExpression) {
        return givenExpression.split(" ");
    }

    private int calculate(String[] expressionAsArray) {
        return parseAsExpression(expressionAsArray).calculate();
    }

    private Expr parseAsExpression(String[] expressionAsArray) {
        if (expressionAsArray.length == 1) {
            return parseAsExpression(expressionAsArray[0]);
        }
        if (expressionAsArray[1].equals("+")) {
            return new Addition(
                    parseAsExpression(expressionAsArray[0]),
                    parseAsExpression(copyOfRange(expressionAsArray, 2, expressionAsArray.length)));

        } else if (expressionAsArray[1].equals("*")) {
            return new Multiplication(
                    parseAsExpression(expressionAsArray[0]),
                    parseAsExpression(copyOfRange(expressionAsArray, 2, expressionAsArray.length)));
        } else {
            return new ExprNumber(getAnInt(expressionAsArray[0]) - calculate(copyOfRange(expressionAsArray, 2, expressionAsArray.length)));
        }
    }

    private int getAnInt(String givenExpression) {
        return parseInt(givenExpression.trim());
    }

    private Expr parseAsExpression(String givenExpression) {
        return new ExprNumber(parseInt(givenExpression.trim()));
    }
}
