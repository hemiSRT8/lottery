package ua.khvorov.lottery.logic;

import java.util.HashSet;
import java.util.Set;

public class KhvorovCreditsCalculator implements CreditsCalculator {

    @Override
    public int calculateCredits(String ticketNumber, String winningCombination) {
        Set<Character> common = new HashSet<>();

        for (int i = 0; i < winningCombination.length(); i++) {
            char winningCombinationChar = winningCombination.charAt(i);
            for (int j = 0; j < ticketNumber.length(); j++) {
                char ticketNumberChar = ticketNumber.charAt(j);
                if (winningCombinationChar == ticketNumberChar) {
                    common.add(winningCombinationChar);
                    break;
                }
            }
        }

        return common.size();
    }
}
