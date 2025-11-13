package com.upb.agripos.model;

public class AlatPertanian extends Produk {
    private final String bahan; 

    public AlatPertanian(String kode, String nama, double harga, int stok, String bahan) {
        super(kode, nama, harga, stok);
        this.bahan = bahan;
    }

    @Override
    public String getInfo() {
        return "AlatPertanian   : " + super.getInfo() + ", bahan: " + bahan;
    }
}
