package au.edu.unsw.infs3634.cryptobag.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

  @SerializedName("coins_num")
  @Expose
  private Integer coinsNum;
  @SerializedName("time")
  @Expose
  private Integer time;

  public Integer getCoinsNum() {
    return coinsNum;
  }

  public void setCoinsNum(Integer coinsNum) {
    this.coinsNum = coinsNum;
  }

  public Integer getTime() {
    return time;
  }

  public void setTime(Integer time) {
    this.time = time;
  }

}