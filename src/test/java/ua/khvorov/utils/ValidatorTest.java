package ua.khvorov.utils;

import org.junit.Test;

import ua.khvorov.lottery.utils.Validator;

public class ValidatorTest {

    @Test
    public void givenArgsAmountEqualToTwoThenValidatorShouldNotRaiseAnException() {
        String[] args = {"Alison, Alice, Austria, 5555", "1234567890"};
        Validator.areArgumentsValid(args);
    }

    @Test(expected = RuntimeException.class)
    public void givenArgsAmountNotEqualToTwoThenValidatorShouldRaiseAnException() {
        String[] args = {"Alison, Alice, Austria, 5555"};
        Validator.areArgumentsValid(args);
    }

    @Test(expected = RuntimeException.class)
    public void givenNullArgsThenValidatorShouldRaiseAnException() {
        Validator.areArgumentsValid(null);
    }
}
