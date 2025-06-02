package dto;

import model.Soldier;

import java.sql.Date;

public class LatestSquadMemberDTO {

    private int id;
    private String firstName;
    private String lastName;

    public static String getFormattedHeader() {
        return String.format("%-6s %-15s %-15s", "id", "first name", "last name");
    }

    @Override
    public String toString() {
        return String.format("%-6d %-15s %-15s", id, firstName, lastName);
    }

    public LatestSquadMemberDTO() {
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
}
