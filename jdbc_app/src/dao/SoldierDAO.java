package dao;

import dto.LatestSquadMemberDTO;
import dto.MedalRankLeaderBoardMemberDTO;
import dto.MissionLeaderBoardMemberDTO;
import model.Soldier;

import java.sql.SQLException;
import java.util.List;

public interface SoldierDAO extends CRUDDao<Soldier, Integer> {

    List<MissionLeaderBoardMemberDTO> getMissionLeaderBoard() throws SQLException;

    List<LatestSquadMemberDTO> getLatestSquadMembers() throws SQLException;

    List<MedalRankLeaderBoardMemberDTO> getMedalRankLeaderBoard() throws SQLException;
}
