/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoint.dtos;

import java.io.Serializable;

/**
 *
 * @author khoint0210
 */
public class MissionsDTO implements Serializable{
    private int ID,complete;
    private String name ,startDate, endDate, location;

    public MissionsDTO(int ID, String name, String startDate, String endDate, String location) {
        this.ID = ID;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
    }

    
    public MissionsDTO() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate.replace(" ", "T");
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate.replace(" ", "T");
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    public MissionsDTO(int ID, int status, String name, String startDate, String endDate, String location) {
        this.ID = ID;
        this.complete = status;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
    }

    public MissionsDTO(String name, String startDate, String endDate, String location) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
    }

    @Override
    public String toString() {
        return "MissionsDTO{" + "ID=" + ID + ", complete=" + complete + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + ", location=" + location + '}';
    }
    
    
}
