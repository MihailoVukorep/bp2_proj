package dto;


import java.sql.Date;

public class MissionLocationDTO {

    private int id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private String country;
    private String city;

    public static String getFormattedHeader() {
        return String.format("%-6s %-15s %-40s %-15s %-15s %-15s %-15s", "Id", "Name", "Description", "Start Date", "End Date", "Country", "City");
    }

    @Override
    public String toString() {
        return String.format("%-6s %-15s %-40s %-15s %-15s %-15s %-15s", id, name, description, startDate.toString(), endDate.toString(), country, city);
    }

    public MissionLocationDTO() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
