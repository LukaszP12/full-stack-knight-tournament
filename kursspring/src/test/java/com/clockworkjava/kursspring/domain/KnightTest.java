package com.clockworkjava.kursspring.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTest {

    @Test
    public void testIfQuestMarkedAsStarted() {
        // given
        Knight knight = new Knight("Percival", 25);
        Quest quest = new Quest(1, "Testowe zadanie");

        // when
        knight.setQuest(quest);

        // then
        assertTrue(knight.getQuest().isStarted());
    }

}
