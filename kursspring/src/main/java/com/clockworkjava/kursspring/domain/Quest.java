package com.clockworkjava.kursspring.domain;

import java.time.LocalDateTime;

public class Quest {

    private String description;

    private int id;

    private int reward = 100;

    protected int lenghtInSeconds = 10;

    private boolean started = false;

    private boolean completed = false;

    protected LocalDateTime startDate;

    public Quest(int id, String description) {
        this.id = id;
        this.description = "Uratuj księżniczkę";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {

        if (started) {
            this.startDate = LocalDateTime.now();
        }

        this.started = started;
    }

    public boolean isQuestCompleted() {

        LocalDateTime now = LocalDateTime.now();


        return false;
    }

    public boolean isCompleted() {
        if (this.completed) {
            return this.completed;
        } else {
            LocalDateTime now = LocalDateTime.now();

            LocalDateTime questEndDate = this.startDate.plusSeconds(this.lenghtInSeconds);

            boolean isAfter = now.isAfter(questEndDate);

            if (isAfter) {
                this.completed = true;
            }

            return isAfter;
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    @Override
    public String toString() {
        return "Quest{" +
                "description='" + description + '\'' +
                '}';
    }

}
