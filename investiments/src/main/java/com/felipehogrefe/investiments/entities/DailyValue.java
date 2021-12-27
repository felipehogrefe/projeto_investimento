package com.felipehogrefe.investiments.entities;

import java.util.Date;

public class DailyValue {
    private Date date;
    private Double totalValue;

    public DailyValue(ShareValue shareValue, int qtdOfQuotas){
        this.date = shareValue.getDate();
        this.totalValue = shareValue.getValue() * qtdOfQuotas;
    }
    public DailyValue() {
    }

    public DailyValue(Date date, Double totalValue) {
        this.date = date;
        this.totalValue = totalValue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
}
