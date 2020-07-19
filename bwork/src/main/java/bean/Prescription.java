package bean;

import java.sql.Timestamp;
import java.util.List;

public class Prescription {
  private int id;
  private int registID;
  private int recordID;
  private int doctorID;
  private String patiName;
  private String presName;
  private Timestamp creationTime;
  private double totalPrice;
  private int presStatus;
  private List<PresItem> items;

  /**
   * @param id
   * @param registID     挂号id
   * @param recordID     病历号
   * @param doctorID     医生id
   * @param patiName     患者姓名
   * @param presName     处方名
   * @param creationTime 开立时间
   * @param totalPrice   处方总价
   * @param presStatus   处方状态
   * @param items        药品列表
   */
  public Prescription(int id, int registID, int recordID, int doctorID, String patiName, String presName,
      Timestamp creationTime, double totalPrice, int presStatus, List<PresItem> items) {
    this.id = id;
    this.registID = registID;
    this.recordID = recordID;
    this.doctorID = doctorID;
    this.patiName = patiName;
    this.presName = presName;
    this.creationTime = creationTime;
    this.totalPrice = totalPrice;
    this.presStatus = presStatus;
    this.items = items;
  }

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return the registID
   */
  public int getRegistID() {
    return registID;
  }

  /**
   * @param registID the registID to set
   */
  public void setRegistID(int registID) {
    this.registID = registID;
  }

  /**
   * @return the recordID
   */
  public int getRecordID() {
    return recordID;
  }

  /**
   * @param recordID the recordID to set
   */
  public void setRecordID(int recordID) {
    this.recordID = recordID;
  }

  /**
   * @return the doctorID
   */
  public int getDoctorID() {
    return doctorID;
  }

  /**
   * @param doctorID the doctorID to set
   */
  public void setDoctorID(int doctorID) {
    this.doctorID = doctorID;
  }

  /**
   * @return the patiName
   */
  public String getPatiName() {
    return patiName;
  }

  /**
   * @param patiName the patiName to set
   */
  public void setPatiName(String patiName) {
    this.patiName = patiName;
  }

  /**
   * @return the presName
   */
  public String getPresName() {
    return presName;
  }

  /**
   * @param presName the presName to set
   */
  public void setPresName(String presName) {
    this.presName = presName;
  }

  /**
   * @return the creationTime
   */
  public Timestamp getCreationTime() {
    return creationTime;
  }

  /**
   * @param creationTime the creationTime to set
   */
  public void setCreationTime(Timestamp creationTime) {
    this.creationTime = creationTime;
  }

  /**
   * @return the totalPrice
   */
  public double getTotalPrice() {
    return totalPrice;
  }

  /**
   * @param totalPrice the totalPrice to set
   */
  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  /**
   * @return the presStatus
   */
  public int getPresStatus() {
    return presStatus;
  }

  /**
   * @param presStatus the presStatus to set
   */
  public void setPresStatus(int presStatus) {
    this.presStatus = presStatus;
  }

  /**
   * @return the items
   */
  public List<PresItem> getItems() {
    return items;
  }

  /**
   * @param items the items to set
   */
  public void setItems(List<PresItem> items) {
    this.items = items;
  }
}