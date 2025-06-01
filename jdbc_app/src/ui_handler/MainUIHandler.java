package ui_handler;

import java.util.Scanner;

public class MainUIHandler {

    public static Scanner sc = new Scanner(System.in);

    private final UIH_Soldier uih_soldier = new UIH_Soldier();

    public void handle() {

        String answer;
        do {
            System.out.println("\nAlter Tables:");
            System.out.println(" 1 - Soldiers");
            System.out.println(" 2 - Ranks");
            System.out.println(" 3 - Specialties");
            System.out.println(" 4 - Specializing");
            System.out.println(" 5 - Bases");
            System.out.println(" 6 - Equipment");
            System.out.println(" 7 - Equipment Types");
            System.out.println(" 8 - Locations");
            System.out.println(" 9 - Medals");
            System.out.println("10 - Medal Types");
            System.out.println("11 - Vehicle");
            System.out.println("12 - Vehicle Types");
            System.out.println("13 - Missions");
            System.out.println("14 - Participation");
            System.out.println(" 0 - Exit");
            System.out.print("> ");
            answer = sc.nextLine();

            switch (answer) {
                case "0": return;
                case "1": uih_soldier.handle(); break;
            }

        } while (!answer.equalsIgnoreCase("X"));

        sc.close();
    }

}
