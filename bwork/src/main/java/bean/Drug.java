package bean;

public class Drug {
  private int id;
  private long drugCode;
  private String drugName;
  private String drugFormat;
  private double drugPrice;
  private String mnemonicCode;

  /**
   * @param id
   * @param drugCode    药品编码
   * @param drugName    药品名称
   * @param drugFormat  药品规格
   * @param drugPrice   药品价格
   * @param mnemonicCode 药品助记码
   */
  public Drug(int id, long drugCode, String drugName, String drugFormat, double drugPrice, String mnemonicCode) {
    this.id = id;
    this.drugCode = drugCode;
    this.drugName = drugName;
    this.drugFormat = drugFormat;
    this.drugPrice = drugPrice;
    this.mnemonicCode = mnemonicCode;
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
   * @return the drugCode
   */
  public long getDrugCode() {
    return drugCode;
  }

  /**
   * @param drugCode the drugCode to set
   */
  public void setDrugCode(long drugCode) {
    this.drugCode = drugCode;
  }

  /**
   * @return the drugName
   */
  public String getDrugName() {
    return drugName;
  }

  /**
   * @param drugName the drugName to set
   */
  public void setDrugName(String drugName) {
    this.drugName = drugName;
  }

  /**
   * @return the drugFormat
   */
  public String getDrugFormat() {
    return drugFormat;
  }

  /**
   * @param drugFormat the drugFormat to set
   */
  public void setDrugFormat(String drugFormat) {
    this.drugFormat = drugFormat;
  }

  /**
   * @return the drugPrice
   */
  public double getDrugPrice() {
    return drugPrice;
  }

  /**
   * @param drugPrice the drugPrice to set
   */
  public void setDrugPrice(double drugPrice) {
    this.drugPrice = drugPrice;
  }

  /**
   * @return the mnemonicCode
   */
  public String getMnemonicCode() {
    return mnemonicCode;
  }

  /**
   * @param mnemonicCode the mnemonicCode to set
   */
  public void setMnemonicCode(String mnemonicCode) {
    this.mnemonicCode = mnemonicCode;
  }
}