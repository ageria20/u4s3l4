package entities;


import enums.EventType;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@DiscriminatorValue("AthleticsComp")
public class AthleticsComp extends Event {



   @ManyToOne
   @JoinColumn(name = "winner", nullable = false)
   private Person winner; // potrebbe essere un collegamento 1to1



    public AthleticsComp() {

    }

    public AthleticsComp(  Person winner) {

        this.winner = winner;
    }

    public AthleticsComp(String title, LocalDate eventDate, String description, EventType eventType, int maxPersons, Location location, Person winner) {
        super(title, eventDate, description, eventType, maxPersons, location);
        this.winner = winner;
    }

    public Person getWinner() {
        return winner;
    }

    public void setWinner(Person winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "AthleticsComp{" +

                ", winner=" + winner +
                '}';
    }
}
