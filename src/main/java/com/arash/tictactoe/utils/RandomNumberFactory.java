package com.arash.tictactoe.utils;

import java.util.Random;

public abstract class RandomNumberFactory {

    private static final Random RANDOM = new Random();

    public static int nextInt(int bound) {
        return RANDOM.nextInt(bound);
    }
}
