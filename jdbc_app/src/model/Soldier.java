package model;

import java.sql.Date;

public class Soldier {
    private int id; // S_ID
    private String firstName; // FIRST_NAME
    private String lastName; // LAST_NAME
    private Date dateOfJoining; // DATE_OF_JOINING
    private int rank; // RANK_R_ID
    private int chiefId; // SOLDIER_S_ID
    private int drives; // VEHICLE_V_ID
    private int sleepsAt; // BARRACKS_BB_ID

    public static String getFormattedHeader() {
        return String.format("%-6s %-10s %-20s %-10s %-10s %-10s %-10s %-10s", "id", "firstName", "lastName", "dateOfJoining", "rank", "chiefId", "drives", "sleepsAt");
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfJoining=" + dateOfJoining +
                ", rank=" + rank +
                ", chiefId=" + chiefId +
                ", drives=" + drives +
                ", sleepsAt=" + sleepsAt +
                '}';
    }

    public Soldier() {

    }

    public Soldier(int id, String firstName, String lastName, Date dateOfJoining, int rank, int chiefId, int drives, int sleepsAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfJoining = dateOfJoining;
        this.rank = rank;
        this.chiefId = chiefId;
        this.drives = drives;
        this.sleepsAt = sleepsAt;
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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getChiefId() {
        return chiefId;
    }

    public void setChiefId(int chiefId) {
        this.chiefId = chiefId;
    }

    public int getDrives() {
        return drives;
    }

    public void setDrives(int drives) {
        this.drives = drives;
    }

    public int getSleepsAt() {
        return sleepsAt;
    }

    public void setSleepsAt(int sleepsAt) {
        this.sleepsAt = sleepsAt;
    }
}
