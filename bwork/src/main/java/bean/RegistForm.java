package bean;

import java.sql.Timestamp;
import java.sql.Date;

public class RegistForm {
    private int id;
    private int recordID;
    private int departmentID;
    private int scheduleID;
    private int operatorID;
    private String patiName;
    private int age;
    private Timestamp registTime;
    private String deptName;
    private Date reseDate;
    private int docTime;
    private int diagStatus;

    /**
     * @param id           挂号单id
     * @param recordID     病历号
     * @param departmentID 科室id
     * @param scheduleID   医生排班id
     * @param operatorID   操作员id
     * @param patiName     患者姓名
     * @param age          患者年龄
     * @param registTime   挂号时间
     * @param deptName     科室名
     * @param reseDate     看诊(预约)时间
     * @param docTime      午别
     * @param diagStatus   挂号状态
     */
    public RegistForm(int id, int recordID, int departmentID, int scheduleID, int operatorID, String patiName, int age,
            Timestamp registTime, String deptName, Date reseDate, int docTime, int diagStatus) {
        this.id = id;
        this.recordID = recordID;
        this.departmentID = departmentID;
        this.scheduleID = scheduleID;
        this.operatorID = operatorID;
        this.patiName = patiName;
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
     * @return the scheduleID
     */
    public int getScheduleID() {
        return scheduleID;
    }

    /**
     * @param scheduleID the scheduleID to set
     */
    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
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
    public Timestamp getRegistTime() {
        return registTime;
    }

    /**
     * @param registTime the registTime to set
     */
    public void setRegistTime(Timestamp registTime) {
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