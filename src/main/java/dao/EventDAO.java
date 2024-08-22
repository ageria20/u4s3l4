package dao;

import entities.Concert;
import entities.Event;
import enums.GenresType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;


public class EventDAO {
    private EntityManager em;

    public EventDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Event event){
        EntityTransaction transaction = em.getTransaction(); // Chiediamo all'entity la transazione
        transaction.begin();
        em.persist(event); // Aggiungiamo il dato al Persist Context, ma ancora non risulta salvato
        // Conlucdiamo la transazione, salvando il dato nel DB
        transaction.commit(); // dato salavto
    }


    public Event getById(String id){
        Event found = em.find(Event.class, UUID.fromString(id));
        if( found == null) throw new RuntimeException("Evento non trovato");
        else return found;
    }

    public void delete(String id){
        Event eventToDelete = getById(id); // Cerchiamo l'id del dato
        EntityTransaction transaction = em.getTransaction(); // Chidiamo all'eneity di aprire una transaction
        transaction.begin(); // iniziamo la Transaction
        em.remove(eventToDelete); // Rimuoviamo il dato dal Persist Context (qui ancora non risulta eliminato dal Database)
        transaction.commit(); // Qui il dato è rimosso.
    }

    public List<Event> getIsStreamingConcert() {
        TypedQuery<Event> query = em.createQuery("SELECT c FROM Event c WHERE isStreaming = true", Event.class);
        return query.getResultList();
    }

    public List<Event> getConcertByGenre(GenresType genre) {
        TypedQuery<Event> query = em.createQuery("SELECT c FROM Event c WHERE genre = :g", Event.class);
        query.setParameter(":g", genre);
        return query.getResultList();
    }

}
