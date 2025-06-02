package dao;

import dto.LatestSquadMemberDTO;
import dto.SoldierMissionCountRankDTO;
import dto.SoldierRankMedalsDTO;
import dto.SoldierMissionCountDTO;
import model.Soldier;

import java.sql.SQLException;
import java.util.List;

public interface SoldierDAO extends CRUDDao<Soldier, Integer> {

    List<SoldierMissionCountDTO> getMissionLeaderBoard() throws SQLException;

    List<LatestSquadMemberDTO> getLatestSquadMembers() throws SQLException;

    List<SoldierRankMedalsDTO> getMedalRankLeaderBoard() throws SQLException;

    void promoteSoldiers() throws SQLException;

    public List<SoldierMissionCountRankDTO> getMissionRankLeaderBoard() throws SQLException;
}
