package com.topekox.entity;

import javax.persistence.*;

@Entity
@Table(name = "biodata_aktor")
public class BiodataAktor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "tempat_lahir")
    private String tempatLahir;

    @Column(name = "instagram")
    private String instagram;

    @Column(name = "hobi")
    private String hobi;

    @OneToOne(mappedBy = "biodataAktor", cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private Aktor aktor;

    public BiodataAktor() {
    }

    public BiodataAktor(String tempatLahir, String instagram, String hobi) {
        this.tempatLahir = tempatLahir;
        this.instagram = instagram;
        this.hobi = hobi;
    }

    public Aktor getAktor() {
        return aktor;
    }

    public void setAktor(Aktor aktor) {
        this.aktor = aktor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getHobi() {
        return hobi;
    }

    public void setHobi(String hobi) {
        this.hobi = hobi;
    }

    @Override
    public String toString() {
        return "BiodataAktor{" +
                "id=" + id +
                ", tempatLahir='" + tempatLahir + '\'' +
                ", instagram='" + instagram + '\'' +
                ", hobi='" + hobi + '\'' +
                '}';
    }
}
