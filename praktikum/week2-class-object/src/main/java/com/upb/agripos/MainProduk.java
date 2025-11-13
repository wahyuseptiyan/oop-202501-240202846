package main.java.com.upb.agripos;

import main.java.com.upb.agripos.model.Produk;
import main.java.com.upb.agripos.util.CreditBy;

public class MainProduk {
    public static void main(String[] args) {
        Produk p1 = new Produk("QWE-098", "BUKU TULIS", 5000, 50);
        Produk p2 = new Produk("RTY-765", "BOLPOIN STANDAR", 3000, 90);
        Produk p3 = new Produk("UIO-432", "CAT AKRILIK", 25000, 20);
        Produk p4 = new Produk("PLK-123", "TINTA PRINTER", 35000, 15);

        System.out.println("Kode: " + p1.getKode() + ", Nama: " + p1.getNama() + ", Harga: " + p1.getHarga() + ", Stok: " + p1.getStok());
        System.out.println("Kode: " + p2.getKode() + ", Nama: " + p2.getNama() + ", Harga: " + p2.getHarga() + ", Stok: " + p2.getStok());
        System.out.println("Kode: " + p3.getKode() + ", Nama: " + p3.getNama() + ", Harga: " + p3.getHarga() + ", Stok: " + p3.getStok());
        System.out.println("Kode: " + p4.getKode() + ", Nama: " + p4.getNama() + ", Harga: " + p4.getHarga() + ", Stok: " + p4.getStok());

        System.out.println("Perubahan Stok");
        p1.tambahstok(10) ; p1.kurangistok(43);
        p2.tambahstok(10); 
        p3.kurangistok(5); 
        
        System.out.println("Setelah perubahan:");
        System.out.println(p1.getNama() + " stok sekarang: " + p1.getStok());
        System.out.println(p2.getNama() + " stok sekarang: " + p2.getStok());
        System.out.println(p3.getNama() + " stok sekarang: " + p3.getStok());


        CreditBy.print("240202846", "WAHYU SEPTIYAN");
    }
}
