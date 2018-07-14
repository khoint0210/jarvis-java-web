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
import khoint.dtos.MissionsDTO;

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
            String sql = "Select ID, Username, Fullname, MadeUpName, Role, Age, Avatar, DrawBack from Avengers where ID = ?";
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
                int age = rs.getInt("Age");
                String avatar = rs.getString("Avatar");
                String drawBack = rs.getString("DrawBack");
                avenger = new AvengersDTO(username, fullname, madeUpName, role, avatar, drawBack, ID, age);
            }
        } finally {
            closeConnection();
        }
        return avenger;
    }

    public boolean deleteAvenegr(int ID) throws Exception {
        boolean check = false;
        try {
            String sql = "DELETE MissionDetails WHERE AvengerID = ?;\n"
                    + "DELETE Equipments WHERE AvengerID = ?;\n"
                    + "DELETE Avengers WHERE ID = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, ID);
            preStm.setInt(2, ID);
            preStm.setInt(3, ID);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean insertNewAvenger(AvengersDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO Avengers(Username , Password, Fullname, MadeUpName, Role, Age, Avatar, Drawback) \n"
                    + "VALUES(?,?,?,?,?,?,?,?,?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getFullname());
            preStm.setString(4, dto.getMadeUpName());
            preStm.setString(5, dto.getRole());
            preStm.setInt(6, dto.getAge());
            preStm.setString(7, dto.getAvatar());
            preStm.setString(8, dto.getDrawback());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateAvenger(AvengersDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "UPDATE Avengers \n"
                    + "SET Username = ? , Password = ?, Fullname = ? , MadeUpName = ? , Role = ? , Age = ? , Avatar = ? , Drawback = ?  \n"
                    + "WHERE ID = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getFullname());
            preStm.setString(4, dto.getMadeUpName());
            preStm.setString(5, dto.getRole());
            preStm.setInt(6, dto.getAge());
            preStm.setString(7, dto.getAvatar());
            preStm.setString(8, dto.getDrawback());
            preStm.setInt(9, dto.getID());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public AvengersDTO login(String Username, String Password) throws Exception {
        AvengersDTO avengers = null;
        try {
            String sql = "Select ID, Username, Fullname, MadeUpName, Role, Age, Avatar, DrawBack from Avengers where Username = ? and Password = ?";
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
                int age = rs.getInt("Age");
                String avatar = rs.getString("Avatar");
                String drawBack = rs.getString("DrawBack");
                avengers = new AvengersDTO(username, fullname, madeUpName, role, avatar, drawBack, ID, age);
            }
        } finally {
            closeConnection();
        }
        return avengers;
    }

    public List<EquipmentsDTO> getEquipmentsByAvengerID(int AvengerID) throws Exception {
        List<EquipmentsDTO> result = null;
        EquipmentsDTO equipments = null;
        try {
            String sql = "Select ID, Name, Description,InUse from Equipments where AvengerID = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, AvengerID);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String name = rs.getString("Name");
                String description = rs.getString("Description");
                int inUse = rs.getInt("InUse");
                equipments = new EquipmentsDTO(ID, name, description, inUse);
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
            String sql = "SELECT Equipments.ID, Equipments.Name,Equipments.AvengerID, Avengers.Fullname, Equipments.Description, Equipments.Avatar\n"
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
                String Avatar = rs.getString("Avatar");
                int AvengerID = rs.getInt("AvengerID");
                equipments = new EquipmentsDTO(ID, AvengerID, name, description, owner, Avatar);
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

    public boolean updateSelectedEquipmentAdmin(int ID) throws Exception {
        boolean check = false;
        try {
            String sql = "UPDATE Equipments\n"
                    + "SET InUse = 0\n"
                    + "WHERE InUse = 1 \n"
                    + "UPDATE Equipments\n"
                    + "SET InUse = 1\n"
                    + "WHERE ID = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, ID);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateAvatar(int ID, String avatarPath) throws Exception {
        boolean check = false;
        try {
            String sql = "UPDATE Avengers \n"
                    + "SET Avatar = ?\n"
                    + "WHERE ID = ?;";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, avatarPath);
            preStm.setInt(2, ID);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateEquipmentAvatar(int ID, String avatarPath) throws Exception {
        boolean check = false;
        try {
            String sql = "UPDATE Equipments \n"
                    + "SET Avatar = ?\n"
                    + "WHERE ID = ?;";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, avatarPath);
            preStm.setInt(2, ID);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<MissionsDTO> getAllMission() throws Exception {
        MissionsDTO dto = null;
        List<MissionsDTO> result = null;
        try {
            String sql = "SELECT ID, Name, Location, StartDate, EndDate, Complete\n"
                    + "FROM Missions";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String name = rs.getString("Name");
                String location = rs.getString("Location");
                String startDate = rs.getString("StartDate");
                String endDate = rs.getString("EndDate");
                int status = rs.getInt("Complete");
                dto = new MissionsDTO(ID, status, name, startDate, endDate, location);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean deleteMission(int ID) throws Exception {
        boolean check = false;
        try {
            String sql = "DELETE MissionDetails WHERE MissionID = ?;\n"
                    + "DELETE Missions WHERE ID = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, ID);
            preStm.setInt(2, ID);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<MissionsDTO> getMissionLikeName(String search) throws Exception {
        List<MissionsDTO> result = null;
        MissionsDTO dto = null;
        try {
            String sql = "SELECT ID, Name, Location, StartDate, EndDate, Complete\n"
                    + "FROM Missions\n"
                    + "WHERE Name LIKE ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String name = rs.getString("Name");
                String location = rs.getString("Location");
                String startDate = rs.getString("StartDate");
                String endDate = rs.getString("EndDate");
                int status = rs.getInt("Complete");
                dto = new MissionsDTO(ID, status, name, startDate, endDate, location);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public MissionsDTO getMissionsByPrimaryKey(int missionID) throws Exception {
        MissionsDTO mission = null;
        try {
            String sql = "SELECT ID, Name, Location, StartDate, EndDate,Complete\n"
                    + "FROM Missions\n"
                    + "WHERE ID = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, missionID);
            rs = preStm.executeQuery();
            if (rs.next()) {
                int ID = rs.getInt("ID");
                String name = rs.getString("Name");
                String location = rs.getString("Location");
                String startDate = rs.getString("StartDate");
                String endDate = rs.getString("EndDate");
                int status = rs.getInt("Complete");
                mission = new MissionsDTO(ID, status, name, startDate, endDate, location);
            }
        } finally {
            closeConnection();
        }
        return mission;
    }

    public List<AvengersDTO> getAvengerInMission(int missionID) throws Exception {
        AvengersDTO dto = null;
        List<AvengersDTO> result = null;
        try {
            String sql = "SELECT Avengers.MadeUpName, Avengers.ID\n"
                    + "FROM Avengers, MissionDetails\n"
                    + "WHERE Avengers.ID = MissionDetails.AvengerID AND MissionDetails.MissionID = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, missionID);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String madeUpName = rs.getString("MadeUpName");
                dto = new AvengersDTO(ID, madeUpName);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public int checkAvengerFreeOrNot(int avengerID) throws Exception {
        int result = 0;
        try {
            String sql = "SELECT count(AvengerID)\n"
                    + "FROM MissionDetails\n"
                    + "WHERE AvengerID = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, avengerID);
            rs = preStm.executeQuery();
            if (rs.next()) {
                int check = rs.getInt(1);
                if (check == 0) {
                    result = 0;
                } else {
                    result = 1;
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<MissionsDTO> getMissionInfoByAvengerID(int avengerID) throws Exception {
        List<MissionsDTO> result = null;
        MissionsDTO dto = null;
        try {
            String sql = "SELECT Missions.ID, Missions.Name, Missions.StartDate, Missions.Location, Missions.EndDate, Missions.Complete\n"
                    + "FROM Missions, MissionDetails\n"
                    + "WHERE MissionDetails.AvengerID = ? AND MissionDetails.MissionID = Missions.ID";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, avengerID);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String name = rs.getString("Name");
                String location = rs.getString("Location");
                String startDate = rs.getString("StartDate");
                String endDate = rs.getString("EndDate");
                int status = rs.getInt("Complete");
                dto = new MissionsDTO(ID, status, name, startDate, endDate, location);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean updateMissionStatus(int ID, int status) throws Exception {
        boolean check = false;
        try {
            String sql = "UPDATE Missions\n"
                    + "SET Complete = ?\n"
                    + "WHERE ID = ?;";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, status);
            preStm.setInt(2, ID);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean insertNewMission(MissionsDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO Missions(Name ,Location, StartDate, EndDate) VALUES(?,?,?,?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getName());
            preStm.setString(2, dto.getLocation());
            preStm.setString(3, dto.getStartDate().replace("T", " "));
            preStm.setString(4, dto.getEndDate().replace("T", " "));
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<AvengersDTO> getAvengerNotOnThisMission(int missionID) throws Exception {
        List<AvengersDTO> result = null;
        AvengersDTO dto = null;
        try {
            String sql = "SELECT ID , MadeUpName\n"
                    + "FROM Avengers\n"
                    + "WHERE ID NOT IN (SELECT AvengerID FROM MissionDetails WHERE MissionID = ?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, missionID);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String madeUpName = rs.getString("MadeUpName");
                dto = new AvengersDTO(ID, madeUpName);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean updateMission(MissionsDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "UPDATE Missions\n"
                    + "SET Name = ?, Location = ?, StartDate = ?, EndDate = ?\n"
                    + "WHERE ID = ?;";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getName());
            preStm.setString(2, dto.getLocation());
            preStm.setString(3, dto.getStartDate().replace("T", " "));
            preStm.setString(4, dto.getEndDate().replace("T", " "));
            preStm.setInt(5, dto.getID());
            System.out.println("This from update " + dto.toString());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean insertAvengerOnMission(int missionID, int avengerID) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO MissionDetails(MissionID ,AvengerID) VALUES(?,?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, missionID);
            preStm.setInt(2, avengerID);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
