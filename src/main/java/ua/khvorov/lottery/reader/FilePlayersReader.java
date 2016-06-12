package ua.khvorov.lottery.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ua.khvorov.lottery.entity.Player;
import ua.khvorov.lottery.utils.PlayerParser;

public class FilePlayersReader implements PlayersReader {

    @Override
    public List<Player> readPlayers(String filePath) {
        List<Player> players = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                players.add(PlayerParser.parsePlayer(currentLine));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File with players was not found.");
        } catch (IOException e) {
            throw new RuntimeException("Exception while reading players from file.");
        }

        return players;
    }
}