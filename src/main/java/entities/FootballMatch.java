package entities;

import enums.EventType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("FootballMatch")
public class FootballMatch extends Event{

    @Column (nullable = false)
    private String home;

    @Column(nullable = false)
    private String guests;

    @Column(nullable = false)
    private String winner;

    @Column (name="homeScore",nullable = false)
    private int homeScore;

    @Column(name="guestsScore", nullable = false)
    private int guestsScore;

    public FootballMatch(){}

    public FootballMatch(String title, LocalDate eventDate, String description, EventType eventType, int maxPersons, Location location, String home, String guests, String winner, int homeScore, int guestsScore) {
        super(title, eventDate, description, eventType, maxPersons, location);
        this.home = home;
        this.guests = guests;
        this.winner = winner;
        this.homeScore = homeScore;
        this.guestsScore = guestsScore;
    }

    public FootballMatch(String home, String guests, String winner, int homeScore, int guestsScore) {
        this.home = home;
        this.guests = guests;
        this.winner = winner;
        this.homeScore = homeScore;
        this.guestsScore = guestsScore;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getGuests() {
        return guests;
    }

    public void setGuests(String guests) {
        this.guests = guests;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getGuestsScore() {
        return guestsScore;
    }

    public void setGuestsScore(int guestsScore) {
        this.guestsScore = guestsScore;
    }

    @Override
    public String toString() {
        return "FootballMatch{" +
                "home='" + home + '\'' +
                ", guests='" + guests + '\'' +
                ", winner='" + winner + '\'' +
                ", homeScore=" + homeScore +
                ", guestsScore=" + guestsScore +
                '}';
    }
}
