package com.clockworkjava.kursspring.domain;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class QuestTest {

    @Test
    public void settingStartedFlagToFalseShouldSetStartDate() {
        // given
        Quest quest = new Quest(1, "Testowe zadanie");

        // when
        quest.setStarted(true);

        // then
        Assert.assertNotNull(quest.startDate);
    }

    @Test
    public void questShouldBeCompleted() {
        // given
        Quest quest = new Quest(1, "Testowe zadanie");
        quest.setStarted(true);

        // when
        quest.lenghtInSeconds = -60;

        // then
        Assert.assertTrue(quest.isCompleted());
        Assert.assertTrue(quest.isCompleted());
    }

    @Test
    public void questShouldNotBeCompleted() {
        // given
        Quest quest = new Quest(1, "Testowe zadanie");
        quest.setStarted(true);

        // when
        quest.lenghtInSeconds = 20000;

        // then
        Assert.assertFalse(quest.isCompleted());
        Assert.assertFalse(quest.isCompleted());
    }

}