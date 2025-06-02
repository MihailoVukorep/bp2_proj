package dao;

import dto.LatestSquadMemberDTO;
import dto.MissionLeaderBoardMemberDTO;
import model.Soldier;

import java.sql.SQLException;
import java.util.List;

public interface SoldierDAO extends CRUDDao<Soldier, Integer> {

    List<MissionLeaderBoardMemberDTO> getMissionLeaderBoard() throws SQLException;

    List<LatestSquadMemberDTO> getLatestSquadMembers() throws SQLException;
}
