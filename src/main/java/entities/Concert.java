package entities;


import enums.EventType;
import enums.GenresType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("Concert")
public class Concert extends Event{

    @Column(name = "genre", nullable = false)
    @Enumerated(EnumType.STRING)
    private GenresType genresType;

    @Column
    private boolean isStreaming;

    public Concert(){

    }

    public Concert(GenresType genresType, boolean isStreaming) {
        this.genresType = genresType;
        this.isStreaming = isStreaming;
    }

    public Concert(String title, LocalDate eventDate, String description, EventType eventType, int maxPersons, Location location, GenresType genresType, boolean isStreaming) {
        super(title, eventDate, description, eventType, maxPersons, location);
        this.genresType = genresType;
        this.isStreaming = isStreaming;
    }

    public GenresType getGenresType() {
        return genresType;
    }

    public void setGenresType(GenresType genresType) {
        this.genresType = genresType;
    }

    public boolean isStreaming() {
        return isStreaming;
    }

    public void setStreaming(boolean streaming) {
        isStreaming = streaming;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "genresType=" + genresType +
                ", isStreaming=" + isStreaming +
                '}';
    }
}
