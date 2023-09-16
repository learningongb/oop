package model.core;

import model.interfaces.iResult;

import java.util.Scanner;

public class ComplexResult implements iResult {

    public int realValue;
    public int imgValue;

    public ComplexResult(int realValue, int imgValue) {
        this.realValue = realValue;
        this.imgValue = imgValue;
    }

    public ComplexResult() {
        this(0, 0);
    }

    @Override
    public String getResultString() {
        return String.format("%d + %di", realValue, imgValue);
    }

    @Override
    public iResult promptArgument(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message + " (действительная часть): ");
        this.realValue = Integer.parseInt(in.nextLine());
        System.out.print(message + " (мнимая часть): ");
        this.imgValue = Integer.parseInt(in.nextLine());
        return this;
    }
}