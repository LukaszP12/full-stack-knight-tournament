package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Quest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Repository
public class QuestRepository {

    @PersistenceContext
    private EntityManager em;

    Random rand = new Random();

    Map<Integer, Quest> quests = new HashMap<>();

    @Transactional
    public void createQuest(String description) {
        Quest newQuest = new Quest(description);
        em.persist(newQuest);
        System.out.println(newQuest);
    }

    public List<Quest> getAll() {
        return em.createQuery("from Quest", Quest.class).getResultList();
    }

    @Transactional
    public void deleteQuest(Quest quest) {
        em.remove(quest);
    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "questList=" + quests +
                '}';
    }

    @Scheduled(fixedDelayString = "${questCreationDelay}")
    @Transactional
    public void createRandomQuest() {
        List<String> descriptions = new ArrayList<>();

        descriptions.add("Uratuj księżniczkę");
        descriptions.add("Wez udział w turnieju");
        descriptions.add("Zabij bande goblinów");
        descriptions.add("Zabij smoka");

        String description = descriptions.get(rand.nextInt(descriptions.size()));
        createQuest(description);
    }

    @Transactional
    public void update(Quest quest) {
        em.merge(quest);
    }

    public Quest getQuest(Integer id) {
        return em.find(Quest.class, id);
    }
}
