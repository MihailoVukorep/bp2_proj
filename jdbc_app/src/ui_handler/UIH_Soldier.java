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
            System.out.println("1 - print all");
            System.out.println("2 - Prikaz po identifikatoru");

            answer = MainUIHandler.sc.nextLine();

            switch (answer) {
                case "1":
                    showAll();
                    break;
                case "2":
                    showById();
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
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
        System.out.println("ID: ");
        int id_sc = Integer.parseInt(MainUIHandler.sc.nextLine());
        try {
            Soldier soldier = soldierService.getById(id_sc);
            //System.out.println(soldier.getFormattedHeader());
            System.out.println(soldier);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
