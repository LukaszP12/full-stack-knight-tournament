package com.clockworkjava.kursspring.services;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import com.clockworkjava.kursspring.domain.repository.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class KnightService {

    @Autowired
    private KnightRepository knightRepository;

    @Autowired
    private PlayerInformation playerInformation;

    public List<Knight> getAllKnights() throws NotImplementedException {
        return new ArrayList<>(knightRepository.getAllKnights());
    }

    public void saveKnight(Knight knight) throws NotImplementedException {
        knightRepository.createKnight(knight.getName(),knight.getAge());
    }

    public Knight getKnight(Integer id) throws NotImplementedException {
        return knightRepository.getKnightById(id);
    }

    public void deleteKnight(Integer id) throws NotImplementedException {
        knightRepository.deleteKnight(id);
    }

    public void updateKnight(Knight knight) throws NotImplementedException {
        knightRepository.updateKnight(knight.getId(), knight);
    }

    public int collectRewards() throws NotImplementedException {

        Predicate<Knight> knightPredicate = knight -> {
            if (knight.getQuest() != null) {
                return knight.getQuest().isCompleted();
            } else {
                return false;
            }
        };

        int sumOfRewards = knightRepository.getAllKnights().stream().filter(knightPredicate)
                .mapToInt(knight -> knight.getQuest().getReward())
                .sum();

        knightRepository.getAllKnights().stream().filter(knightPredicate).forEach(knight -> {
            knight.setQuest(null);
        });

        return sumOfRewards;
    }

    public void getMyGold() throws NotImplementedException {

        List<Knight> allKnights = getAllKnights();
        allKnights.stream().forEach(knight -> {
            if (knight.getQuest() != null) {
                knight.getQuest().isCompleted();
            }
        });

        int currentGold = playerInformation.getGold();
        playerInformation.setGold(currentGold + collectRewards());
    }

}
