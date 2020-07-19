package bean;

public class PresItem {
  private int id;
  private int prescriptionID;
  private int drugID;
  private String drugName;
  private double drugPrice;
  private int drugNumber;
  private String description;
  private int paymentStatus;

  /**
   * @param id
   * @param prescriptionID 处方id
   * @param drugID         药品id
   * @param drugName       药品名
   * @param drugPrice      药品单价
   * @param drugNumber     药品数量
   * @param description    服用描述
   * @param paymentStatus  付费状态
   */
  public PresItem(int id, int prescriptionID, int drugID, String drugName, double drugPrice, int drugNumber,
      String description, int paymentStatus) {
    this.id = id;
    this.prescriptionID = prescriptionID;
    this.drugID = drugID;
    this.drugName = drugName;
    this.drugPrice = drugPrice;
    this.drugNumber = drugNumber;
    this.description = description;
    this.paymentStatus = paymentStatus;
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
   * @return the prescriptionID
   */
  public int getPrescriptionID() {
    return prescriptionID;
  }

  /**
   * @param prescriptionID the prescriptionID to set
   */
  public void setPrescriptionID(int prescriptionID) {
    this.prescriptionID = prescriptionID;
  }

  /**
   * @return the drugID
   */
  public int getDrugID() {
    return drugID;
  }

  /**
   * @param drugID the drugID to set
   */
  public void setDrugID(int drugID) {
    this.drugID = drugID;
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
   * @return the drugNumber
   */
  public int getDrugNumber() {
    return drugNumber;
  }

  /**
   * @param drugNumber the drugNumber to set
   */
  public void setDrugNumber(int drugNumber) {
    this.drugNumber = drugNumber;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return the paymentStatus
   */
  public int getPaymentStatus() {
    return paymentStatus;
  }

  /**
   * @param paymentStatus the paymentStatus to set
   */
  public void setPaymentStatus(int paymentStatus) {
    this.paymentStatus = paymentStatus;
  }
}