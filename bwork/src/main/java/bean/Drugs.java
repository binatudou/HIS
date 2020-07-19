package bean;

public class Drugs {
  private int id;
  private long drugsCode;
  private String drugsName;
  private String drugsFormat;
  private double drugsPrice;
  private String mnemonicCode;

  /**
   * @param id
   * @param drugsCode    药品编码
   * @param drugsName    药品名称
   * @param drugsFormat  药品规格
   * @param drugsPrice   药品价格
   * @param mnemonicCode 药品助记码
   */
  public Drugs(int id, long drugsCode, String drugsName, String drugsFormat, double drugsPrice, String mnemonicCode) {
    this.id = id;
    this.drugsCode = drugsCode;
    this.drugsName = drugsName;
    this.drugsFormat = drugsFormat;
    this.drugsPrice = drugsPrice;
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
   * @return the drugsCode
   */
  public long getDrugsCode() {
    return drugsCode;
  }

  /**
   * @param drugsCode the drugsCode to set
   */
  public void setDrugsCode(long drugsCode) {
    this.drugsCode = drugsCode;
  }

  /**
   * @return the drugsName
   */
  public String getDrugsName() {
    return drugsName;
  }

  /**
   * @param drugsName the drugsName to set
   */
  public void setDrugsName(String drugsName) {
    this.drugsName = drugsName;
  }

  /**
   * @return the drugsFormat
   */
  public String getDrugsFormat() {
    return drugsFormat;
  }

  /**
   * @param drugsFormat the drugsFormat to set
   */
  public void setDrugsFormat(String drugsFormat) {
    this.drugsFormat = drugsFormat;
  }

  /**
   * @return the drugsPrice
   */
  public double getDrugsPrice() {
    return drugsPrice;
  }

  /**
   * @param drugsPrice the drugsPrice to set
   */
  public void setDrugsPrice(double drugsPrice) {
    this.drugsPrice = drugsPrice;
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