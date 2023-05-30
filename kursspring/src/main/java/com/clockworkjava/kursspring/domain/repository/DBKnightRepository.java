package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.Collection;
import java.util.Optional;

public class DBKnightRepository implements KnightRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void createKnight(String name, int age) {
        Knight knight = new Knight(name, age);
        em.persist(knight);
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return em.createQuery("from Knight", Knight.class).getResultList();
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        Knight knight = em.createQuery("from Knight k where k.name=:name", Knight.class)
                .setParameter("name", name).getSingleResult();

        return Optional.ofNullable(knight);
    }

    @Override
    @Transactional
    public void deleteKnight(Integer id) {
        em.remove(getKnightById(id));
    }

    @Override
    public Knight getKnightById(Integer id) {
        return em.find(Knight.class, id);
    }

    @Override
    @Transactional
    public void updateKnight(int id, Knight knight) {
        em.merge(knight);
    }

    @Override
    public void build() {

    }
}
