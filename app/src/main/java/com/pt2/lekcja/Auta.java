package com.pt2.lekcja;

public class Auta {
    private String marka;
    private String model;
    private int rocznik;
    private double cena;
    private boolean pierwszyWlasciciel;
    private int historia;

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRocznik() {
        return rocznik;
    }

    public void setRocznik(int rocznik) {
        this.rocznik = rocznik;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public boolean isPierwszyWlasciciel() {
        return pierwszyWlasciciel;
    }

    public void setPierwszyWlasciciel(boolean pierwszyWlasciciel) {
        this.pierwszyWlasciciel = pierwszyWlasciciel;
    }

    public int getHistoria() {
        return historia;
    }

    public void setHistoria(int historia) {
        this.historia = historia;
    }
}
