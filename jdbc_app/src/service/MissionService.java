package service;

import dao.MissionDAO;
import dao.impl.MissionDAOImpl;
import model.Mission;
import model.Soldier;

import java.sql.SQLException;
import java.util.ArrayList;

public class MissionService {
    private static final MissionDAO missionDao = new MissionDAOImpl();

    public ArrayList<Mission> getAll() throws SQLException {
        return (ArrayList<Mission>) missionDao.findAll();
    }

    public Mission getById(int id) throws SQLException {
        return missionDao.findById(id);
    }

    public void deleteById(int id) throws SQLException {
        missionDao.deleteById(id);
    }

    public void save(Mission mission) throws SQLException {
        missionDao.save(mission);
    }
}
