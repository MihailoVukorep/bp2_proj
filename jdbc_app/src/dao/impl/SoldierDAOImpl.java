package dao.impl;

import connection.ConnectionUtil_HikariCP;
import dao.SoldierDAO;
import dto.LatestSquadMemberDTO;
import dto.MissionLeaderBoardMemberDTO;
import model.Soldier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SoldierDAOImpl implements SoldierDAO {
    @Override
    public int count() throws SQLException {
        String query = "select count(*) from soldier";
        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }

    @Override
    public boolean delete(Soldier entity) throws SQLException {
        return deleteById(entity.getId());
    }

    @Override
    public int deleteAll() throws SQLException {
        String query = "DELETE FROM soldier";
        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            return stmt.executeUpdate();
        }
    }

    @Override
    public boolean deleteById(Integer id) throws SQLException {
        String query = "DELETE FROM soldier WHERE s_id = ?";
        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean existsById(Integer id) throws SQLException {
        String query = "SELECT 1 FROM soldier WHERE s_id = ?";
        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    @Override
    public Iterable<Soldier> findAll() throws SQLException {

        String query = "select id, first_name, last_name, date_of_joining, rank_id, chief_id, vehicle_id, barracks_id from soldier";
        List<Soldier> list = new ArrayList<Soldier>();

        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Soldier soldier = new Soldier();
                soldier.setId(resultSet.getInt(1));
                soldier.setFirstName(resultSet.getString(2));
                soldier.setLastName(resultSet.getString(3));
                soldier.setDateOfJoining(resultSet.getDate(4));
                soldier.setRankId(resultSet.getInt(5));
                soldier.setChiefId(resultSet.getInt(6));
                soldier.setVehicleId(resultSet.getInt(7));
                soldier.setBarracksId(resultSet.getInt(8));
                list.add(soldier);
            }

        }
        return list;
    }

    @Override
    public Iterable<Soldier> findAllById(Iterable<Integer> ids) throws SQLException {
        List<Soldier> result = new ArrayList<>();
        String query = "SELECT id, first_name, last_name, date_of_joining, rank_id, chief_id, vehicle_id, barracks_id FROM soldier WHERE id = ?";
        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            for (Integer id : ids) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Soldier soldier = new Soldier();
                        soldier.setId(rs.getInt(1));
                        soldier.setFirstName(rs.getString(2));
                        soldier.setLastName(rs.getString(3));
                        soldier.setDateOfJoining(rs.getDate(4));
                        soldier.setRankId(rs.getInt(5));
                        soldier.setChiefId(rs.getInt(6));
                        soldier.setVehicleId(rs.getInt(7));
                        soldier.setBarracksId(rs.getInt(8));
                        result.add(soldier);
                    }
                }
            }
        }
        return result;
    }

    @Override
    public Soldier findById(Integer id) throws SQLException {
        String query = "SELECT id, first_name, last_name, date_of_joining, rank_id, chief_id, vehicle_id, barracks_id FROM soldier WHERE id = ?";
        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Soldier soldier = new Soldier();
                    soldier.setId(rs.getInt(1));
                    soldier.setFirstName(rs.getString(2));
                    soldier.setLastName(rs.getString(3));
                    soldier.setDateOfJoining(rs.getDate(4));
                    soldier.setRankId(rs.getInt(5));
                    soldier.setChiefId(rs.getInt(6));
                    soldier.setVehicleId(rs.getInt(7));
                    soldier.setBarracksId(rs.getInt(8));
                    return soldier;
                }
            }
        }
        return null;
    }

    @Override
    public boolean save(Soldier entity) throws SQLException {
        String query = "INSERT INTO soldier (id, first_name, last_name, date_of_joining, rank_id, chief_id, vehicle_id, barracks_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, entity.getId());
            stmt.setString(2, entity.getFirstName());
            stmt.setString(3, entity.getLastName());
            stmt.setDate(4, new java.sql.Date(entity.getDateOfJoining().getTime()));
            stmt.setInt(5, entity.getRankId());
            stmt.setInt(6, entity.getChiefId());
            stmt.setInt(7, entity.getVehicleId());
            stmt.setInt(8, entity.getBarracksId());
            return stmt.executeUpdate() > 0;
        }
    }


    @Override
    public int saveAll(Iterable<Soldier> entities) throws SQLException {
        String query = "INSERT INTO soldier (id, first_name, last_name, date_of_joining, rank_id, chief_id, vehicle_id, barracks_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        int count = 0;
        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            for (Soldier entity : entities) {
                stmt.setInt(1, entity.getId());
                stmt.setString(2, entity.getFirstName());
                stmt.setString(3, entity.getLastName());
                stmt.setDate(4, new java.sql.Date(entity.getDateOfJoining().getTime()));
                stmt.setInt(5, entity.getRankId());
                stmt.setInt(6, entity.getChiefId());
                stmt.setInt(7, entity.getVehicleId());
                stmt.setInt(8, entity.getBarracksId());
                stmt.addBatch();
                count++;
            }
            stmt.executeBatch();
        }
        return count;
    }

    @Override
    public List<MissionLeaderBoardMemberDTO> getMissionLeaderBoard() throws SQLException {

        String query = "SELECT s.id AS soldier_id, s.first_name, s.last_name, COUNT(p.mission_id) AS mission_count FROM Soldier s JOIN Participation p ON s.id = p.soldier_id GROUP BY s.id, s.first_name, s.last_name ORDER BY mission_count DESC";
        List<MissionLeaderBoardMemberDTO> list = new ArrayList<MissionLeaderBoardMemberDTO>();

        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                MissionLeaderBoardMemberDTO member = new MissionLeaderBoardMemberDTO();
                member.setSoldierId(resultSet.getInt(1));
                member.setFirstName(resultSet.getString(2));
                member.setLastName(resultSet.getString(3));
                member.setMissionCount(resultSet.getInt(4));
                list.add(member);
            }

        }
        return list;
    }

    @Override
    public List<LatestSquadMemberDTO> getLatestSquadMembers() throws SQLException {

        String query = "SELECT s.id AS soldier_id, s.first_name, s.last_name FROM Mission m JOIN Participation p ON m.id = p.mission_id JOIN Soldier s ON p.soldier_id = s.id WHERE m.start_date = ( SELECT MAX(start_date) FROM Mission )";
        List<LatestSquadMemberDTO> list = new ArrayList<LatestSquadMemberDTO>();

        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                LatestSquadMemberDTO member = new LatestSquadMemberDTO();
                member.setId(resultSet.getInt(1));
                member.setFirstName(resultSet.getString(2));
                member.setLastName(resultSet.getString(3));
                list.add(member);
            }

        }
        return list;
    }
}
