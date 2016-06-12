package ua.khvorov.lottery;

import ua.khvorov.lottery.logic.KhvorovCreditsCalculator;
import ua.khvorov.lottery.reader.FilePlayersReader;
import ua.khvorov.lottery.writer.ConsolePlayersWriter;

public class Launcher {

    private Launcher() {
    }

    public static void main(String[] args) {
        new Lottery(new ConsolePlayersWriter(), new FilePlayersReader(), new KhvorovCreditsCalculator()).playLottery(args);
    }
}