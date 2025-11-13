package com.upb.agripos.model;

public class Bolpoin extends Produk {
    private String material;

    public Bolpoin(String kode, String nama, double harga, int stok, String material) {
        super(kode, nama, harga, stok);
        this.material = material;
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

        public void deskripsi() {
        System.out.println("=== BOLPOIN ===");
        tampilInfo();
        System.out.println("Material: " + material);
        System.out.println("Keterangan: Bolpoin ini Ajaib.");
    }

}
