package com.felipehogrefe.investiments.entities;

import javax.persistence.*;
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

    private Double value;
    private Date startDate;
    private Date endDate;


    public Investment() {
    }

    public Investment(Share share, User user_id, Double value, Date startDate, Date endDate) {
        this.share = share;
        this.user = user_id;
        this.value = value;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Investment(Long id, Share share, User user_id, Double value, Date startDate, Date endDate) {
        this.id = id;
        this.share = share;
        this.user = user_id;
        this.value = value;
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Investment that = (Investment) o;

        if (!getShare().equals(that.getShare())) return false;
        if (!getUser().equals(that.getUser())) return false;
        if (!getValue().equals(that.getValue())) return false;
        if (!getStartDate().equals(that.getStartDate())) return false;
        return getEndDate() != null ? getEndDate().equals(that.getEndDate()) : that.getEndDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getShare().hashCode();
        result = 31 * result + getUser().hashCode();
        result = 31 * result + getValue().hashCode();
        result = 31 * result + getStartDate().hashCode();
        result = 31 * result + (getEndDate() != null ? getEndDate().hashCode() : 0);
        return result;
    }
}
