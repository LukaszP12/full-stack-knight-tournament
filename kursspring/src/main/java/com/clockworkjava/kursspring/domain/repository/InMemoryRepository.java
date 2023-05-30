package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.utils.Ids;
import jakarta.annotation.PostConstruct;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryRepository implements KnightRepository {

    Map<Integer, Knight> knights = new HashMap<>();

    public InMemoryRepository() {

    }

    @Override
    public void createKnight(String name, int age) throws NotImplementedException {
        Knight knight = new Knight(name, age);
        knight.setId(Ids.getNewId(knights.keySet()));
        knights.put(knight.getId(), knight);
    }

    private int getNewId() {
        if (knights.isEmpty()) {
            return 0;
        } else {
            Integer integer = knights.keySet().stream().max(Integer::max).get();
            return integer + 1;
        }
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return knights.values();
    }

    @Override
    public Optional<Knight> getKnight(String name) {

        Optional<Knight> knightByName = knights.values()
                .stream()
                .filter(knight -> knight.getName().equals(name))
                .findAny();

        return knightByName;
    }

    @Override
    public void deleteKnight(Integer id) {
        knights.remove(id);
    }

    @Override
    public Knight getKnightById(Integer id) throws NotImplementedException {
        return knights.get(id);
    }

    @Override
    public void updateKnight(int id, Knight knight) throws NotImplementedException {
        knights.put(id, knight);
    }

    @Override
    @PostConstruct
    public void build() throws NotImplementedException {
        createKnight("Lancelot", 29);
        createKnight("Percival", 25);
    }

    @Override
    public String toString() {
        return "KnightRepository{" +
                "knights=" + knights +
                '}';
    }
}
