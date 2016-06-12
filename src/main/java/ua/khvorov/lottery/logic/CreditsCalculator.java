package ua.khvorov.lottery.logic;

public interface CreditsCalculator {
    int calculateCredits(String ticketNumber, String winningCombination);
}
