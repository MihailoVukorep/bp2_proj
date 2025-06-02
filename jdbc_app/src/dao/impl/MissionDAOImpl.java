package dao.impl;

import connection.ConnectionUtil_HikariCP;
import dao.MissionDAO;
import dto.MissionLocationDTO;
import model.Mission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MissionDAOImpl implements MissionDAO {
    @Override
    public int count() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean delete(Mission entity) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int deleteAll() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean deleteById(Integer id) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean existsById(Integer id) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterable<Mission> findAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<Mission> findAllById(Iterable<Integer> ids) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mission findById(Integer id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean save(Mission entity) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int saveAll(Iterable<Mission> entities) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public MissionLocationDTO getLatestMissionLocation() throws SQLException {
        String query = "SELECT m.id, m.name, m.description, m.start_date, m.end_date, l.country, l.city FROM Mission m JOIN Location l ON m.location_id = l.id WHERE m.start_date = (SELECT MAX(start_date) FROM Mission)";
        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    MissionLocationDTO mission = new MissionLocationDTO();
                    mission.setId(rs.getInt(1));
                    mission.setName(rs.getString(2));
                    mission.setDescription(rs.getString(3));
                    mission.setStartDate(rs.getDate(4));
                    mission.setEndDate(rs.getDate(5));
                    mission.setCountry(rs.getString(6));
                    mission.setCity(rs.getString(7));
                    return mission;
                }
            }
        }
        return null;
    }
}
