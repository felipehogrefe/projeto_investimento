package com.felipehogrefe.investiments.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Table(name = "tb_investment")
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "share_id")
    private Share share;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Double initialValue;
    private int quantityOfQuotas;
    private Date startDate;
    private Date endDate;


    public Investment() {
    }

    public Investment(Share share, User user, Double initialValue, int totalQuotas, Date startDate, Date endDate) {
        this.share = share;
        this.user = user;
        this.initialValue = initialValue;
        this.quantityOfQuotas = totalQuotas;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Investment(Long id, Share share, User user, Double initialValue, int totalQuotas, Date startDate, Date endDate) {
        this.id = id;
        this.share = share;
        this.user = user;
        this.initialValue = initialValue;
        this.quantityOfQuotas = totalQuotas;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Share getShare() {
        return share;
    }

    public void setShare(Share share) {
        this.share = share;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Double initialValue) {
        this.initialValue = initialValue;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public LocalDate getLocalStartDate(){
        return startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public LocalDate getLocalEndDate(){
        return endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public int getQuantityOfQuotas() {
        return quantityOfQuotas;
    }

    public void setQuantityOfQuotas(int quantityOfQuotas) {
        this.quantityOfQuotas = quantityOfQuotas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Investment that = (Investment) o;

        if (getQuantityOfQuotas() != that.getQuantityOfQuotas()) return false;
        if (!getShare().equals(that.getShare())) return false;
        if (!getUser().equals(that.getUser())) return false;
        if (!getInitialValue().equals(that.getInitialValue())) return false;
        if (!getStartDate().equals(that.getStartDate())) return false;
        return getEndDate().equals(that.getEndDate());
    }

    @Override
    public int hashCode() {
        int result = getShare().hashCode();
        result = 31 * result + getUser().hashCode();
        result = 31 * result + getInitialValue().hashCode();
        result = 31 * result + getQuantityOfQuotas();
        result = 31 * result + getStartDate().hashCode();
        result = 31 * result + getEndDate().hashCode();
        return result;
    }
}
