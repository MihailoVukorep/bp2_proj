package dao;

import dto.MissionLocationDTO;
import model.Mission;

import java.sql.SQLException;

public interface MissionDAO extends CRUDDao<Mission, Integer> {

    MissionLocationDTO getLatestMissionLocation() throws SQLException;
}
