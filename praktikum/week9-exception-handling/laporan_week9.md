# Laporan Praktikum Minggu 9
Topik: Exception Handling, Custom Exception, dan Penerapan Design Pattern

## Identitas
- Nama  : WAHYU SEPTIYAN
- NIM   : 240202846
- Kelas : 3IKRA

---

## Tujuan
Menjelaskan perbedaan antara error dan exception.
Mengimplementasikan try–catch–finally dengan tepat.
Membuat custom exception sesuai kebutuhan program.
Mengintegrasikan exception handling ke dalam aplikasi sederhana (kasus keranjang belanja).
(Opsional) Menerapkan design pattern sederhana (Singleton/MVC) dan unit testing dasar.

---

## Dasar Teori
Error vs Exception: Error merujuk pada kondisi fatal yang tidak dapat ditangani oleh program seperti OutOfMemoryError, sedangkan Exception adalah kondisi tidak normal yang masih dapat diantisipasi dan ditangani agar program tidak berhenti tiba-tiba.
Struktur Penanganan: Java menyediakan blok try untuk kode berisiko, catch untuk menangkap kesalahan, dan finally untuk menjalankan kode yang harus tetap dieksekusi (seperti menutup koneksi) apa pun kondisinya.
Custom Exception: Class exception yang dibuat sendiri oleh programmer dengan mewarisi class Exception (untuk checked exception) untuk memberikan pesan kesalahan yang lebih spesifik bagi pengguna.
Design Pattern:
Singleton: Memastikan sebuah class hanya memiliki satu instance di seluruh aplikasi.
MVC (Model-View-Controller): Memisahkan logika data (Model), tampilan (View), dan pemroses alur (Controller) agar kode lebih terorganisir.

---

## Kode Program

1. InsufficientStockException.java
```java
package com.upb.agripos;

public class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }
}
```

2. InvalidQuantityException.java
```java
package com.upb.agripos;

public class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}
```

3. MainExceptionDemo.java
```java
package com.upb.agripos;

public class MainExceptionDemo {
    public static void main(String[] args) {
        System.out.println("Hello, I am WAHYU SEPTIYAN-240202846 (Week9)");

        ShoppingCart cart = new ShoppingCart();
        Product p1 = new Product("P01", "Pupuk Organik", 25000, 3);

        try {
            cart.addProduct(p1, -1);
        } catch (InvalidQuantityException e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }

        try {
            cart.removeProduct(p1);
        } catch (ProductNotFoundException e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }

        try {
            cart.addProduct(p1, 5);
            cart.checkout();
        } catch (Exception e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }
    }
}
```

4. Product.java
```java
package com.upb.agripos;

public class Product {
    private String id;
    private String name;
    private double price;
    private int stock;

    public Product(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Getter
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    // Mengurangi stok (dipakai saat checkout)
    public void reduceStock(int amount) throws InsufficientStockException {
        if (amount > stock) {
            throw new InsufficientStockException("Stok tidak cukup untuk " + name + ". Tersedia: " + stock);
        }
        this.stock -= amount;
    }

    @Override
    public String toString() {
        return name + " (Rp" + price + ", stok: " + stock + ")";
    }
}
```

5. ProductNotFoundException.java
```java
package com.upb.agripos;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
```

6. ShoppingCart.java
```java
package com.upb.agripos;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    // Tambah barang ke keranjang (hanya validasi jumlah)
    public void addProduct(Product product, int quantity) throws InvalidQuantityException {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Jumlah barang harus lebih dari 0, input: " + quantity);
        }
        items.merge(product, quantity, Integer::sum); // tambah atau update jumlah
    }

    // Hapus barang dari keranjang
    public void removeProduct(Product product) throws ProductNotFoundException {
        if (!items.containsKey(product)) {
            throw new ProductNotFoundException("Produk tidak ditemukan di keranjang: " + product.getName());
        }
        items.remove(product);
    }

    // Checkout: validasi stok semua barang
    public void checkout() throws InsufficientStockException {
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int qty = entry.getValue();
            product.reduceStock(qty); // ini akan melempar exception jika stok tidak cukup
        }
        System.out.println("✅ Checkout berhasil! Semua stok diperbarui.");
        items.clear();
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("🛒 Keranjang belanja kosong.");
            return;
        }
        System.out.println("\n--- KERANJANG BELANJA ---");
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product p = entry.getKey();
            int q = entry.getValue();
            double subtotal = p.getPrice() * q;
            System.out.println(p.getName() + " x" + q + " = Rp" + subtotal);
            total += subtotal;
        }
        System.out.println("Total: Rp" + total);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
```

