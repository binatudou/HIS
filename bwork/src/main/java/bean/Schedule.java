package bean;

import java.sql.Date;

/**
 * 医生排班
 */
public class Schedule {
  private int id;
  private int doctorID;
  private int departmentID;
  private String docName;
  private int docLevel;
  private Date workDate;
  private int workTime;
  private int totalNumber;
  private int usedNumber;

  /**
   * @param id           排班id
   * @param doctorID     医生id
   * @param departmentID 科室id
   * @param docName      医生姓名
   * @param docLevel     号别
   * @param workDate     工作日期
   * @param workTime     工作时段
   * @param totalNumber  总排号
   * @param usedNumber   剩余排号
   */
  public Schedule(int id, int doctorID, int departmentID, String docName, int docLevel, Date workDate, int workTime,
      int totalNumber, int usedNumber) {
    this.id = id;
    this.doctorID = doctorID;
    this.departmentID = departmentID;
    this.docName = docName;
    this.docLevel = docLevel;
    this.workDate = workDate;
    this.workTime = workTime;
    this.totalNumber = totalNumber;
    this.usedNumber = usedNumber;
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
   * @return the departmentID
   */
  public int getDepartmentID() {
    return departmentID;
  }

  /**
   * @param departmentID the departmentID to set
   */
  public void setDepartmentID(int departmentID) {
    this.departmentID = departmentID;
  }

  /**
   * @return the docName
   */
  public String getDocName() {
    return docName;
  }

  /**
   * @param docName the docName to set
   */
  public void setDocName(String docName) {
    this.docName = docName;
  }

  /**
   * @return the docLevel
   */
  public int getDocLevel() {
    return docLevel;
  }

  /**
   * @param docLevel the docLevel to set
   */
  public void setDocLevel(int docLevel) {
    this.docLevel = docLevel;
  }

  /**
   * @return the workDate
   */
  public Date getWorkDate() {
    return workDate;
  }

  /**
   * @param workDate the workDate to set
   */
  public void setWorkDate(Date workDate) {
    this.workDate = workDate;
  }

  /**
   * @return the workTime
   */
  public int getWorkTime() {
    return workTime;
  }

  /**
   * @param workTime the workTime to set
   */
  public void setWorkTime(int workTime) {
    this.workTime = workTime;
  }

  /**
   * @return the totalNumber
   */
  public int getTotalNumber() {
    return totalNumber;
  }

  /**
   * @param totalNumber the totalNumber to set
   */
  public void setTotalNumber(int totalNumber) {
    this.totalNumber = totalNumber;
  }

  /**
   * @return the usedNumber
   */
  public int getUsedNumber() {
    return usedNumber;
  }

  /**
   * @param usedNumber the usedNumber to set
   */
  public void setUsedNumber(int usedNumber) {
    this.usedNumber = usedNumber;
  }
}