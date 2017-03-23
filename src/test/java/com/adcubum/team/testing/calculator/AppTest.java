package com.adcubum.team.testing.calculator;

import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * unit test.
 */
public class AppTest {

    @Test
    public void shouldRunViaMain() {
        // given
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        // when
        App.main(new String[]{});
        // then
        verify(out).print(is("0"));
    }
}
