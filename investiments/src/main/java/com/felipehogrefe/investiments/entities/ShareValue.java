package com.felipehogrefe.investiments.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_share_value")
public class ShareValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double value;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "share_id")
    private Share share;

    public ShareValue() {
    }

    public ShareValue(Double value, Date date, Share share) {
        this.value = value;
        this.date = date;
        this.share = share;
    }

    public ShareValue(Long id, Double value, Date date, Share share) {
        this.id = id;
        this.value = value;
        this.date = date;
        this.share = share;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Share getShare() {
        return share;
    }

    public void setShare(Share share) {
        this.share = share;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShareValue that = (ShareValue) o;

        if (!getDate().equals(that.getDate())) return false;
        return getShare().equals(that.getShare());
    }

    @Override
    public int hashCode() {
        int result = getDate().hashCode();
        result = 31 * result + getShare().hashCode();
        return result;
    }
}
