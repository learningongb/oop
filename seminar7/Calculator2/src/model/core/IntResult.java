package model.core;

import model.interfaces.iResult;

import java.util.Scanner;

public class IntResult implements iResult {
    public int value;

    public IntResult(int primaryArg) {
        this.value = primaryArg;
    }

    public IntResult() {
        this(0);
    }

    public iResult promptArgument(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message + ": ");
        this.value = Integer.parseInt(in.nextLine());
        return this;
    }

    @Override
    public String getResultString() {
        return String.format("%d", value);
    }
}
