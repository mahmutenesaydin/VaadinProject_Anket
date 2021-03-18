package com.uniyaz.core.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Secenek")
public class Secenek extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SECENEK_ADI", nullable = false, length = 100)
    @NotNull
    private String secenek;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SORU", foreignKey = @ForeignKey(name = "FK_SECENEK_SORU"))
    private Soru Soru;

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

    public com.uniyaz.core.domain.Soru getSoru() {
        return Soru;
    }

    public void setSoru(com.uniyaz.core.domain.Soru soru) {
        Soru = soru;
    }
}
