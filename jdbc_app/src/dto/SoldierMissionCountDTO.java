package dto;

public class SoldierMissionCountDTO {

    private int soldierId;
    private String firstName;
    private String lastName;
    private int missionCount;

    public static String getFormattedHeader() {
        return String.format("%-6s %-15s %-15s %-15s", "ID", "First Name", "Last Name", "Mission Count");
    }

    @Override
    public String toString() {
        return String.format("%-6d %-15s %-15s %-15d", soldierId, firstName, lastName, missionCount);
    }

    public SoldierMissionCountDTO() { }

    public SoldierMissionCountDTO(int soldierId, String firstName, String lastName, int missionCount) {
        this.soldierId = soldierId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.missionCount = missionCount;
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

    public int getMissionCount() {
        return missionCount;
    }

    public void setMissionCount(int missionCount) {
        this.missionCount = missionCount;
    }
}
