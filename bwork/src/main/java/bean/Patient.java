package bean;

import java.sql.Date;

public class Patient {
    private int id;
    private int recordID;
    private String patiName;
    private int sex;
    private Date birthday;
    private String idNumber;
    private String patiAddress;

    public Patient() {
    }

    /**
     * @param id          患者id
     * @param recordID    病历号
     * @param patiName    患者姓名
     * @param sex         患者性别
     * @param birthday    患者生日
     * @param idNumber    患者身份证号(String)
     * @param patiAddress 患者住址
     */
    public Patient(int id, int recordID, String patiName, int sex, Date birthday, String idNumber, String patiAddress) {
        this.id = id;
        this.recordID = recordID;
        this.patiName = patiName;
        this.sex = sex;
        this.birthday = birthday;
        this.idNumber = idNumber;
        this.patiAddress = patiAddress;
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
     * @return the sex
     */
    public int getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(int sex) {
        this.sex = sex;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the idNumber
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * @param idNumber the idNumber to set
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * @return the patiAddress
     */
    public String getPatiAddress() {
        return patiAddress;
    }

    /**
     * @param patiAddress the patiAddress to set
     */
    public void setPatiAddress(String patiAddress) {
        this.patiAddress = patiAddress;
    }
}