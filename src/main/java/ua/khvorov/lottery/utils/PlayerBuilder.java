package ua.khvorov.lottery.utils;

import ua.khvorov.lottery.entity.Player;

public class PlayerBuilder {

    private String firstName;
    private String lastName;
    private String country;
    private String ticket;
    private int credits;

    private PlayerBuilder() {

    }

    public static PlayerBuilder aPlayer() {
        return new PlayerBuilder();
    }

    public Player build() {
        return new Player(this);
    }

    public PlayerBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PlayerBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PlayerBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public PlayerBuilder withTicket(String ticket) {
        this.ticket = ticket;
        return this;
    }

    public PlayerBuilder withCredits(int credits) {
        this.credits = credits;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public String getTicket() {
        return ticket;
    }

    public int getCredits() {
        return credits;
    }
}