package ui_handler;

import dto.MedalRankLeaderBoardMemberDTO;
import model.Soldier;
import service.SoldierService;

import java.sql.SQLException;

public class ComplexQueryUIHandler {

    private static final SoldierService soldierService = new SoldierService();

    public void handle() {
        System.out.println(
                "-- Complex Query: List all soldiers with their rank, first mission (beginning of service), and number of medals,\n" +
                "-- Only show those with more than 2 medals, sorted by medal count.\n" +
                "\n" +
                "SELECT s.id, s.first_name, s.last_name, r.name AS rank_name, \n" +
                "       COUNT(m.id) AS total_medals,\n" +
                "       MIN(ms.start_date) AS first_mission\n" +
                "FROM Soldier s\n" +
                "JOIN Rank r ON s.rank_id = r.id\n" +
                "LEFT JOIN Participation p ON s.id = p.soldier_id\n" +
                "LEFT JOIN Mission ms ON p.mission_id = ms.id\n" +
                "LEFT JOIN Medal m ON p.id = m.participation_id\n" +
                "GROUP BY s.id, s.first_name, s.last_name, r.name\n" +
                "HAVING COUNT(m.id) > 2\n" +
                "ORDER BY total_medals DESC;");
        System.out.println("");
        System.out.println("Run Query? [Y/n]: ");
        System.out.print("> ");

        if (!MainUIHandler.sc.nextLine().equalsIgnoreCase("y")) {
            return;
        }

        System.out.println(MedalRankLeaderBoardMemberDTO.getFormattedHeader());

        try {
            for (MedalRankLeaderBoardMemberDTO memberDTO : soldierService.getMedalRankLeaderBoard()) {
                System.out.println(memberDTO.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
