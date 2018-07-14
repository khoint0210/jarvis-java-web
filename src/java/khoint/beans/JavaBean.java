/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoint.beans;

import java.io.Serializable;
import java.util.List;
import khoint.daos.JarvisDAO;
import khoint.dtos.AvengersDTO;
import khoint.dtos.EquipmentsDTO;
import khoint.dtos.MissionsDTO;

/**
 *
 * @author khoint0210
 */
public class JavaBean implements Serializable {

    private String username, password;

    private String equipmentName;

    private String avengerName;

    private String missionName;

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    private String avatarPath;

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    private AvengersDTO avengersDTO;

    public void setAvengersDTO(AvengersDTO avengersDTO) {
        this.avengersDTO = avengersDTO;
    }

    public JavaBean() {
    }

    public String getAvengerName() {
        return avengerName;
    }

    public void setAvengerName(String avengerName) {
        this.avengerName = avengerName;
    }

    private int ID;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private EquipmentsDTO equipmentsDTO;

    private MissionsDTO missionsDTO;

    public void setMissionsDTO(MissionsDTO missionsDTO) {
        this.missionsDTO = missionsDTO;
    }

    public void setEquipment(EquipmentsDTO equipment) {
        this.equipmentsDTO = equipment;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
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

    public List<AvengersDTO> getAllAvengers() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.getAllAvenger();
    }

    public List<AvengersDTO> selectedAvengersOnTop() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.selectedAvengersOnTop(ID);
    }

    public List<EquipmentsDTO> getAllEquipments() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.getAllEquipments();
    }

    public AvengersDTO login() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.login(username, password);
    }

    public List<EquipmentsDTO> getEquipmentsLikeName() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.getEquipmentsLikeName(equipmentName);
    }

    public EquipmentsDTO getEquipmentsByPrimaryKey() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.getEquipmentsByPrimaryKey(ID);
    }

    public boolean insertNewEquipment() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.insertNewEquipment(equipmentsDTO);
    }

    public boolean deleteEquipment() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.deleteEquipment(ID);
    }

    public boolean updateEquipment() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.updateEquipment(equipmentsDTO);
    }

    public List<AvengersDTO> getAvengersLikeName() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.getAvengerLikeByName(avengerName);
    }

    public AvengersDTO getAvengerByPrimaryKey() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.getAvengerByPrimaryKey(ID);
    }

    public boolean deleteAvenger() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.deleteAvenegr(ID);
    }

    public boolean insertAvenger() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.insertNewAvenger(avengersDTO);
    }

    public boolean updateAvenger() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.updateAvenger(avengersDTO);
    }

    public List<EquipmentsDTO> getEquipmentsByAvengerID() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.getEquipmentsByAvengerID(ID);
    }

    public boolean updateSelectedEquipmentAdmin() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.updateSelectedEquipmentAdmin(ID);
    }

    public boolean updateAvatar() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.updateAvatar(ID, avatarPath);
    }

    public boolean updateEquipmentAvatar() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        System.out.println(ID);
        return dao.updateEquipmentAvatar(ID, avatarPath);
    }

    public List<MissionsDTO> getAllMission() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.getAllMission();
    }

    public boolean deleteMission() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.deleteMission(ID);
    }

    public List<MissionsDTO> getMissionsLikeName() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.getMissionLikeName(missionName);
    }

    public MissionsDTO getMissionByPrimarykey() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.getMissionsByPrimaryKey(ID);
    }

    public List<AvengersDTO> getAvengerInMission() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.getAvengerInMission(ID);
    }

    public int checkAvengerFreeOrNot() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.checkAvengerFreeOrNot(ID);
    }

    public List<MissionsDTO> getMissionByAvengerID() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.getMissionInfoByAvengerID(ID);
    }

    public boolean updateMissionStatus() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.updateMissionStatus(ID, status);
    }

    public boolean insertNewMission() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.insertNewMission(missionsDTO);
    }

    public List<AvengersDTO> getAvengerNotOnThisMission() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.getAvengerNotOnThisMission(ID);
    }

    public boolean updateMission() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.updateMission(missionsDTO);
    }

    public boolean insertAvengerOnMission() throws Exception {
        JarvisDAO dao = new JarvisDAO();
        return dao.insertAvengerOnMission(ID,status);
    }
}
