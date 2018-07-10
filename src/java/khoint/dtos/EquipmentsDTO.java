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
public class EquipmentsDTO implements Serializable {

    private int ID, AvengerID, inUse;
    private String name, description, owner, Avatar;

    public EquipmentsDTO() {
    }

    public EquipmentsDTO(int ID, int AvengerID, String name, String description) {
        this.ID = ID;
        this.AvengerID = AvengerID;
        this.name = name;
        this.description = description;
    }

    public EquipmentsDTO(int ID, String name, String description, int inUse) {
        this.ID = ID;
        this.inUse = inUse;
        this.name = name;
        this.description = description;
    }

    public EquipmentsDTO(int AvengerID, String name, String description) {
        this.AvengerID = AvengerID;
        this.name = name;
        this.description = description;
    }

    public EquipmentsDTO(int ID, int AvengerID, String name, String description, String owner, String Avatar) {
        this.ID = ID;
        this.AvengerID = AvengerID;
        this.name = name;
        this.description = description;
        this.Avatar = Avatar;
        this.owner = owner;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String Avatar) {
        this.Avatar = Avatar;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAvengerID() {
        return AvengerID;
    }

    public void setAvengerID(int AvengerID) {
        this.AvengerID = AvengerID;
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

    public int getInUse() {
        return inUse;
    }

    public void setInUse(int inUse) {
        this.inUse = inUse;
    }

}
