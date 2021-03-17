package com.uniyaz.core.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SECENEK")
public class Secenek extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SECENEK", nullable = false, length = 100)
    @NotNull
    private String secenek;


    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSecenek() {
        return secenek;
    }

    public void setSecenek(String secenek) {
        this.secenek = secenek;
    }
}
