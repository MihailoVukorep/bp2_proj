package dto;

import java.sql.Date;

public class SoldierRankMedalsDTO {
    private int soldierId;
    private String firstName;
    private String lastName;
    private String rankName;
    private int totalMedals;
    private Date firstMissionStartDate;

    public static String getFormattedHeader() {
        return String.format("%-6s %-15s %-15s %-25s %-15s %-25s",
                "ID", "First Name", "Last Name", "Rank Name", "Total Medals", "First Mission Start Date");
    }

    @Override
    public String toString() {
        return String.format("%-6d %-15s %-15s %-25s %-15d %-25s",
                soldierId, firstName, lastName, rankName, totalMedals, firstMissionStartDate.toString());
    }

    public int getSoldierId() {
        return soldierId;
    }

    public void setSoldierId(int soldierId) {
        this.soldierId = soldierId;
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

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public int getTotalMedals() {
        return totalMedals;
    }

    public void setTotalMedals(int totalMedals) {
        this.totalMedals = totalMedals;
    }

    public Date getFirstMissionStartDate() {
        return firstMissionStartDate;
    }

    public void setFirstMissionStartDate(Date firstMissionStartDate) {
        this.firstMissionStartDate = firstMissionStartDate;
    }
}
