package model;

import java.sql.Date;

public class Soldier {
    private int id; // id
    private String firstName; // first_name
    private String lastName; // last_name
    private Date dateOfJoining; // date_of_joining
    private int rank; // rank_id
    private int chiefId; // chief_id
    private int drives; // vehicle_id
    private int sleepsAt; // barracks_id

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
