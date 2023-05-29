package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import jakarta.annotation.PostConstruct;

import java.util.Collection;
import java.util.Optional;

public interface KnightRepository {

    void createKnight(Knight knight) throws NotImplementedException;

    Collection<Knight> getAllKnights() throws NotImplementedException;

    Optional<Knight> getKnight(String name) throws NotImplementedException;

    void deleteKnight(Integer id) throws NotImplementedException;

    void build();

    Knight getKnightById(Integer id) throws NotImplementedException;

    default void updateKnight(int id, Knight knight) throws NotImplementedException {
        throw new NotImplementedException();
    }

}
