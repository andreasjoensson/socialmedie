package com.example.demo.controllers;

import java.io.Serializable;

public class Post implements Serializable {
    String titel;
    String tekst;
    String dato;
    String erAktiv;
    String yndlingsSprog;

    Post(String titel, String tekst, String dato,String erAktiv, String yndlingsSprog){
        this.titel = titel;
        this.tekst = tekst;
        this.dato = dato;
        this.erAktiv = erAktiv;
        this.yndlingsSprog = yndlingsSprog;
    }

    @Override
    public String toString() {
        return "Post{" +
                "titel='" + titel + '\'' +
                ", tekst='" + tekst + '\'' +
                ", dato='" + dato + '\'' +
                ", erAktiv='" + erAktiv + '\'' +
                ", yndlingsSprog='" + yndlingsSprog + '\'' +
                '}';
    }
}
