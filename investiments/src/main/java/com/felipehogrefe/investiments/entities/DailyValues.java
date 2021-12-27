package com.felipehogrefe.investiments.entities;

import java.util.List;

public class DailyValues {
    private List<DailyValue> dailyValueList;
    private Double total;

    public DailyValues(List<DailyValue> shareValueList) {
        this.dailyValueList = shareValueList;
        this.total = shareValueList.stream().mapToDouble(DailyValue::getTotalValue).sum();
    }

    public List<DailyValue> getDailyValueList() {
        return dailyValueList;
    }

    public void setDailyValueList(List<DailyValue> dailyValueList) {
        this.dailyValueList = dailyValueList;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
