# Laporan Praktikum Minggu 3
Topik: Inheritance

## Identitas
- Nama  : Wahyu Septiyan
- NIM   : 240202846
- Kelas : 3IKRA

---

## Tujuan
- Mahasiswa mampu menjelaskan konsep inheritance (pewarisan class) dalam OOP.
- Mahasiswa mampu membuat superclass dan subclass untuk produk pertanian.
- Mahasiswa mampu mendemonstrasikan hierarki class melalui contoh kode.
- Mahasiswa mampu menggunakan super untuk memanggil konstruktor dan method parent class.
- Mahasiswa mampu membuat laporan praktikum yang menjelaskan perbedaan penggunaan inheritance dibanding class tunggal.

---

## Dasar Teori
Inheritance adalah mekanisme dalam OOP yang memungkinkan suatu class mewarisi atribut dan method dari class lain.

- Superclass: class induk yang mendefinisikan atribut umum.
- Subclass: class turunan yang mewarisi atribut/method superclass, dan dapat menambahkan atribut/method baru.
- super digunakan untuk memanggil konstruktor atau method superclass.

Dalam konteks Agri-POS, kita dapat membuat class Produk sebagai superclass, kemudian Bolpoin, BukuTulis, dan Cat Akrilik sebagai subclass. Hal ini membuat kode lebih reusable dan terstruktur.

---

## Langkah Praktikum
1. Membuat Superclass Produk

- Gunakan class Produk dari Bab 2 sebagai superclass.

2. Membuat Subclass

- Bolpoin.java → atribut tambahan: material.
- Buku Tulis.java → atribut tambahan: merek pupuk.
- Cat Akrilik.java → atribut tambahan: merek

3. Membuat Main Class

- Instansiasi minimal satu objek dari tiap subclass.
- Tampilkan data produk dengan memanfaatkan inheritance.

4. Menambahkan CreditBy

- Panggil class CreditBy untuk menampilkan identitas mahasiswa.

5. Commit dan Push

- Commit dengan pesan: week3-inheritance.

---

## Kode Program

1. Bolpoin.Java

```java
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
```

2. BukuTulis.java

```java
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
```

3. CatAkrilik.java

```java
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
```

4. Produk.java

```java
package com.upb.agripos.model;
// Produk.java

public class Produk {
    private String kode;
    private String nama;
    private double harga;
    private int stok;

    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }

    public void setKode(String kode) { this.kode = kode; }
    public void setNama(String nama) { this.nama = nama; }
    public void setHarga(double harga) { this.harga = harga; }
    public void setStok(int stok) { this.stok = stok; }

    public void tampilInfo() {
        System.out.println("Kode: " + kode);
        System.out.println("Nama: " + nama);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Stok: " + stok);
    }

}
```

5. CreditBy.java

```java
package com.upb.agripos.util;

public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\n=== Credit By ===");
        System.out.println("NIM  : " + nim);
        System.out.println("Nama : " + nama);
    }
}
```

6. MainInheritance.java

```java
package com.upb.agripos;

import com.upb.agripos.model.*;
import com.upb.agripos.util.CreditBy;

public class MainInheritance {
    public static void main(String[] args) {
        BukuTulis b = new BukuTulis("QWE-098", "BUKU TULIS SIDU", 5000, 50, "SIDU");
        CatAkrilik p = new CatAkrilik("UIO-432", "CAT AKRILIK", 25000, 20, "MORITSU");
        Bolpoin a = new Bolpoin("RTY-765", "BOLPOIN STANDAR", 3000, 90, "Plastik");

        b.deskripsi();
        System.out.println();
        p.deskripsi();
        System.out.println();
        a.deskripsi();
        System.out.println();

        CreditBy.print("240202846", "Wahyu Septiyan");
    }
}
```

---


## Hasil Eksekusi
<img width="1920" height="1080" alt="week3" src="https://github.com/user-attachments/assets/54b35910-6de8-4864-aab7-76de85499d59" />

---

## Analisis
- Setiap subclass (Bolpoin, Buku Tulis dan Cat Akrilik) mewarisi atribut dan method dari superclass Produk.
- Override method deskripsi() memungkinkan setiap subclass menambahkan informasi spesifik tanpa menulis ulang kode dasar.
- Pemanggilan super() pada konstruktor memastikan atribut dasar (kode, nama, harga, stok) diinisialisasi dengan benar.
- Struktur program lebih terorganisir, efisien, dan mudah dikembangkan dibanding class tunggal.
- Tidak ada error kompilasi — program berjalan sempurna dan menampilkan hasil sesuai ekspektasi.

---

## Kesimpulan
Penerapan inheritance memungkinkan penggunaan ulang kode dari superclass sehingga mengurangi duplikasi dan meningkatkan modularitas. Dengan konsep ini, pengembangan sistem Agri-POS menjadi lebih terstruktur dan mudah dikelola.

---

## Quiz
1. Apa keuntungan menggunakan inheritance dibanding membuat class terpisah tanpa hubungan? Jawaban: Inheritance menghemat kode dengan mewarisi atribut dan method dari superclass, sehingga tidak perlu menulis ulang kode yang sama di setiap class.

2. Bagaimana cara subclass memanggil konstruktor superclass? Jawaban: Dengan menggunakan kata kunci super(parameter...) di dalam konstruktor subclass.

3. Berikan contoh kasus di POS pertanian selain Benih, Pupuk, dan Alat Pertanian yang bisa dijadikan subclass. Jawaban: Contohnya Tanaman, Hama dan Obat Tanaman
