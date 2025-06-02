package dto;

public class SoldierMissionCountRankDTO {

    private int soldierId;
    private String firstName;
    private String lastName;
    private int missionCount;
    private int rankId;
    private String rankName;

    public static String getFormattedHeader() {
        return String.format("%-6s %-15s %-15s %-15s %-15s %-15s", "ID", "First Name", "Last Name", "Mission Count", "Rank ID", "Rank Name");
    }

    @Override
    public String toString() {
        return String.format("%-6d %-15s %-15s %-15d %-15d %-15s", soldierId, firstName, lastName, missionCount, rankId, rankName);
    }

    public SoldierMissionCountRankDTO() { }

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

    public int getMissionCount() {
        return missionCount;
    }

    public void setMissionCount(int missionCount) {
        this.missionCount = missionCount;
    }

    public int getRankId() {
        return rankId;
    }

    public void setRankId(int rankId) {
        this.rankId = rankId;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }
}
