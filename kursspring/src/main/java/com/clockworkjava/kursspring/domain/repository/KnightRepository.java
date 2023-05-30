package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

import java.util.Collection;
import java.util.Optional;

public interface KnightRepository {

    void createKnight(String name, int age) throws NotImplementedException;

    Collection<Knight> getAllKnights() throws NotImplementedException;

    Optional<Knight> getKnight(String name) throws NotImplementedException;

    void deleteKnight(Integer id) throws NotImplementedException;

    void build() throws NotImplementedException;

    Knight getKnightById(Integer id) throws NotImplementedException;

    default void updateKnight(int id, Knight knight) throws NotImplementedException {
        throw new NotImplementedException();
    }

}
