package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;

import java.util.Collection;
import java.util.Optional;

public class DBKnightRepository implements KnightRepository {

    @Override
    public void createKnight(Knight knight) throws NotImplementedException {
        System.out.println("używam bazy danych");
        throw new NotImplementedException();
    }

    @Override
    public Collection<Knight> getAllKnights() throws NotImplementedException {
        System.out.println("używam bazy danych");
        throw new NotImplementedException();
    }

    @Override
    public Optional<Knight> getKnight(String name) throws NotImplementedException {
        System.out.println("używam bazy danych");
        throw new NotImplementedException();
    }

    @Override
    public void deleteKnight(Integer id) throws NotImplementedException {
        System.out.println("używam bazy danych");
        throw new NotImplementedException();
    }

    @Override
    public void build() {
        System.out.println("używam bazy danych");
    }

    @Override
    public Knight getKnightById(Integer id) throws NotImplementedException {
        System.out.println("używam bazy danych");
        throw new NotImplementedException();
    }
}
