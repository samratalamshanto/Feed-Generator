package com.solvians.showcase;

import com.solvians.showcase.util.CertificateUpdateUtil;

import java.time.LocalDate;

public class CertificateUpdate {
    private Long timestamp = System.currentTimeMillis();
    private String isin = CertificateUpdateUtil.generateISIN();
    private Double bidPrice = CertificateUpdateUtil.getRandomDoubleInclusive(100, 200);
    private int bidSize = CertificateUpdateUtil.getRandomIntegerInclusive(1000, 5000);
    private Double askPrice = CertificateUpdateUtil.getRandomDoubleInclusive(100, 200);
    private int askSize = CertificateUpdateUtil.getRandomIntegerInclusive(1000, 10000);
    private LocalDate maturityDate = LocalDate.now();


    public CertificateUpdate() {
    }

    public CertificateUpdate(Long timestamp, String isin, Double bidPrice, int bidSize, Double askPrice, int askSize, LocalDate maturityDate) {
        this.timestamp = timestamp;
        this.isin = isin;
        this.bidPrice = bidPrice;
        this.bidSize = bidSize;
        this.askPrice = askPrice;
        this.askSize = askSize;
        this.maturityDate = maturityDate;
    }


    //getter and setter
    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public int getBidSize() {
        return bidSize;
    }

    public void setBidSize(int bidSize) {
        this.bidSize = bidSize;
    }

    public Double getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(Double askPrice) {
        this.askPrice = askPrice;
    }

    public int getAskSize() {
        return askSize;
    }

    public void setAskSize(int askSize) {
        this.askSize = askSize;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

}
