package com.algorithms.algo.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

public class Exercise3Test {

    @Test
    public void shouldReturnReversedInput(){
        String input = "hello";
        String expected = "olleh";

        test(input, expected, null);
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenEmptyInput(){
        String input = "";
        String expectedMessage = "Input cannot be null or empty.";

        test(input, null, new IllegalArgumentException(expectedMessage));
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenNullInput(){
        String input = null;
        String expectedMessage = "Input cannot be null or empty.";

        test(input, null, new IllegalArgumentException(expectedMessage));
    }

    public void test(String input, String expectedResult, Exception expectedMessage){
        if(StringUtils.isNotBlank(expectedResult)){
            String result = Exercise3.reverse(input);
            Assertions.assertEquals(expectedResult, result);
        }else if(expectedMessage != null){
            Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> Exercise3.reverse(input));
            Assertions.assertTrue(expectedMessage.getMessage().equals(exception.getMessage()));
        }
    }

}
