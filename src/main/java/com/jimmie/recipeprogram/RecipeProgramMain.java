package com.jimmie.recipeprogram;

import java.util.Scanner;

public class RecipeProgramMain {
    public static void main(String[] args) {
        RecipeProgramMain recipeProgramMain = new RecipeProgramMain();
        recipeProgramMain.run();
    }

    private void run() {
        boolean done = false;
        while (!done) {
            done = doSomething();
        }
    }

    private boolean doSomething() {
        System.out.println("Welcome to Jim's old school recipe app!");
        System.out.println("What do you want to do?");
        System.out.println("1. Add recipe.");
        System.out.println("2. Search for recipe.");
        System.out.println("3. Quit.");
        int option = getIntOption(1,3);
        System.out.println("You chose " + option);
        return option == 3;
    }

    private int getIntOption(int min, int max) {
        int option = -1;
        Scanner scanner = new Scanner(System.in);
        while (option < min || option > max) {
            System.out.print("Please choose a number between " + min + " and " + max + ": ");
            option = scanner.nextInt();
        }
        return option;
    }
}
