package com.test.sl.service;

import java.util.Random;

public class DoubleDiceRollingService implements DiceRollingService{
    Random rand = new Random();
    @Override
    public Integer getRollingNumber() {
        int rand_int1 = rand.nextInt(7);
        rand_int1 = rand_int1==0 ? 1 : rand_int1;
        int rand_int2 = rand.nextInt(7);
        rand_int2 = rand_int2==0 ? 1 : rand_int2;
        return rand_int1+rand_int2;

    }
}
