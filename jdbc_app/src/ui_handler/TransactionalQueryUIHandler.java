package ui_handler;

import dto.SoldierMissionCountRankDTO;
import model.Soldier;
import service.SoldierService;

import java.sql.SQLException;

public class TransactionalQueryUIHandler {

    private static final SoldierService soldierService = new SoldierService();

    public void handle() {
        System.out.println("");
        System.out.println("Transactional Query: Update ranks based on how many missions soldier has been on,");
        System.out.println("                     and award a new rifle to soldier.");
        System.out.println(" - every 5 missions = +1 rank, +new rifle)");
        System.out.println("");
        System.out.println("Run Query? [Y/n]: ");
        System.out.print("> ");

        if (!MainUIHandler.sc.nextLine().equalsIgnoreCase("y")) {
            return;
        }


        try {

            System.out.println();
            System.out.println("BEFORE:");
            System.out.println(SoldierMissionCountRankDTO.getFormattedHeader());
            for (SoldierMissionCountRankDTO soldier : soldierService.getMissionRankLeaderBoard()) {
                System.out.println(soldier.toString());
            }

            System.out.println();
            System.out.println("PROMOTING SOLDIERS BY MISSION COUNT AND AWARDING WEAPONS...");
            System.out.println();
            soldierService.promoteAndEquipSoldiers();

            System.out.println();
            System.out.println("AFTER:");
            System.out.println(SoldierMissionCountRankDTO.getFormattedHeader());
            for (SoldierMissionCountRankDTO soldier : soldierService.getMissionRankLeaderBoard()) {
                System.out.println(soldier.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
