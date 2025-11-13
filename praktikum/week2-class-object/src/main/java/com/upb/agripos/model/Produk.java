package main.java.com.upb.agripos.model;

public class Produk {
    private String kode;
    private String nama;
    private double harga;
    private int stok;

    // Constructor
    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter dan Setter
    public String getKode() { return kode; }
    public void setKode(String kode) { this.kode = kode; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    // Method tambahan untuk menampilkan info produk
    public void tampilkanInfo() {
        System.out.println("Kode Produk : " + kode);
        System.out.println("Nama Produk : " + nama);
        System.out.println("Harga       : Rp" + harga);
        System.out.println("Stok        : " + stok + " unit");
        System.out.println("----------------------------------");
    }

    public void tambahstok(int jumlah) {
        this.stok += jumlah;
    }

    // Kurangi stok
    public void kurangistok(int jumlah) {
        if (this.stok >= jumlah) {
            this.stok -= jumlah;
        } else {
            System.out.println("Stok tidak mencukupi!");
        }
    }

}