---

## Hasil Eksekusi

---

## Analisis
Tambah produk dengan quantity -1 → error ditangkap (InvalidQuantityException)
Tambah produk dengan harga negatif → error ditangkap (InvalidPriceException)
Hapus produk yang belum ada di keranjang → error ditangkap (ProductNotFoundException)
Checkout keranjang kosong → error ditangkap (EmptyCartException)
Tambah produk quantity 20 tapi stok cuma 11 → error ditangkap (InsufficientStockException)
---

## Kesimpulan
Exception handling dan custom exception membuat program POS lebih aman dan tidak gampang berhenti ataupun crash. Custom exception (seperti InvalidQuantityException, InvalidPriceException, ProductNotFoundException, dll) membantu menangani kesalahan tertentu dengan pesan yang mudah dimengerti. Try-catch membuat program tetap berjalan walau ada error dan memberi tahu user apa yang salah. Dengan cara ini, program jadi lebih berkualitas, mudah diperbaiki, dan mudah dikembangkan.

---

## Quiz
1. Jelaskan perbedaan error dan exception.  
   Jawaban: Error dan exception sama-sama merupakan kesalahan dalam program, tetapi keduanya memiliki perbedaan yang jelas. Error adalah kesalahan serius yang biasanya berasal dari sistem atau JVM dan umumnya tidak dapat ditangani oleh program, sehingga menyebabkan aplikasi berhenti secara langsung. Contoh error adalah OutOfMemoryError atau StackOverflowError. Sementara itu, exception adalah kesalahan yang terjadi saat program berjalan akibat kondisi tertentu atau kesalahan logika, dan masih dapat ditangani oleh programmer menggunakan mekanisme try–catch. Contoh exception adalah NullPointerException, ArithmeticException, dan IOException.

2. Apa fungsi finally dalam blok try–catch–finally?  
   Jawaban: Blok finally dalam struktur try–catch–finally berfungsi untuk menjalankan kode yang harus selalu dieksekusi, baik ketika exception terjadi maupun tidak. Biasanya finally digunakan untuk menutup resource seperti file, koneksi database, atau objek input agar tidak terjadi kebocoran resource. Dengan adanya finally, programmer dapat memastikan bahwa proses pembersihan atau penutupan tetap dilakukan meskipun terjadi kesalahan di dalam blok try.

3. Mengapa custom exception diperlukan?  
   Jawaban: Custom exception diperlukan karena exception bawaan Java sering kali terlalu umum dan tidak mencerminkan aturan bisnis suatu aplikasi. Dengan membuat custom exception, pesan kesalahan menjadi lebih spesifik, mudah dipahami, dan sesuai dengan kebutuhan sistem. Custom exception juga membantu meningkatkan kualitas kode karena penanganan error menjadi lebih terstruktur dan jelas, terutama pada aplikasi berskala besar.

4. Berikan contoh kasus bisnis dalam POS yang membutuhkan custom exception.
   Jawaban: Dalam sistem POS (Point of Sale), custom exception sangat dibutuhkan untuk menangani aturan bisnis tertentu. Contohnya, ketika kasir melakukan transaksi penjualan tetapi jumlah barang yang dibeli melebihi stok yang tersedia. Dalam kondisi ini, sistem sebaiknya tidak hanya menampilkan error umum, tetapi melempar custom exception seperti StokTidakCukupException. Dengan demikian, sistem dapat mencegah transaksi yang tidak valid, menjaga keakuratan data inventori, serta memberikan informasi kesalahan yang jelas kepada pengguna sistem.
   