package ua.khvorov.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static ua.khvorov.lottery.utils.PlayerBuilder.aPlayer;

import org.junit.Test;

import ua.khvorov.lottery.entity.Player;
import ua.khvorov.lottery.utils.PlayerParser;

public class PlayerParserTest {

    @Test
    public void givenPlayerAsAStringWhenCallingParsePlayerThenParserShouldReturnPlayerEntity() {
        String playerString = "Alison,Alice,Austria,1234";

        Player playerEntity = aPlayer()
                .withFirstName("Alison")
                .withLastName("Alice")
                .withCountry("Austria")
                .withTicket("1234")
                .build();

        Player result = PlayerParser.parsePlayer(playerString);

        assertThat(result, is(playerEntity));
    }
}
