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
