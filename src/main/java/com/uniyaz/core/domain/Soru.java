package com.uniyaz.core.domain;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TextField;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SORU")
public class Soru extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SORU", nullable = false, length = 100)
    @NotNull
    private String soru;

    @Column(name = "CEVAP",  nullable = true, length = 100)
    @Enumerated(EnumType.STRING)
    private EnumSoruTuru enumSecenek;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ANKET", foreignKey = @ForeignKey(name = "FK_SORU_ANKET"))
    private Anket anket;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoru() {
        return soru;
    }

    public void setSoru(String soru) {
        this.soru = soru;
    }

    public Anket getAnket() {
        return anket;
    }

    public void setAnket(Anket anket) {
        this.anket = anket;
    }

    public EnumSoruTuru getEnumSecenek() {
        return enumSecenek;
    }

    public void setEnumSecenek(EnumSoruTuru enumSecenek) {
        this.enumSecenek = enumSecenek;
    }
}
