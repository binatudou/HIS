package bean;

import java.util.Date;

public class RegistForm {
  private int id;
  private int recordID;
  private int departmentID;
  private int doctorID;
  private int operatorID;
  private String name;
  private int age;
  private Date registTime; //挂号时间
  private String deptName;
  private Date reseDate; //看诊时间
  private int docTime; //午别
  private int diagStatus;

  /**
   * @param id 挂号单id
   * @param recordID 病历号
   * @param departmentID 科室id
   * @param doctorID 医生id
   * @param operatorID 操作员id
   * @param name 患者姓名
   * @param age 患者年龄
   * @param registTime 挂号时间
   * @param deptName 科室名
   * @param reseDate 看诊(预约)时间
   * @param docTime 午别
   * @param diagStatus 挂号状态
   */
  public RegistForm(int id, int recordID, int departmentID, int doctorID, int operatorID, String name, int age,
      Date registTime, String deptName, Date reseDate, int docTime, int diagStatus) {
    this.id = id;
    this.recordID = recordID;
    this.departmentID = departmentID;
    this.doctorID = doctorID;
    this.operatorID = operatorID;
    this.name = name;
    this.age = age;
    this.registTime = registTime;
    this.deptName = deptName;
    this.reseDate = reseDate;
    this.docTime = docTime;
    this.diagStatus = diagStatus;
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
   * @return the operatorID
   */
  public int getOperatorID() {
    return operatorID;
  }

  /**
   * @param operatorID the operatorID to set
   */
  public void setOperatorID(int operatorID) {
    this.operatorID = operatorID;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the age
   */
  public int getAge() {
    return age;
  }

  /**
   * @param age the age to set
   */
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * @return the registTime
   */
  public Date getregistTime() {
    return registTime;
  }

  /**
   * @param registTime the registTime to set
   */
  public void setregistTime(Date registTime) {
    this.registTime = registTime;
  }

  /**
   * @return the deptName
   */
  public String getDeptName() {
    return deptName;
  }

  /**
   * @param deptName the deptName to set
   */
  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  /**
   * @return the reseDate
   */
  public Date getReseDate() {
    return reseDate;
  }

  /**
   * @param reseDate the reseDate to set
   */
  public void setReseDate(Date reseDate) {
    this.reseDate = reseDate;
  }

  /**
   * @return the docTime
   */
  public int getDocTime() {
    return docTime;
  }

  /**
   * @param docTime the docTime to set
   */
  public void setDocTime(int docTime) {
    this.docTime = docTime;
  }

  /**
   * @return the diagStatus
   */
  public int getDiagStatus() {
    return diagStatus;
  }

  /**
   * @param diagStatus the diagStatus to set
   */
  public void setDiagStatus(int diagStatus) {
    this.diagStatus = diagStatus;
  }

}