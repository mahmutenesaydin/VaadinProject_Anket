package com.uniyaz.core.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ANKET")
public class Anket extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ANKET_ADI", nullable = false, length = 100)
    @NotNull
    private String ad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KULLANICI", foreignKey = @ForeignKey(name = "FK_ANKET_KULLANICI"))
    private Kullanici kullanici;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SORU", foreignKey = @ForeignKey(name = "FK_ANKET_SORU"))
    private Soru soru;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SECENEK", foreignKey = @ForeignKey(name = "FK_ANKET_SECENEK"))
    private Secenek secenek;



    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }
}
