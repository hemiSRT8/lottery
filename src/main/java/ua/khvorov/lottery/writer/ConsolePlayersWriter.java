package ua.khvorov.lottery.writer;


import java.util.Set;

import ua.khvorov.lottery.entity.Player;

public class ConsolePlayersWriter implements PlayersWriter {

    @Override
    public void writePlayers(Set<Player> players) {
        players.forEach(System.out::println);
    }

    @Override
    public void writeMessage(String message) {
        System.out.println(message);
    }
}