package com.felipehogrefe.investiments.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_share")
public class Share {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String acronym;

    public Share() {
    }

    public Share(String acronym) {
        this.acronym = acronym;
    }

    public Share(Long id, String acronym) {
        this.id = id;
        this.acronym = acronym;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Share share = (Share) o;

        return getAcronym() != null ? getAcronym().equals(share.getAcronym()) : share.getAcronym() == null;
    }

    @Override
    public int hashCode() {
        return getAcronym() != null ? getAcronym().hashCode() : 0;
    }
}
