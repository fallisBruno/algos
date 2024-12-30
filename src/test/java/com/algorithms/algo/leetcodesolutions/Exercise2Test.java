package com.algorithms.algo.leetcodesolutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Exercise2Test {

    @Test
    public void shouldReturnAValidResult(){
        int[] input = new int[]{2,7,11,15};
        int target = 9;
        int[] expected = new int[]{0,1};

        int[] result = Exercise2.getSumIndexes(input, target);

        Assertions.assertTrue(Arrays.equals(expected, result));
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenNoSolutionFound() {
        int[] input = new int[]{2,7,11,15};
        int target = 50;
        String expectedMessage = "No solution found";

        testException(target, input, expectedMessage);
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenArrayInputIsNull() {
        int target = 50;
        String expectedMessage = "Input array cannot be null or empty.";

        testException(target, null, expectedMessage);
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenArrayInputIsEmpty() {
        int target = 50;
        String expectedMessage = "Input array cannot be null or empty.";

        testException(target, new int[]{}, expectedMessage);
    }

    public void testException(int target, int[] arrayToTest, String expectedMessage){
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> Exercise2.getSumIndexes(arrayToTest, target));
        Assertions.assertTrue(expectedMessage.equals(exception.getMessage()));
    }

}
