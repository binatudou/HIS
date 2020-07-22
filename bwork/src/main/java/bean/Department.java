package bean;

/**
 * 科室
 */
public class Department {
    private int id;
    private String deptCode;
    private String deptName;
    private int deptCategoryID;
    private int deptType;

    /**
     * @param id             科室id
     * @param deptCode       科室编码
     * @param deptName       科室名称
     * @param deptCategoryID 科室分类
     * @param deptType       科室类型
     */
    public Department(int id, String deptCode, String deptName, int deptCategoryID, int deptType) {
        this.id = id;
        this.deptCode = deptCode;
        this.deptName = deptName;
        this.deptCategoryID = deptCategoryID;
        this.deptType = deptType;
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
     * @return the deptCode
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * @param deptCode the deptCode to set
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
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
     * @return the deptCategoryID
     */
    public int getDeptCategoryID() {
        return deptCategoryID;
    }

    /**
     * @param deptCategoryID the deptCategoryID to set
     */
    public void setDeptCategoryID(int deptCategoryID) {
        this.deptCategoryID = deptCategoryID;
    }

    /**
     * @return the deptType
     */
    public int getDeptType() {
        return deptType;
    }

    /**
     * @param deptType the deptType to set
     */
    public void setDeptType(int deptType) {
        this.deptType = deptType;
    }
}