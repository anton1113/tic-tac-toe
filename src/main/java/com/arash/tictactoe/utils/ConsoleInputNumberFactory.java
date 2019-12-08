package com.arash.tictactoe.utils;

import java.util.Scanner;

public abstract class ConsoleInputNumberFactory {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int nextInt() {
        return SCANNER.nextInt();
    }
}
