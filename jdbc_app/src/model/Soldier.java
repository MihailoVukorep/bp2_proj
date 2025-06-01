package model;

import java.sql.Date;

public class Soldier {
    private int id; // id
    private String firstName; // first_name
    private String lastName; // last_name
    private Date dateOfJoining; // date_of_joining
    private int rankId; // rank_id
    private int chiefId; // chief_id
    private int vehicleId; // vehicle_id
    private int barracksId; // barracks_id

    public static String getFormattedHeader() {
        return String.format("%-6s %-10s %-20s %-10s %-10s %-10s %-10s %-10s", "id", "firstName", "lastName", "dateOfJoining", "rankId", "chiefId", "vehicleId", "barracksId");
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfJoining=" + dateOfJoining +
                ", rank=" + rankId +
                ", chiefId=" + chiefId +
                ", vehicleId=" + vehicleId +
                ", barracksId=" + barracksId +
                '}';
    }

    public Soldier() {

    }

    public Soldier(int id, String firstName, String lastName, Date dateOfJoining, int rankId, int chiefId, int vehicleId, int barracksId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfJoining = dateOfJoining;
        this.rankId = rankId;
        this.chiefId = chiefId;
        this.vehicleId = vehicleId;
        this.barracksId = barracksId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public int getRankId() {
        return rankId;
    }

    public void setRankId(int rankId) {
        this.rankId = rankId;
    }

    public int getChiefId() {
        return chiefId;
    }

    public void setChiefId(int chiefId) {
        this.chiefId = chiefId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getBarracksId() {
        return barracksId;
    }

    public void setBarracksId(int barracksId) {
        this.barracksId = barracksId;
    }
}
