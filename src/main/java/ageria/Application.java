package ageria;

import dao.EventDAO;
import dao.LocationDAO;
import dao.PartecipationDAO;
import dao.PersonDAO;
import entities.*;
import enums.EventType;
import enums.GenderType;
import enums.GenresType;
import enums.StatusType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Application {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4s3l4");
    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        EventDAO ed = new EventDAO(em);
        LocationDAO ld = new LocationDAO(em);
        PersonDAO pd = new PersonDAO(em);
        PartecipationDAO partD = new PartecipationDAO(em);

        Location sanSiro = new Location ("San Siro", "Milano");
        Location bernabeu = new Location ("Bernabeu", "Madrid");
        Location campNou = new Location ("Camp Nou", "Barcellona");
        Location granillo = new Location ("Granillo", "Reggio Calabria");

      /*  ld.save(sanSiro);
        ld.save(bernabeu);
        ld.save(campNou);
        ld.save(granillo);*/


        Location lfromDb = ld.getById("250ab1e8-accd-43c2-aeec-35cb62b30486");
        Location l2fromDb = ld.getById("7ccf1581-e592-44a6-a031-6ce57d8f3c03");
        Location l3fromDb = ld.getById("8eca4437-b84c-418d-abe9-79a0a8063d72");
        Location l4fromDb = ld.getById("af4d327f-3649-4807-97ae-dd9a50def684");


        // Creazione di 4 partite di esempio
        FootballMatch match1 = new FootballMatch(
                "Champions League Final",
                LocalDate.of(2024, 5, 25),
                "Final match of the Champions League.",
                EventType.PRIVATE,
                80000,
                lfromDb,
                "Real Madrid",
                "Manchester City",
                "Real Madrid",
                2,
                1
        );

        FootballMatch match2 = new FootballMatch(
                "Premier League Matchday 15",
                LocalDate.of(2024, 12, 1),
                "Important Premier League match.",
                EventType.PRIVATE,
                60000,
                lfromDb,
                "Liverpool",
                "Chelsea",
                "Liverpool",
                3,
                2
        );

        FootballMatch match3 = new FootballMatch(
                "Serie A Matchday 18",
                LocalDate.of(2024, 1, 21),
                "Top match in the Serie A.",
                EventType.PRIVATE,
                50000,
                l3fromDb,
                "AC Milan",
                "Inter Milan",
                "Inter Milan",

                0,
                1
        );

        FootballMatch match4 = new FootballMatch(
                "La Liga El Clasico",
                LocalDate.of(2024, 3, 2),
                "The famous clash between Barcelona and Real Madrid.",
                EventType.PRIVATE,
                90000,
                l4fromDb,
                "Barcelona",
                "Real Madrid",
                "Barcelona",
                3,
                2
        );

        Concert concert1 = new Concert(
                "ROLLING STONES",
                LocalDate.of(2010, 11, 15),
                "A live concert featuring legendary rock bands.",
                EventType.PRIVATE,
                30000,
                lfromDb,
                GenresType.ROCK,
                true
        );

        Concert concert2 = new Concert(
                "Ludovico Einaudi",
                LocalDate.of(2013, 9, 10),
                "An evening of beautiful classical music performances.",
                EventType.PRIVATE,
                5000,
                l2fromDb,
                GenresType.CLASSIC,
                false
        );

        /*// Match event saved on Table Event
        ed.save(match1);
        ed.save(match2);
        ed.save(match3);
        ed.save(match4);

        // Concert event saved on Table Event
        ed.save(concert1);
        ed.save(concert2);*/



        



        System.out.println("TUTTO OK!");
    }
}
