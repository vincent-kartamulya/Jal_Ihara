package com.example.jal_ihara;

public class Item {
    String namaticket;
    String deskripsiticket;
    int gambarticket;
    String tanggalticket;

    public Item(String namaticket, String deskripsiticket, int gambarticket, String tanggalticket) {
        this.namaticket = namaticket;
        this.deskripsiticket = deskripsiticket;
        this.gambarticket = gambarticket;
        this.tanggalticket = tanggalticket;
    }

    public String getTanggalticket() {
        return tanggalticket;
    }

    public void setTanggalticket(String tanggalticket) {
        this.tanggalticket = tanggalticket;
    }


    public String getNamaticket() {
        return namaticket;
    }

    public void setNamaticket(String namaticket) {
        this.namaticket = namaticket;
    }

    public String getDeskripsiticket() {
        return deskripsiticket;
    }

    public void setDeskripsiticket(String deskripsiticket) {
        this.deskripsiticket = deskripsiticket;
    }

    public int getGambarticket() {
        return gambarticket;
    }

    public void setGambarticket(int gambarticket) {
        this.gambarticket = gambarticket;
    }




}
