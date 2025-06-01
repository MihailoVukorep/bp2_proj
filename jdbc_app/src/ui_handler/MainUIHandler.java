package ui_handler;

import java.util.Scanner;

public class MainUIHandler {

    public static Scanner sc = new Scanner(System.in);

    private final UIH_Soldier uih_soldier = new UIH_Soldier();

    public void handle() {

        String answer;
        do {
            System.out.println("\nAlter Tables:");
            System.out.println("1 - Soldiers");
            System.out.println("2 - Ranks");
            System.out.println("3 - Bases");
            System.out.println("4 - ...");

            answer = sc.nextLine();

            switch (answer) {
                case "1": uih_soldier.handle(); break;
            }

        } while (!answer.equalsIgnoreCase("X"));

        sc.close();
    }

}
