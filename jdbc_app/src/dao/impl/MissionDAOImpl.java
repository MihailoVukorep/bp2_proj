package dao.impl;

import dao.MissionDAO;
import model.Mission;

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

}
