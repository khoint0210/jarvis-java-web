/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoint.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import khoint.conn.MyConnection;
import khoint.dtos.AvengersDTO;
import khoint.dtos.EquipmentsDTO;

/**
 *
 * @author khoint0210
 */
public class JarvisDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public List<AvengersDTO> getAvengerLikeByName(String avengerName) throws Exception {
        List<AvengersDTO> result = null;
        AvengersDTO dto = null;
        try {
            String sql = "Select ID, Username, Fullname, Role from Avengers Where Fullname LIKE ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + avengerName + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String username = rs.getString("Username");
                String fullname = rs.getString("Fullname");
                System.out.println("This is fullname : " + fullname);
                String role = rs.getString("Role");
                dto = new AvengersDTO(username, fullname, role, ID);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<AvengersDTO> getAllAvenger() throws Exception {
        List<AvengersDTO> result = null;
        AvengersDTO dto = null;
        try {
            String sql = "Select ID, Username, Fullname, Role from Avengers";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String username = rs.getString("Username");
                String fullname = rs.getString("Fullname");
                String role = rs.getString("Role");
                dto = new AvengersDTO(username, fullname, role, ID);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public AvengersDTO getAvengerByPrimaryKey(int avengerID) throws Exception {
        AvengersDTO avenger = null;
        try {
            String sql = "Select * from Avengers where ID = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, avengerID);
            rs = preStm.executeQuery();
            if (rs.next()) {
                int ID = rs.getInt("ID");
                String username = rs.getString("Username");
                String fullname = rs.getString("Fullname");
                String madeUpName = rs.getString("MadeUpName");
                String role = rs.getString("Role");
                int status = rs.getInt("Status");
                int age = rs.getInt("Age");
                String avatar = rs.getString("Avatar");
                String drawBack = rs.getString("DrawBack");
                avenger = new AvengersDTO(username, fullname, madeUpName, role, avatar, drawBack, ID, status, age);
            }
        } finally {
            closeConnection();
        }
        return avenger;
    }

    
    public AvengersDTO login(String Username, String Password) throws Exception {
        AvengersDTO avengers = null;
        try {
            String sql = "Select * from Avengers where Username = ? and Password = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, Username);
            preStm.setString(2, Password);
            rs = preStm.executeQuery();
            if (rs.next()) {
                int ID = rs.getInt("ID");
                String username = rs.getString("Username");
                String fullname = rs.getString("Fullname");
                String madeUpName = rs.getString("MadeUpName");
                String role = rs.getString("Role");
                int status = rs.getInt("Status");
                int age = rs.getInt("Age");
                String avatar = rs.getString("Avatar");
                String drawBack = rs.getString("DrawBack");
                avengers = new AvengersDTO(username, fullname, madeUpName, role, avatar, drawBack, ID, status, age);
            }
        } finally {
            closeConnection();
        }
        return avengers;
    }

    public List<EquipmentsDTO> getEquipmentsByAvengerID(String AvengerID) throws Exception {
        List<EquipmentsDTO> result = null;
        EquipmentsDTO equipments = null;
        try {
            String sql = "Select * from Equipments where AvengerID = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, AvengerID);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String name = rs.getString("Name");
                String description = rs.getString("Description");
                equipments = new EquipmentsDTO(ID, name, description);
                result.add(equipments);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<EquipmentsDTO> getAllEquipments() throws Exception {
        List<EquipmentsDTO> result = null;
        EquipmentsDTO equipments = null;
        try {
            String sql = "SELECT Equipments.ID, Equipments.Name, Equipments.AvengerID ,Avengers.Fullname \n"
                    + "FROM Avengers, Equipments \n"
                    + "WHERE Avengers.ID = Equipments.AvengerID";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String name = rs.getString("Name");
                String owner = rs.getString("Fullname");
                int AvengerID = rs.getInt("AvengerID");
                equipments = new EquipmentsDTO(ID, AvengerID, name, owner);
                result.add(equipments);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<EquipmentsDTO> getEquipmentsLikeName(String equipmentName) throws Exception {
        List<EquipmentsDTO> result = null;
        EquipmentsDTO equipments = null;
        try {
            String sql = "SELECT Equipments.ID, Equipments.Name, Equipments.AvengerID ,Avengers.Fullname \n"
                    + "FROM Avengers, Equipments \n"
                    + "WHERE Avengers.ID = Equipments.AvengerID AND Equipments.Name LIKE ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + equipmentName + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String name = rs.getString("Name");
                String owner = rs.getString("Fullname");
                int AvengerID = rs.getInt("AvengerID");
                equipments = new EquipmentsDTO(ID, AvengerID, name, owner);
                result.add(equipments);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public EquipmentsDTO getEquipmentsByPrimaryKey(int equipmentID) throws Exception {
        EquipmentsDTO equipments = null;
        try {
//            String sql = "Select * from Equipments where ID = ?";
            String sql = "SELECT Equipments.ID, Equipments.Name,Equipments.AvengerID, Avengers.Fullname, Equipments.Description\n"
                    + "FROM Avengers, Equipments \n"
                    + "WHERE Avengers.ID = Equipments.AvengerID AND Equipments.ID = ?;";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, equipmentID);
            rs = preStm.executeQuery();
            if (rs.next()) {
                int ID = rs.getInt("ID");
                String name = rs.getString("Name");
                String description = rs.getString("Description");
                String owner = rs.getString("Fullname");
                int AvengerID = rs.getInt("AvengerID");
                equipments = new EquipmentsDTO(ID, AvengerID, name, description, owner);
            }
        } finally {
            closeConnection();
        }
        return equipments;
    }

    public boolean insertNewEquipment(EquipmentsDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO Equipments(AvengerID , Name, Description) VALUES(?,?,?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getAvengerID());
            preStm.setString(2, dto.getName());
            preStm.setString(3, dto.getDescription());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean deleteEquipment(int ID) throws Exception {
        boolean check = false;
        try {
            String sql = "DELETE FROM Equipments WHERE ID = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, ID);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<AvengersDTO> selectedAvengersOnTop(int id) throws Exception {
        List<AvengersDTO> result = null;
        AvengersDTO dto = null;
        try (Connection conn = MyConnection.getConnection()) {
            String sql = "SELECT ID , Fullname FROM Avengers \n"
                    + "ORDER BY CASE \n"
                    + "	WHEN ID = ? THEN NULL\n"
                    + "	ELSE ID\n"
                    + "END";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String fullname = rs.getString("Fullname");
                dto = new AvengersDTO(fullname, ID);
                result.add(dto);
            }
        }
        return result;
    }

    public boolean updateEquipment(EquipmentsDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "UPDATE Equipments SET AvengerID = ? , Name = ?, Description = ? WHERE ID = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getAvengerID());
            preStm.setString(2, dto.getName());
            preStm.setString(3, dto.getDescription());
            preStm.setInt(4, dto.getID());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
