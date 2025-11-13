# Laporan Praktikum Minggu 4
Topik: Polymorphism

## Identitas
- Nama  : Wahyu septiyan
- NIM   : 240202846
- Kelas : 3IKRA

---

## Tujuan
- Mahasiswa mampu menjelaskan konsep polymorphism dalam OOP.
- Mahasiswa mampu membedakan method overloading dan overriding.
- Mahasiswa mampu mengimplementasikan polymorphism (overriding, overloading, dynamic binding) dalam program.
- Mahasiswa mampu menganalisis contoh kasus polymorphism pada sistem nyata (Agri-POS).

---

## Dasar Teori
Polymorphism berarti “banyak bentuk” dan memungkinkan objek yang berbeda merespons panggilan method yang sama dengan cara yang berbeda.

1. Overloading → mendefinisikan method dengan nama sama tetapi parameter berbeda.
2. Overriding → subclass mengganti implementasi method dari superclass.
3. Dynamic Binding → pemanggilan method ditentukan saat runtime, bukan compile time.

Dalam konteks Agri-POS, misalnya:

- Method getInfo() pada Produk dioverride oleh Benih, Pupuk, AlatPertanian untuk menampilkan detail spesifik.
- Method tambahStok() bisa dibuat overload dengan parameter berbeda (int, double).

---

## Langkah Praktikum

1. Overloading

- Tambahkan method tambahStok(int jumlah) dan tambahStok(double jumlah) pada class Produk.

2. Overriding

- Tambahkan method getInfo() pada superclass Produk.
- Override method getInfo() pada subclass Benih, Pupuk, dan AlatPertanian.

3. Dynamic Binding

- Buat array Produk[] daftarProduk yang berisi objek Benih, Pupuk, dan AlatPertanian.
- Loop array tersebut dan panggil getInfo(). Perhatikan bagaimana Java memanggil method sesuai jenis objek aktual.

4. Main Class

- Buat MainPolymorphism.java untuk mendemonstrasikan overloading, overriding, dan dynamic binding.
 
5. CreditBy

- Tetap panggil CreditBy.print("<NIM>", "<Nama>").

6. Commit dan Push

- Commit dengan pesan: week4-polymorphism

---

## Kode Program

## AlatPertanian.java

```java
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
```

## Benih.java

```java
package com.upb.agripos.model;

public class Benih extends Produk {
    private final String varietas;

    public Benih(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
    }

    @Override
    public String getInfo() {
        return "Benih  : " + super.getInfo() + ", Varietas: " + varietas;
    }
}
```

## ObatHama.java

```java
package com.upb.agripos.model;

public class ObatHama extends Produk {
    private final String targetHama; 

    public ObatHama(String kode, String nama, double harga, int stok, String targetHama) {
        super(kode, nama, harga, stok);
        this.targetHama = targetHama;
    }

    @Override
    public String getInfo() {
        return "ObatHama  : " + super.getInfo() + ", Target: " + targetHama;
    }
} 
```


## Produk.java

```java
package com.upb.agripos.model;


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

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
        System.out.println("Stok " + this.nama + " ditambah " + jumlah + " (int). Stok baru: " + this.stok);
    }

    public void tambahStok(double jumlah) {
        this.stok += (int) jumlah;
        System.out.println("Stok " + this.nama + " ditambah " + (int)jumlah + " (dari double). Stok baru: " + this.stok);
    }

    public String getInfo() {
        return "Produk: " + nama + " (Kode: " + kode + ")";
    }

    public int getStok() {
        return stok;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}
```

## Pupuk.java

```java
package com.upb.agripos.model;

public class Pupuk extends Produk {
    private String jenis; 

    public Pupuk(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    @Override
    public String getInfo() {
        return "Pupuk  : " + super.getInfo() + ", Jenis: " + jenis;
    }
}
```

## CreditBy.java

```java
package com.upb.agripos.util;

public class CreditBy {
   
     public static void print(String nim, String nama) {
        System.out.println("\n=== Credit By ===");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("=================\n");
    }
}
```


## MainPolymorphism.java

