package ua.khvorov.lottery;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static ua.khvorov.lottery.utils.PlayerBuilder.aPlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import ua.khvorov.lottery.entity.Player;
import ua.khvorov.lottery.logic.CreditsCalculator;
import ua.khvorov.lottery.logic.KhvorovCreditsCalculator;
import ua.khvorov.lottery.reader.PlayersReader;
import ua.khvorov.lottery.writer.PlayersWriter;

public class LotteryTest {

    @Test
    public void lotteryShouldReadPlayersFileAndUseFirstArgAsFilePath() throws IOException {
        String filePath = "D:\\players.txt";
        String winningCombination = "12345";
        String[] args = {filePath, winningCombination};

        PlayersReader playersReaderMock = createPlayersReaderStub(filePath);
        PlayersWriter playersWriter = mock(PlayersWriter.class);
        CreditsCalculator creditsCalculator = new KhvorovCreditsCalculator();

        new Lottery(playersWriter, playersReaderMock, creditsCalculator).playLottery(args);

        verify(playersReaderMock, times(1)).readPlayers(filePath);
        verify(playersWriter, times(1)).writePlayers(createExpectedResult());
    }

    private List<Player> createPlayers() {
        List<Player> players = new ArrayList<>();

        players.add(createPlayer("Alison", "Alice", "Austria", "1234"));
        players.add(createPlayer("Alison", "Alice", "Austria", "5"));
        players.add(createPlayer("Bert", "Bertram", "Belgium", "23"));
        players.add(createPlayer("Carlson", "Cynthia", "China", "1"));
        players.add(createPlayer("Daneson", "Dan_Dilbert", "Denmark", "00000"));

        return players;
    }

    private Player createPlayer(String firstName, String lastName, String country, String ticket) {
        return aPlayer()
                .withFirstName(firstName)
                .withLastName(lastName)
                .withCountry(country)
                .withTicket(ticket)
                .build();
    }

    private Set<Player> createExpectedResult() {
        Set<Player> winners = new HashSet<>();

        winners.add(createWinner("Alison", "Alice", "Austria", 5));
        winners.add(createWinner("Bert", "Bertram", "Belgium", 2));
        winners.add(createWinner("Carlson", "Cynthia", "China", 1));

        return winners;
    }

    private Player createWinner(String firstName, String lastName, String country, int credits) {
        return aPlayer()
                .withFirstName(firstName)
                .withLastName(lastName)
                .withCountry(country)
                .withCredits(credits)
                .build();
    }

    private PlayersReader createPlayersReaderStub(String filePath) {
        PlayersReader stub = mock(PlayersReader.class);
        when(stub.readPlayers(filePath)).thenReturn(createPlayers());

        return stub;
    }
}