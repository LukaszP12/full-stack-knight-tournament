package com.clockworkjava.kursspring;

import com.clockworkjava.kursspring.domain.repository.InMemoryRepository;
import com.clockworkjava.kursspring.domain.Knight;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class KursspringApplicationTests {

    @Autowired
    Knight knight;

    @Autowired
    InMemoryRepository inMemoryRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCastle() {
        String except = "Znajduje sie tu zamek o nazwie Castle Black. Zamieszkaly przez rycerza Knight{name='Lancelot', age=29, ma za zadanie=Quest{description='Uratuj księżniczkę'}}";
        Assert.assertEquals(except, inMemoryRepository.toString());
    }

}