```java
package com.upb.agripos;

import com.upb.agripos.model.AlatPertanian;
import com.upb.agripos.model.Benih;
import com.upb.agripos.model.ObatHama;
import com.upb.agripos.model.Produk;
import com.upb.agripos.model.Pupuk; // Untuk latihan mandiri
import com.upb.agripos.util.CreditBy;

public class MainPolymorphism {
    public static void main(String[] args) {
        
        // 1. Implementasi Dynamic Binding (Tugas 3)
        // Array dibuat dari tipe Superclass (Produk)
        Produk[] daftarProduk = {
            // Namun diisi oleh objek-objek Subclass
            new Benih("BNH-001", "Benih Padi IR64", 25000, 100, "IR64"),
            new Pupuk("PPK-101", "Pupuk Urea", 350000, 40, "Urea"),
            new AlatPertanian("ALT-501", "Cangkul Baja", 90000, 15, "Baja"),
            new ObatHama("JKL-234", "Insektisida", 80000, 80, "Walang") // Latihan Mandiri
        };

        System.out.println("===  Daftar Info Produk (Demonstrasi Dynamic Binding) ===");
        
      
        for (Produk p : daftarProduk) {
            System.out.println(p.getInfo()); 
        }

 
        System.out.println("\n=== Demonstrasi Overloading tambahStok ===");
        Produk produkTes = daftarProduk[0]; 
        
        System.out.println("Stok awal: " + produkTes.getStok()); 
        
        // Memanggil method tambahStok(int jumlah)
        produkTes.tambahStok(9); 
        
        // Memanggil method tambahStok(double jumlah)
        produkTes.tambahStok(7.8); 

        
        // 3. Panggil CreditBy
        System.out.println("\n----------");

        CreditBy.print("240202846", "Wahyu Septiyan");
    }
}
```

---

## Hasil Eksekusi
<img width="1920" height="1080" alt="week4 1" src="https://github.com/user-attachments/assets/8834ed7c-8658-40ee-93f8-a4dc13291edb" />

<img width="1920" height="1080" alt="week4 2" src="https://github.com/user-attachments/assets/fb0ff01f-f9ff-4d29-ac24-80c0fe8fac55" />

<img width="1920" height="1080" alt="week4 3" src="https://github.com/user-attachments/assets/a786e610-7e2a-4ade-878e-d624b2047f93" />

---

## Analisis
- Cara Kerja Kode: Program utama (MainPolymorphism) menginisialisasi sebuah array Produk[] yang berisi empat objek subclass (Benih, Pupuk, AlatPertanian, ObatHama). Saat program melakukan iterasi pada array ini, variabel p memiliki tipe referensi Produk. Namun, ketika p.getInfo() dipanggil, Dynamic Binding terjadi: JVM memeriksa tipe objek aktual saat runtime dan memanggil method getInfo() yang telah di-override di subclass yang sesuai (misal, getInfo() milik Benih saat p menunjuk ke objek Benih).
- Demo Overloading: Program juga mendemonstrasikan Overloading dengan sukses. Pemanggilan produkTes.tambahStok(10) memanggil versi (int), dan produkTes.tambahStok(5.5) memanggil versi (double), yang terlihat jelas dari output cetak yang berbeda ((int) vs (dari double)).
- Perbedaan vs Minggu Sebelumnya: Minggu lalu (Inheritance) kita fokus pada mewarisi properti dan method. Minggu ini (Polymorphism), kita fokus pada mengubah perilaku method yang diwarisi tersebut (overriding) dan memperlakukan objek-objek berbeda seolah-olah mereka satu tipe yang sama (dynamic binding dalam array).
- Kendala: Tidak ada kendala signifikan. Kode berjalan sesuai ekspektasi. Implementasi Latihan Mandiri (ObatHama) juga berhasil diintegrasikan ke dalam array daftarProduk dan menampilkan output yang benar.

---

## Kesimpulan
Polymorphism memungkinkan kode yang lebih fleksibel dan mudah dipelihara. Kita dapat menulis kode generik (seperti loop for (Produk p : ...) ) yang dapat bekerja dengan berbagai objek subclass (Benih, Pupuk, dll) tanpa perlu mengetahui tipe spesifiknya.

---

## Quiz
1. Apa perbedaan overloading dan overriding?  
   **Jawaban:** Overloading adalah penggunaan nama method yang sama dalam satu kelas tetapi dengan jumlah atau tipe parameter yang berbeda, sedangkan overriding adalah mendefinisikan ulang method dari kelas induk di dalam kelas anak dengan nama, parameter, dan tipe kembalian yang sama namun isi atau perilakunya berbeda. Overloading terjadi di dalam satu kelas dan termasuk compile time polymorphism, sedangkan overriding terjadi antara dua kelas (induk dan anak) dan termasuk runtime polymorphism.

2. Bagaimana Java menentukan method mana yang dipanggil dalam dynamic binding?
   **Jawaban:** Dalam dynamic binding (atau late binding), Java menentukan method mana yang dipanggil saat program dijalankan (runtime), bukan saat dikompilasi. Prosesnya adalah: ketika sebuah objek dari subclass diacu oleh referensi superclass, Java akan melihat tipe objek sebenarnya di memori, bukan tipe referensinya, untuk memutuskan method mana yang dijalankan.

3. Berikan contoh kasus polymorphism dalam sistem POS selain produk pertanian.
   **Jawaban:** Sistem POS untuk Toko Elektronik
   Dalam sebuah toko elektronik, ada berbagai jenis produk seperti Laptop, Smartphone, dan Aksesoris. Masing-masing produk memiliki cara menampilkan informasi yang berbeda, tetapi semuanya adalah turunan dari kelas Produk.
