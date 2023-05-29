package com.clockworkjava.kursspring.utils;

import java.util.Set;

public class Ids {

    static public int getNewId(Set<Integer> keysSoFar) {
        if (keysSoFar.isEmpty()) {
            return 0;
        } else {
            Integer integer = keysSoFar.stream().max((o1, o2) -> {
                return o1.compareTo(o2);
            }).get();
            return integer + 1;
        }
    }

}
