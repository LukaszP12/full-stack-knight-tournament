package com.clockworkjava.kursspring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Entity
public class Knight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min = 2, max = 40, message = "Imie rycerza musi miec miedzy 2, a 40 znaków")
    private String name = "Lancelot";

    @NotNull
    @Range(min = 18, max = 60, message = "Rycerz musi miec conajmniej 18 lat, a nie wiecej niz 60")
    private int age = 29;

    private int level;

    @OneToOne
    private Quest quest;

    public Knight() {
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
        this.level = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knight knight = (Knight) o;
        return age == knight.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    public void setQuest(Quest quest) {
        if (quest != null) {
            quest.setStarted(true);
        }
        this.quest = quest;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Knight{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", ma za zadanie=" + quest +
                '}';
    }
}
