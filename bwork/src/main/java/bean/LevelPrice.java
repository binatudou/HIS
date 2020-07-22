package bean;

/**
 * 号费
 */
public class LevelPrice {
  private int id;
  private int levelCode;
  private double levelPrice;

  /**
   * @param id         挂号费id
   * @param levelCode  挂号级别码
   * @param levelPrice 挂号费
   */
  public LevelPrice(int id, int levelCode, double levelPrice) {
    this.id = id;
    this.levelCode = levelCode;
    this.levelPrice = levelPrice;
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
   * @return the levelCode
   */
  public int getLevelCode() {
    return levelCode;
  }

  /**
   * @param levelCode the levelCode to set
   */
  public void setLevelCode(int levelCode) {
    this.levelCode = levelCode;
  }

  /**
   * @return the levelPrice
   */
  public double getLevelPrice() {
    return levelPrice;
  }

  /**
   * @param levelPrice the levelPrice to set
   */
  public void setLevelPrice(double levelPrice) {
    this.levelPrice = levelPrice;
  }
}