package com.topekox.entity;

import javax.persistence.*;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "judul")
    private String judul;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "id_produser")
    private Produser produser;

    public Film() {
    }

    public Film(String judul) {
        this.judul = judul;
    }

    public Produser getProduser() {
        return produser;
    }

    public void setProduser(Produser produser) {
        this.produser = produser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", judul='" + judul + '\'' +
                '}';
    }
}
