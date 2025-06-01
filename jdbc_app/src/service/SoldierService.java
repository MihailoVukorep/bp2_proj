package service;

import dao.SoldierDAO;
import dao.impl.SoldierDAOImpl;
import model.Soldier;

import java.sql.SQLException;
import java.util.ArrayList;

public class SoldierService {
    private static final SoldierDAO soldierDAO = new SoldierDAOImpl();

    public ArrayList<Soldier> getAll() throws SQLException {
        return (ArrayList<Soldier>) soldierDAO.findAll();
    }

    public Soldier getById(int id) throws SQLException {
        return soldierDAO.findById(id);
    }

    public void deleteById(int id) throws SQLException {
        soldierDAO.deleteById(id);
    }

    public void save(Soldier soldier) throws SQLException {
        soldierDAO.save(soldier);
    }
}
