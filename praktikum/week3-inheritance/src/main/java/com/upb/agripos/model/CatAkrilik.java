package com.upb.agripos.model;

public class CatAkrilik extends Produk {
    private String merek;

    public CatAkrilik(String kode, String nama, double harga, int stok, String merek) {
        super(kode, nama, harga, stok);
        this.merek = merek;
    }

    public String getmerek() { return merek; }
    public void setmerek(String merek) { this.merek = merek; }

    public void deskripsi() {
        System.out.println("=== CAT AKRILIK ===");
        tampilInfo();
        System.out.println("merek: " + merek);
        System.out.println("Keterangan: Cat Akrilik ini Sangat cocok digunakan untuk seniman.");
    }
}
