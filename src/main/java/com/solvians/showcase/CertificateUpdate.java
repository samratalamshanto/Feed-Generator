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
}
