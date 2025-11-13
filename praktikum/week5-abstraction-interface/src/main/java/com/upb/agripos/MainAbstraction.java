package main.java.com.upb.agripos;

import main.java.com.upb.agripos.Model.Pembayaran.*;
import main.java.com.upb.agripos.Model.Kontrak.*;
import main.java.com.upb.agripos.util.CreditBy;

public class MainAbstraction {
    public static void main(String[] args) {
        Pembayaran cash = new Cash("AZW-123", 160000, 180000);
        Pembayaran ew = new EWallet("PKI-666", 220000, "MasTiyan@ewallet", "888777");

        System.out.println(((Receiptable) cash).cetakStruk());
        System.out.println(((Receiptable) ew).cetakStruk());

    CreditBy.print("240202846", "Wahyu Septiyan");
    }
}
