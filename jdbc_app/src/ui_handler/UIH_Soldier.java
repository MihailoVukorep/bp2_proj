package ui_handler;

import model.Soldier;
import service.SoldierService;

import java.sql.SQLException;

public class UIH_Soldier {

    private static final SoldierService soldierService = new SoldierService();

    public void handle() {

        String answer;
        do {
            System.out.println("\nChoose option:");
            System.out.println("1 - Print All");
            System.out.println("2 - Show by ID");
            System.out.println("3 - Insert New");
            System.out.println("4 - Delete by ID");
            System.out.println("0 - Exit");
            System.out.print("> ");

            answer = MainUIHandler.sc.nextLine();

            switch (answer) {
                case "0": return;
                case "1": showAll(); break;
                case "2": showById(); break;
                case "3": InsertNew(); break;
                case "4": DeleteById(); break;
            }

        } while (!answer.equalsIgnoreCase("X"));
    }

    private void showAll() {
        System.out.println(Soldier.getFormattedHeader());

        try {
            for (Soldier soldier : soldierService.getAll()) {
                System.out.println(soldier.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showById() {
        System.out.print("ID: ");
        int id_sc = Integer.parseInt(MainUIHandler.sc.nextLine());
        try {
            Soldier soldier = soldierService.getById(id_sc);
            System.out.println(soldier.getFormattedHeader());
            System.out.println(soldier);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void InsertNew()
    {
        System.out.print("first name: ");
        String firstName = MainUIHandler.sc.nextLine().strip();
        System.out.print("last name.: ");
        String lastName = MainUIHandler.sc.nextLine().strip();

        Soldier soldier = new Soldier()

        try {
            soldierService.save(soldier);
            System.out.println(soldier.getFormattedHeader());
            System.out.println(soldier);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void DeleteById() {
        System.out.print("ID: ");
        int id_sc = Integer.parseInt(MainUIHandler.sc.nextLine());
        try {
            soldierService.deleteById(id_sc);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
