package dao.impl;

import connection.ConnectionUtil_HikariCP;
import dao.SoldierDAO;
import dto.LatestSquadMemberDTO;
import dto.SoldierMissionCountRankDTO;
import dto.SoldierRankMedalsDTO;
import dto.SoldierMissionCountDTO;
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
    public List<SoldierMissionCountDTO> getMissionLeaderBoard() throws SQLException {

        String query = "SELECT s.id AS soldier_id, s.first_name, s.last_name, COUNT(p.mission_id) AS mission_count FROM Soldier s JOIN Participation p ON s.id = p.soldier_id GROUP BY s.id, s.first_name, s.last_name ORDER BY mission_count DESC";
        List<SoldierMissionCountDTO> list = new ArrayList<SoldierMissionCountDTO>();

        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                SoldierMissionCountDTO member = new SoldierMissionCountDTO();
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
    public List<SoldierMissionCountRankDTO> getMissionRankLeaderBoard() throws SQLException {

        String query = "SELECT s.id AS soldier_id, s.first_name, s.last_name, COUNT(p.mission_id) AS mission_count, r.id AS rank_id, r.name AS rank_name FROM Soldier s LEFT JOIN Participation p ON s.id = p.soldier_id LEFT JOIN Rank r ON s.rank_id = r.id GROUP BY s.id, s.first_name, s.last_name, r.id, r.name ORDER BY mission_count DESC";
        List<SoldierMissionCountRankDTO> list = new ArrayList<SoldierMissionCountRankDTO>();

        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                SoldierMissionCountRankDTO member = new SoldierMissionCountRankDTO();
                member.setSoldierId(resultSet.getInt(1));
                member.setFirstName(resultSet.getString(2));
                member.setLastName(resultSet.getString(3));
                member.setMissionCount(resultSet.getInt(4));
                member.setRankId(resultSet.getInt(5));
                member.setRankName(resultSet.getString(6));
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

    @Override
    public List<SoldierRankMedalsDTO> getMedalRankLeaderBoard() throws SQLException {
        String query = "SELECT s.id, s.first_name, s.last_name, r.name AS rank_name, COUNT(m.id) AS total_medals, MIN(ms.start_date) AS first_mission FROM Soldier s JOIN Rank r ON s.rank_id = r.id LEFT JOIN Participation p ON s.id = p.soldier_id LEFT JOIN Mission ms ON p.mission_id = ms.id LEFT JOIN Medal m ON p.id = m.participation_id GROUP BY s.id, s.first_name, s.last_name, r.name HAVING COUNT(m.id) > 2 ORDER BY total_medals DESC";
        List<SoldierRankMedalsDTO> list = new ArrayList<SoldierRankMedalsDTO>();

        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                SoldierRankMedalsDTO member = new SoldierRankMedalsDTO();
                member.setSoldierId(resultSet.getInt(1));
                member.setFirstName(resultSet.getString(2));
                member.setLastName(resultSet.getString(3));
                member.setRankName(resultSet.getString(4));
                member.setTotalMedals(resultSet.getInt(5));
                member.setFirstMissionStartDate(resultSet.getDate(6));
                list.add(member);
            }

        }
        return list;
    }

    @Override
    public void promoteSoldiers() throws SQLException {

        Connection conn = ConnectionUtil_HikariCP.getConnection();
        conn.setAutoCommit(false);

        try {
            PreparedStatement soldierStmt = conn.prepareStatement("SELECT id, rank_id FROM Soldier");
            ResultSet soldierRs = soldierStmt.executeQuery();

            while (soldierRs.next()) {
                int soldierId = soldierRs.getInt("id");
                int currentRank = soldierRs.getInt("rank_id");

                // count missions
                PreparedStatement missionCountStmt = conn.prepareStatement("SELECT COUNT(*) FROM Participation WHERE soldier_id = ?");
                missionCountStmt.setInt(1, soldierId);
                ResultSet missionRs = missionCountStmt.executeQuery();
                missionRs.next();
                int missionCount = missionRs.getInt(1);

                // new rank
                int calculatedRank = Math.min(1 + (missionCount / 5), 20); // Cap at max rank
                if (calculatedRank > currentRank) {
                    PreparedStatement promoteStmt = conn.prepareStatement("UPDATE Soldier SET rank_id = ? WHERE id = ?"); // promote
                    promoteStmt.setInt(1, calculatedRank);
                    promoteStmt.setInt(2, soldierId);
                    promoteStmt.executeUpdate();

                    // award new rifle to soldier (equipment_type_id 1 = rifle, storage_id = 1)
                    PreparedStatement awardStmt = conn.prepareStatement(
                            "INSERT INTO Equipment (id, status, equipment_type_id, soldier_id, storage_id) " +
                                    "VALUES (EQUIPMENT_SEQ.NEXTVAL, 1, 1, ?, 1)"
                    );
                    awardStmt.setInt(1, soldierId);
                    awardStmt.executeUpdate();
                    System.out.println("Promoted soldier " + soldierId + " to rank " + calculatedRank);
                }
            }

            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
            conn.close();
        }
    }

}
