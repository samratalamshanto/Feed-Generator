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

    public CertificateUpdate(Long timestamp, String isin, Double bidPrice, int bidSize, Double askPrice, int askSize) {
        this.timestamp = timestamp;
        this.isin = isin;
        this.bidPrice = bidPrice;
        this.bidSize = bidSize;
        this.askPrice = askPrice;
        this.askSize = askSize;
    }


    public CertificateUpdate() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "CertificateUpdate{" +
                "timestamp=" + timestamp +
                ", isin='" + isin + '\'' +
                ", bidPrice=" + bidPrice +
                ", bidSize=" + bidSize +
                ", askPrice=" + askPrice +
                ", askSize=" + askSize +
                ", maturityDate=" + maturityDate +
                '}';
    }
}
