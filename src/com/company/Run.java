package com.company;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Run {

    Run(ParseInfo parseInfo) throws IOException {

        parseInfo = new ParseInfo(new Team(), new Match());

        int selection;
        String[] teamsToSelect = new String[16];
        int count = 1;
        Scanner input = new Scanner(System.in);

        /***************************************************/
        System.out.println("\nWybierz drużynę:");
        System.out.println("-------------------------\n");
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 1; j++) {
                System.out.println(count + " - " + parseInfo.teams.getName().get(i)[j]);
                teamsToSelect[count - 1] = parseInfo.teams.getName().get(i)[j];
                count++;
            }
        }
        System.out.print("\nWybieram drużynę nr - ");

        try {
            selection = input.nextInt();
            if ((selection > 16) || (selection <= 0)) {
                System.out.println("Podałeś nieprawidłową liczbę.");
            } else {
                System.out.println("Wybrałeś drużynę " + teamsToSelect[selection - 1]);
            }
        } catch (InputMismatchException e) {
            System.out.println("\nPodaj LICZBĘ z zakresu 1-16");
        }

    }

}
