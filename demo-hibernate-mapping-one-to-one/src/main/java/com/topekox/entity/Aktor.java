package com.topekox.entity;

import javax.persistence.*;

@Entity
@Table(name = "aktor")
public class Aktor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nama_depan")
    private String namaDepan;

    @Column(name = "nama_belakang")
    private String namaBelakang;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_biodata_aktor")
    private BiodataAktor biodataAktor;

    public Aktor() {
    }

    public Aktor(String namaDepan, String namaBelakang, String email) {
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BiodataAktor getBiodataAktor() {
        return biodataAktor;
    }

    public void setBiodataAktor(BiodataAktor biodataAktor) {
        this.biodataAktor = biodataAktor;
    }

    @Override
    public String toString() {
        return "Aktor{" +
                "id=" + id +
                ", namaDepan='" + namaDepan + '\'' +
                ", namaBelakang='" + namaBelakang + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

