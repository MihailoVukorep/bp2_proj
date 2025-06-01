package ui_handler;

import model.Soldier;
import service.SoldierService;

import java.sql.SQLException;

public class SimpleQuery1UIHandler {
    private static final SoldierService soldierService = new SoldierService();
    private static final SoldierService missionService = new SoldierService();

    public void handle() {
        System.out.println("# Query: List out all soldiers.");
        System.out.println("Run Query? [Y/n]: ");
        System.out.print("> ");

        if (!MainUIHandler.sc.nextLine().equalsIgnoreCase("y")) {
            return;
        }

        System.out.println(Soldier.getFormattedHeader());

        try {
            for (Soldier soldier : soldierService.getAll()) {
                System.out.println(soldier.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
