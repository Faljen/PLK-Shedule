package com.company;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Run {

    Run(ParseInfo parseInfo) throws IOException {

        parseInfo = new ParseInfo(new Team(), new Match());

        int selection;
        int homeGuestAll;
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
                System.out.println("\n1 - Mecze Domowe");
                System.out.println("2 - Mecze Wyjazdowe");
                System.out.println("3 - Wszystkie\n");
                homeGuestAll = input.nextInt();

                String selectedTeam = teamsToSelect[selection - 1];
                System.out.println("\nMecze drużyny " + selectedTeam + ":\n");

                if (homeGuestAll == 3) {
                    for (int i = 0; i < parseInfo.teams.getName().size(); i++) {
                        for (int j = 0; j <= 1; j++) {
                            if (parseInfo.teams.getName().get(i)[j].trim().equals(selectedTeam.trim())) {
                                System.out.println(parseInfo.teams.getName().get(i)[0].trim() + " - " + parseInfo.teams.getName().get(i)[1]);
                                if (parseInfo.matches.getDate().get(i) != null) {
                                    System.out.println(parseInfo.matches.getDate().get(i));
                                } else {
                                    System.out.println("TERMIN NIEUSTALONY");
                                }
                                if (parseInfo.matches.getHostPoints().get(i) != null) {
                                    System.out.println(parseInfo.matches.getHostPoints().get(i) + ":" + parseInfo.matches.getGuestPoints().get(i) + "\n");
                                } else {
                                    System.out.println("--:--\n");
                                }
                            }
                        }
                    }
                } else if (homeGuestAll == 2) {
                    for (int i = 0; i < parseInfo.teams.getName().size(); i++) {
                        if (parseInfo.teams.getName().get(i)[1].trim().equals(selectedTeam.trim())) {
                            System.out.println(parseInfo.teams.getName().get(i)[0].trim() + " - " + parseInfo.teams.getName().get(i)[1]);
                            if (parseInfo.matches.getDate().get(i) != null) {
                                System.out.println(parseInfo.matches.getDate().get(i));
                            } else {
                                System.out.println("TERMIN NIEUSTALONY");
                            }
                            if (parseInfo.matches.getHostPoints().get(i) != null) {
                                System.out.println(parseInfo.matches.getHostPoints().get(i) + ":" + parseInfo.matches.getGuestPoints().get(i) + "\n");
                            } else {
                                System.out.println("--:--\n");
                            }
                        }
                    }
                } else if (homeGuestAll == 1) {
                    for (int i = 0; i < parseInfo.teams.getName().size(); i++) {
                        if (parseInfo.teams.getName().get(i)[0].trim().equals(selectedTeam.trim())) {
                            System.out.println(parseInfo.teams.getName().get(i)[0].trim() + " - " + parseInfo.teams.getName().get(i)[1]);
                            if (parseInfo.matches.getDate().get(i) != null) {
                                System.out.println(parseInfo.matches.getDate().get(i));
                            } else {
                                System.out.println("TERMIN NIEUSTALONY");
                            }
                            if (parseInfo.matches.getHostPoints().get(i) != null) {
                                System.out.println(parseInfo.matches.getHostPoints().get(i) + ":" + parseInfo.matches.getGuestPoints().get(i) + "\n");
                            } else {
                                System.out.println("--:--\n");
                            }
                        }
                    }
                } else {
                    System.out.println("Nieprawidłowa wartość, proszę wybrać cyfrę od 1 do 3");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("\nPodaj LICZBĘ z zakresu 1-16");
        }

    }

}
