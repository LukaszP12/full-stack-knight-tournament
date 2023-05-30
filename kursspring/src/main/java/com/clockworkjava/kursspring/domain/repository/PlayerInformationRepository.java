package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.PlayerInformation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerInformationRepository {

    @PersistenceContext
    EntityManager em;

    public void createPlayerInformation(PlayerInformation playerInformation) {

        PlayerInformation pi = new PlayerInformation();

        em.persist(pi);

    }

    public PlayerInformation getFirst() {
        return em.createQuery("from PlayerInformation", PlayerInformation.class).getResultList().get(0);
    }
}
