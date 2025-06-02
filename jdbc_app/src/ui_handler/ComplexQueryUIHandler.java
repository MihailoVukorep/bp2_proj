package ui_handler;

public class ComplexQueryUIHandler {
    public void handle() {
        System.out.println("");
        System.out.println("Run Query? [Y/n]: ");
        System.out.print("> ");

        if (!MainUIHandler.sc.nextLine().equalsIgnoreCase("y")) {
            return;
        }
    }
}
