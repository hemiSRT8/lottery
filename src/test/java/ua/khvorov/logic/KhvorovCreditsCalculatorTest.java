package ua.khvorov.logic;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ua.khvorov.lottery.logic.KhvorovCreditsCalculator;

public class KhvorovCreditsCalculatorTest {

    @Test
    public void givenTicketWithoutCommonSymbolsThenLotteryShouldReturnZeroCreditsAmount() {
        String ticket = "12345";
        String winningCombination = "67890";
        int result = new KhvorovCreditsCalculator().calculateCredits(ticket, winningCombination);
        assertThat(result, is(0));
    }

    @Test
    public void givenTicketWith5CommonSymbolsThenLotteryShouldReturn5CreditsAmount() {
        String ticket = "12345";
        String winningCombination = "12345";
        int result = new KhvorovCreditsCalculator().calculateCredits(ticket, winningCombination);
        assertThat(result, is(5));
    }

    @Test
    public void givenTicketWith5CommonSymbolsInReverseOrderThenLotteryShouldReturn5CreditsAmount() {
        String ticket = "12345";
        String winningCombination = "54321";
        int result = new KhvorovCreditsCalculator().calculateCredits(ticket, winningCombination);
        assertThat(result, is(5));
    }

    @Test
    public void givenTicketWith15CommonSymbolsButRepeatedThreeTimeSymbolsThenLotteryShouldReturn5CreditsAmount() {
        String ticket = "111222333444555";
        String winningCombination = "12345";
        int result = new KhvorovCreditsCalculator().calculateCredits(ticket, winningCombination);
        assertThat(result, is(5));
    }
}
