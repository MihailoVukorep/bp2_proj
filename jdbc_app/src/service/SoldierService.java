package service;

import dao.SoldierDAO;
import dao.impl.SoldierDAOImpl;
import dto.LatestSquadMemberDTO;
import dto.MedalRankLeaderBoardMemberDTO;
import dto.MissionLeaderBoardMemberDTO;
import model.Soldier;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<MissionLeaderBoardMemberDTO> getMissionLeaderBoard() throws SQLException {
        return soldierDAO.getMissionLeaderBoard();
    }

    public List<LatestSquadMemberDTO> getLatestSquadMembers() throws SQLException {
        return soldierDAO.getLatestSquadMembers();
    }

    public List<MedalRankLeaderBoardMemberDTO> getMedalRankLeaderBoard() throws SQLException {
        return soldierDAO.getMedalRankLeaderBoard();
    }

}
