package ui_handler;

import dto.LatestSquadMemberDTO;
import dto.MissionLocationDTO;
import model.Soldier;
import service.MissionService;
import service.SoldierService;

import java.sql.SQLException;

public class SimpleQuery2UIHandler {
    private static final SoldierService soldierService = new SoldierService();
    private static final MissionService missionService = new MissionService();

    public void handle() {
        System.out.println("-- Simple Query: List out latest mission location and it's soldiers.");
        System.out.println();
        System.out.println("SELECT m.*, l.country, l.city\n" +
                           "FROM Mission m\n" +
                           "JOIN Location l ON m.location_id = l.id\n" +
                           "WHERE m.start_date = (SELECT MAX(start_date) FROM Mission);");
        System.out.println("");
        System.out.println("SELECT \n" +
                "    s.id AS soldier_id,\n" +
                "    s.first_name,\n" +
                "    s.last_name\n" +
                "FROM \n" +
                "    Mission m\n" +
                "JOIN \n" +
                "    Participation p ON m.id = p.mission_id\n" +
                "JOIN \n" +
                "    Soldier s ON p.soldier_id = s.id\n" +
                "WHERE \n" +
                "    m.start_date = (\n" +
                "        SELECT MAX(start_date)\n" +
                "        FROM Mission\n" +
                "    );");
        System.out.println("");
        System.out.println("Run Query? [Y/n]: ");
        System.out.print("> ");

        if (!MainUIHandler.sc.nextLine().equalsIgnoreCase("y")) {
            return;
        }


        try {
            System.out.println("===[ MISSION: ");
            System.out.print("| ");
            System.out.println(MissionLocationDTO.getFormattedHeader());
            System.out.print("| ");
            System.out.println(missionService.getLatestMissionLocation());
            System.out.println("+----------------------------------------------------------------------------------------------------------------------------------");

            System.out.print("| | ");
            System.out.println(LatestSquadMemberDTO.getFormattedHeader());
            System.out.println("| |--------------------------------------------------------------------------------------------------------------------------------");

            for (LatestSquadMemberDTO member : soldierService.getLatestSquadMembers()) {
                System.out.print("| | ");
                System.out.println(member.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
