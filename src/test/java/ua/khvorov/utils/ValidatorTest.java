package ua.khvorov.utils;

import org.junit.Test;
import ua.khvorov.lottery.utils.Validator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ValidatorTest {

    @Test
    public void givenArgsAmountEqualToTwoThenValidatorShouldNotRaiseAnException() {
        String[] args = {"Alison, Alice, Austria, 5555", "1234567890"};
        assertThat(Validator.areArgumentsValid(args), is(true));
    }

    @Test
    public void givenArgsAmountNotEqualToTwoThenValidatorShouldRaiseAnException() {
        String[] args = {"Alison, Alice, Austria, 5555"};
        assertThat(Validator.areArgumentsValid(args), is(false));
    }

    @Test
    public void givenNullArgsThenValidatorShouldRaiseAnException() {
        assertThat(Validator.areArgumentsValid(null), is(false));
    }
}
