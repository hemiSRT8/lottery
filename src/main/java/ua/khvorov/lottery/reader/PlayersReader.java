package ua.khvorov.lottery.reader;

import ua.khvorov.lottery.entity.Player;

import java.util.List;

public interface PlayersReader {
    List<Player> readPlayers(String filePath);
}