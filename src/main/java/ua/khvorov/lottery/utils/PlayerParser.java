package ua.khvorov.lottery.utils;

import ua.khvorov.lottery.entity.Player;

import static ua.khvorov.lottery.utils.PlayerBuilder.aPlayer;

public class PlayerParser {

    private static final String SEPARATOR = ",";

    private PlayerParser() {
    }

    public static Player parsePlayer(String player) {
        String[] playerFields = player.split(SEPARATOR);

        return aPlayer()
                .withFirstName(playerFields[0])
                .withLastName(playerFields[1])
                .withCountry(playerFields[2])
                .withTicket(playerFields[3])
                .build();
    }
}