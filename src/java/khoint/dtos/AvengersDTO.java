package khoint.dtos;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author khoint0210
 */
public class AvengersDTO implements Serializable {

    private String username, password, fullname, madeUpName, role, avatar, drawback;
    private int ID, status, age;

    public AvengersDTO() {
    }

    public AvengersDTO(String username, String password, String fullname, String madeUpName, String role, String avatar, String drawback, int ID, int status, int age) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.madeUpName = madeUpName;
        this.role = role;
        this.avatar = avatar;
        this.drawback = drawback;
        this.ID = ID;
        this.status = status;
        this.age = age;
    }
    
    public AvengersDTO(String username, String password, String fullname, String madeUpName, String role, String avatar, String drawback, int status, int age) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.madeUpName = madeUpName;
        this.role = role;
        this.avatar = avatar;
        this.drawback = drawback;
        this.status = status;
        this.age = age;
    }

    
    public AvengersDTO(String username, String fullname, String madeUpName, String role, String avatar, String drawback, int ID, int status, int age) {
        this.username = username;
        this.fullname = fullname;
        this.madeUpName = madeUpName;
        this.role = role;
        this.avatar = avatar;
        this.drawback = drawback;
        this.ID = ID;
        this.status = status;
        this.age = age;
    }
    
    
    
    public AvengersDTO(String username, String fullname, String role, int ID) {
        this.username = username;
        this.fullname = fullname;
        this.role = role;
        this.ID = ID;
    }

    public AvengersDTO(String fullname, int ID) {
        this.fullname = fullname;
        this.ID = ID;
    }

    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMadeUpName() {
        return madeUpName;
    }

    public void setMadeUpName(String madeUpName) {
        this.madeUpName = madeUpName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDrawback() {
        return drawback;
    }

    public void setDrawback(String drawback) {
        this.drawback = drawback;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }    
    
}
