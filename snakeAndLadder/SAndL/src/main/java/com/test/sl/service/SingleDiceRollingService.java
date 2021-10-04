package com.test.sl.service;

import com.test.sl.model.DiceStrategy;

import java.util.Random;

public class SingleDiceRollingService implements DiceRollingService{
    Random rand = new Random();
    @Override
    public Integer getRollingNumber() {
        int rand_int1 = rand.nextInt(7);
        return rand_int1==0 ? 1 : rand_int1;
    }
}
