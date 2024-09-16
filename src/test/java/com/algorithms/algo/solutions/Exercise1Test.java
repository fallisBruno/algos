package com.algorithms.algo.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Exercise1Test {

    @Test
    public void shouldReturnAValidIndex() {
        List<Integer> testInput = Arrays.asList(3, 5, 2, 9, 4);
        Integer target = 9;
        Integer expectedIndex = 3;

        Integer result = Exercise1.getIndex(testInput, target);

        Assertions.assertEquals(expectedIndex, result);
    }

    @Test
    public void shouldReturnANonValidIndexWhenTargetNotFound() {
        List<Integer> testInput = Arrays.asList(3, 5, 2, 9, 4);
        Integer target = 7;
        Integer expectedIndex = -1;

        Integer result = Exercise1.getIndex(testInput, target);

        Assertions.assertEquals(expectedIndex, result);
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenArrayIsNull() {
        Integer target = 9;

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> Exercise1.getIndex(null, target));

        String expectedMessage = "Input array cannot be null.";

        Assertions.assertTrue(expectedMessage.equals(exception.getMessage()));
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenTargetIsNull() {
        List<Integer> testInput = Arrays.asList(3, 5, 2, 9, 4);

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> Exercise1.getIndex(testInput, null));

        String expectedMessage = "Target cannot be null.";

        Assertions.assertTrue(expectedMessage.equals(exception.getMessage()));
    }

}
