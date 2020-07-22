package bean;

/**
 * 诊断
 */
public class Diagnosis {
    private int id;
    private int registID;
    private int doctorID;
    private int diseaseID;
    private String diseName;
    private String diagInfo;

    /**
     * @param id
     * @param registID  挂号id
     * @param doctorID  医生id
     * @param diseaseID 疾病id
     * @param diseName  疾病名称
     * @param diagInfo  诊断内容
     */
    public Diagnosis(int id, int registID, int doctorID, int diseaseID, String diseName, String diagInfo) {
        this.id = id;
        this.registID = registID;
        this.doctorID = doctorID;
        this.diseaseID = diseaseID;
        this.diseName = diseName;
        this.diagInfo = diagInfo;
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
     * @return the diseaseID
     */
    public int getDiseaseID() {
        return diseaseID;
    }

    /**
     * @param diseaseID the diseaseID to set
     */
    public void setDiseaseID(int diseaseID) {
        this.diseaseID = diseaseID;
    }

    /**
     * @return the diseName
     */
    public String getDiseName() {
        return diseName;
    }

    /**
     * @param diseName the diseName to set
     */
    public void setDiseName(String diseName) {
        this.diseName = diseName;
    }

    /**
     * @return the diagInfo
     */
    public String getDiagInfo() {
        return diagInfo;
    }

    /**
     * @param diagInfo the diagInfo to set
     */
    public void setDiagInfo(String diagInfo) {
        this.diagInfo = diagInfo;
    }
}