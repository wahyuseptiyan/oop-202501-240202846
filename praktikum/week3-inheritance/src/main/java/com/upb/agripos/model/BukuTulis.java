package com.upb.agripos.model;

public class BukuTulis extends Produk {
    private String merek;

    public BukuTulis(String kode, String nama, double harga, int stok, String merek) {
        super(kode, nama, harga, stok);
        this.merek = merek;
    }

    public String getmerek() { return merek; }
    public void setmerek(String merek) { this.merek = merek; }

    public void deskripsi() {
        System.out.println("=== BukuTulis ===");
        tampilInfo();
        System.out.println("merek: " + merek );
        System.out.println("Keterangan: Buku Tulis ini cocok untuk semua Kalangan.");
    }
}
