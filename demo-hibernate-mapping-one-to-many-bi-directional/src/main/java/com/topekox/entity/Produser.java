package com.topekox.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "produser")
public class Produser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "kota")
    private String kota;

    @OneToMany(mappedBy = "produser", cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private List<Film> films;

    public Produser() {
    }

    public Produser(String nama, String kota) {
        this.nama = nama;
        this.kota = kota;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    @Override
    public String toString() {
        return "Produser{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", kota='" + kota + '\'' +
                '}';
    }

    public void add(Film film) {

        films = Optional.ofNullable(films)
                .orElse(new ArrayList<>());

        films.add(film);
        film.setProduser(this);
    }
}
