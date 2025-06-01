package dao.impl;

import connection.ConnectionUtil_HikariCP;
import dao.SoldierDAO;
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

        return 0;
    }

    @Override
    public boolean delete(Soldier entity) throws SQLException {
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
    public Iterable<Soldier> findAll() throws SQLException {

        String query = "select s_id, first_name, last_name, date_of_joining, rank_r_id, soldier_s_id, vehicle_v_id, barracks_bb_id from soldier";
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
                soldier.setRank(resultSet.getInt(5));
                soldier.setChiefId(resultSet.getInt(6));
                soldier.setDrives(resultSet.getInt(7));
                soldier.setSleepsAt(resultSet.getInt(8));
                list.add(soldier);
            }

        }
        catch (Exception e) {
            System.out.printf(e.getMessage());
        }
        System.out.println(list.stream().count());
        return list;
    }

    @Override
    public Iterable<Soldier> findAllById(Iterable<Integer> ids) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Soldier findById(Integer id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean save(Soldier entity) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int saveAll(Iterable<Soldier> entities) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }
}
