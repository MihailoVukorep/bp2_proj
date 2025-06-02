package ui_handler;

import dto.MissionLeaderBoardMemberDTO;
import model.Soldier;
import service.SoldierService;

import java.sql.SQLException;

public class SimpleQuery1UIHandler {
    private static final SoldierService soldierService = new SoldierService();
    private static final SoldierService missionService = new SoldierService();

    public void handle() {
        System.out.println("-- Query: Soldier mission count leaderboard descending.");
        System.out.println("");
        System.out.println("SELECT \n" +
                           "    s.id AS soldier_id,\n" +
                           "    s.first_name,\n" +
                           "    s.last_name,\n" +
                           "    COUNT(p.mission_id) AS mission_count\n" +
                           "FROM \n" +
                           "    Soldier s\n" +
                           "JOIN \n" +
                           "    Participation p ON s.id = p.soldier_id\n" +
                           "GROUP BY \n" +
                           "    s.id, s.first_name, s.last_name\n" +
                           "ORDER BY \n" +
                           "    mission_count DESC;");

        System.out.println("Run Query? [Y/n]: ");
        System.out.print("> ");

        if (!MainUIHandler.sc.nextLine().equalsIgnoreCase("y")) {
            return;
        }

        System.out.println(MissionLeaderBoardMemberDTO.getFormattedHeader());

        try {
            for (MissionLeaderBoardMemberDTO memberDTO : soldierService.getMissionLeaderBoard()) {
                System.out.println(memberDTO.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
