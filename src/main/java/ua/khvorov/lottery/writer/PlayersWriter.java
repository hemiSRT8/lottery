package ua.khvorov.lottery.writer;

import java.util.Set;

import ua.khvorov.lottery.entity.Player;

public interface PlayersWriter {

    void writePlayers(Set<Player> players);

    void writeMessage(String message);
}