package ua.khvorov.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static ua.khvorov.lottery.utils.PlayerBuilder.aPlayer;

import org.junit.Test;

import ua.khvorov.lottery.entity.Player;

public class PlayerBuilderTest {

    @Test
    public void givenDataAboutPlayerWhenCallingBuildThenBuilderShouldBuildPlayerEntityWithGivenFields() {
        String firstName = "Artem";
        String lastName = "Khvorov";
        String country = "Ukraine";
        String ticket = "00000000";
        int credits = 50;

        Player result = aPlayer()
                .withFirstName(firstName)
                .withLastName(lastName)
                .withCountry(country)
                .withTicket(ticket)
                .withCredits(credits)
                .build();

        assertThat(result.getFirstName(), is(firstName));
        assertThat(result.getLastName(), is(lastName));
        assertThat(result.getCountry(), is(country));
        assertThat(result.getTicket(), is(ticket));
        assertThat(result.getCredits(), is(credits));
    }
}
