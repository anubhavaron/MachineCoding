package com.test.sl.service;

import com.test.sl.model.DiceStrategy;

public class DiceServiceGetter {
    public static DiceRollingService getDiceSRollingService(DiceStrategy diceStrategy) {
        switch (diceStrategy) {
            case SINGLE_DICE: return new SingleDiceRollingService();
            case DOUBLE_DICE: return new DoubleDiceRollingService();
        }
        return new SingleDiceRollingService();
    }
}
