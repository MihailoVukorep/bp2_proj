package ui_handler;

import java.util.Scanner;

public class MainUIHandler {

    public static Scanner sc = new Scanner(System.in);

    private final BasicQueryUIHandler basicQueryUIHandler = new BasicQueryUIHandler();

    public void handle() {

        String answer;
        do {
            System.out.println("\nMenu:");
            System.out.println(" 1 - Basic Query - List Soldiers");
            System.out.println(" 2 - Simple Query - List Latest Missions (+Members)");
            System.out.println(" 3 - Complex Query - ...");
            System.out.println(" 4 - Transactional Query - ...");
            System.out.println(" 0 - Exit");
            System.out.print("> ");
            answer = sc.nextLine();

            switch (answer) {
                case "0": return;
                case "1": basicQueryUIHandler.handle(); break;
            }

        } while (!answer.equalsIgnoreCase("X"));

        sc.close();
    }

}
