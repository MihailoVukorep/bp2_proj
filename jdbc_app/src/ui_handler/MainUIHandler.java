package ui_handler;

import java.util.Scanner;

public class MainUIHandler {

    public static Scanner sc = new Scanner(System.in);

    private final BasicQueryUIHandler basicQueryUIHandler = new BasicQueryUIHandler();
    private final SimpleQuery1UIHandler simpleQuery1UIHandler = new SimpleQuery1UIHandler();
    private final SimpleQuery2UIHandler simpleQuery2UIHandler = new SimpleQuery2UIHandler();
    private final ComplexQueryUIHandler complexQueryUIHandler = new ComplexQueryUIHandler();
    private final TransactionalQueryUIHandler transactionalQueryUIHandler = new TransactionalQueryUIHandler();

    public void handle() {

        String answer;
        do {
            System.out.println("\nMenu:");
            System.out.println(" 1 - Basic Query - List Soldiers");
            System.out.println(" 2 - Simple Query - Soldier mission count leaderboard descending.");
            System.out.println(" 3 - Simple Query - List out latest mission and it's soldiers.");
            System.out.println(" 4 - Complex Query - ...");
            System.out.println(" 5 - Transactional Query - ...");
            System.out.println(" 0 - Exit");
            System.out.print("> ");
            answer = sc.nextLine();

            switch (answer) {
                case "0": return;
                case "1": basicQueryUIHandler.handle(); break;
                case "2": simpleQuery1UIHandler.handle(); break;
                case "3": simpleQuery2UIHandler.handle(); break;
                case "4": complexQueryUIHandler.handle(); break;
                case "5": transactionalQueryUIHandler.handle(); break;
            }

        } while (!answer.equalsIgnoreCase("X"));

        sc.close();
    }

}
