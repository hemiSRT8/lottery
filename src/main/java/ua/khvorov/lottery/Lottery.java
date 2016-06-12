package ua.khvorov.lottery;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ua.khvorov.lottery.entity.Player;
import ua.khvorov.lottery.logic.CreditsCalculator;
import ua.khvorov.lottery.reader.PlayersReader;
import ua.khvorov.lottery.utils.Validator;
import ua.khvorov.lottery.writer.PlayersWriter;

public class Lottery {

    private PlayersReader playersReader;
    private PlayersWriter playersWriter;
    private CreditsCalculator creditsCalculator;

    public Lottery(PlayersWriter playersWriter, PlayersReader playersReader, CreditsCalculator creditsCalculator) {
        this.playersWriter = playersWriter;
        this.playersReader = playersReader;
        this.creditsCalculator = creditsCalculator;
    }

    public void playLottery(String[] args) {
        if (!Validator.areArgumentsValid(args)) {
            exitGame();
        }

        List<Player> players = playersReader.readPlayers(args[0]);
        String winningCombination = args[1];

        Set<Player> winners = new HashSet<>();

        for (Player player : players) {
            int playerCredits = creditsCalculator.calculateCredits(player.getTicket(), winningCombination);
            if (playerCredits > 0) {
                if (winners.contains(player)) {
                    Player winner = players.get(players.indexOf(player));
                    winner.setCredits(winner.getCredits() + playerCredits);
                } else {
                    player.setCredits(playerCredits);
                    winners.add(player);
                }
            }
        }

        playersWriter.writePlayers(winners);
    }

    private void exitGame() {
        String exitMessage = "Lottery game should be launched with 2 command line parameters, " +
                "[file path] and [winning number]. " +
                "Example: java Launcher D:\\players.txt 12345";

        playersWriter.writeMessage(exitMessage);
        System.exit(0);
    }
}