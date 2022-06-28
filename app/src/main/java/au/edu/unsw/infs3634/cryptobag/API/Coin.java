package au.edu.unsw.infs3634.cryptobag.API;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Coin {

  @SerializedName("id")
  @Expose
  private String id;
  @SerializedName("symbol")
  @Expose
  private String symbol;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("nameid")
  @Expose
  private String nameid;
  @SerializedName("rank")
  @Expose
  private Integer rank;
  @SerializedName("price_usd")
  @Expose
  private String priceUsd;
  @SerializedName("percent_change_24h")
  @Expose
  private String percentChange24h;
  @SerializedName("percent_change_1h")
  @Expose
  private String percentChange1h;
  @SerializedName("percent_change_7d")
  @Expose
  private String percentChange7d;
  @SerializedName("price_btc")
  @Expose
  private String priceBtc;
  @SerializedName("market_cap_usd")
  @Expose
  private String marketCapUsd;
  @SerializedName("volume24")
  @Expose
  private Double volume24;
  @SerializedName("volume24a")
  @Expose
  private Double volume24a;
  @SerializedName("csupply")
  @Expose
  private String csupply;
  @SerializedName("tsupply")
  @Expose
  private String tsupply;
  @SerializedName("msupply")
  @Expose
  private String msupply;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNameid() {
    return nameid;
  }

  public void setNameid(String nameid) {
    this.nameid = nameid;
  }

  public Integer getRank() {
    return rank;
  }

  public void setRank(Integer rank) {
    this.rank = rank;
  }

  public String getPriceUsd() {
    return priceUsd;
  }

  public void setPriceUsd(String priceUsd) {
    this.priceUsd = priceUsd;
  }

  public String getPercentChange24h() {
    return percentChange24h;
  }

  public void setPercentChange24h(String percentChange24h) {
    this.percentChange24h = percentChange24h;
  }

  public String getPercentChange1h() {
    return percentChange1h;
  }

  public void setPercentChange1h(String percentChange1h) {
    this.percentChange1h = percentChange1h;
  }

  public String getPercentChange7d() {
    return percentChange7d;
  }

  public void setPercentChange7d(String percentChange7d) {
    this.percentChange7d = percentChange7d;
  }

  public String getPriceBtc() {
    return priceBtc;
  }

  public void setPriceBtc(String priceBtc) {
    this.priceBtc = priceBtc;
  }

  public String getMarketCapUsd() {
    return marketCapUsd;
  }

  public void setMarketCapUsd(String marketCapUsd) {
    this.marketCapUsd = marketCapUsd;
  }

  public Double getVolume24() {
    return volume24;
  }

  public void setVolume24(Double volume24) {
    this.volume24 = volume24;
  }

  public Double getVolume24a() {
    return volume24a;
  }

  public void setVolume24a(Double volume24a) {
    this.volume24a = volume24a;
  }

  public String getCsupply() {
    return csupply;
  }

  public void setCsupply(String csupply) {
    this.csupply = csupply;
  }

  public String getTsupply() {
    return tsupply;
  }

  public void setTsupply(String tsupply) {
    this.tsupply = tsupply;
  }

  public String getMsupply() {
    return msupply;
  }

  public void setMsupply(String msupply) {
    this.msupply = msupply;
  }

  // Return a coin by looking up its symbol
  public static Coin findCoin(String symbol) {
    // Get the coin list from CoinLoreResponse json string
    Gson gson = new Gson();
    CoinLoreResponse response = gson.fromJson(CoinLoreResponse.jsonData, CoinLoreResponse.class);
    List<Coin> coins = response.getData();
    for(final Coin coin : coins) {
      if(coin.getSymbol().equals(symbol)) {
        return coin;
      }
    }
    return null;
  }


}