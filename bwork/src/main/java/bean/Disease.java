package bean;

/**
 * 疾病
 */
public class Disease {
  private int id;
  private int diseCategoryID;
  private String diseCode;
  private String diseName;
  private String diseICD;

  /**
   * @param id
   * @param diseCategoryID 疾病所属分类
   * @param diseCode       疾病助记编码
   * @param diseName       疾病名称
   * @param diseICD        国际ICD编码
   */
  public Disease(int id, int diseCategoryID, String diseCode, String diseName, String diseICD) {
    this.id = id;
    this.diseCategoryID = diseCategoryID;
    this.diseCode = diseCode;
    this.diseName = diseName;
    this.diseICD = diseICD;
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
   * @return the diseCategoryID
   */
  public int getDiseCategoryID() {
    return diseCategoryID;
  }

  /**
   * @param diseCategoryID the diseCategoryID to set
   */
  public void setDiseCategoryID(int diseCategoryID) {
    this.diseCategoryID = diseCategoryID;
  }

  /**
   * @return the diseCode
   */
  public String getDiseCode() {
    return diseCode;
  }

  /**
   * @param diseCode the diseCode to set
   */
  public void setDiseCode(String diseCode) {
    this.diseCode = diseCode;
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
   * @return the diseICD
   */
  public String getDiseICD() {
    return diseICD;
  }

  /**
   * @param diseICD the diseICD to set
   */
  public void setDiseICD(String diseICD) {
    this.diseICD = diseICD;
  }
}