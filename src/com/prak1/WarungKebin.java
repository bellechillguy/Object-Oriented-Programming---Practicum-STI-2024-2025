package com.prak1;

import java.lang.System;
import java.util.Scanner;

public class WarungKebin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Baca jumlah pembeli (N)
        // HINT: Perhatikan input setelah N ini
        int N = sc.nextInt();

        int i = 0;
        while (i < N) {
           
            String nama = sc.nextLine(); // karena setelah string -> int
            int nomorMeja = sc.nextInt();
            double saldo = sc.nextDouble();
            sc.nextLine();

            // TODO: Baca data pembeli (nama, nomorMeja, saldo)
            // HINT: Perhatikan input setelah data pembeli ini
            String namaMakanan = sc.nextLine();
            int jumlah = sc.nextInt();
            double hargaSatuan = sc.nextDouble();
            sc.nextLine(); // looping
            
            // TODO: Baca data order makanan (namaMakanan, jumlah, hargaSatuan)
            // HINT: Perhatikan input setelah data order makanan ini
            Pembeli pembeli = new Pembeli(nama, nomorMeja, saldo); // new buat objek
            OrderMakanan order = new OrderMakanan(namaMakanan, jumlah, hargaSatuan);
            
            // TODO: Buat objek Pembeli dan OrderMakanan
            // TODO: Cek apakah pembeli bisa membayar sendiri pesanannya
            // TODO: Jika bisa bayar, kurangi saldo pembeli
            double totalHarga = order.getTotalHarga();
            int idOrder = i + 1;
            System.out.println("=== Pembeli " + idOrder + " ===");
            System.out.println("Nama: " + nama + " (Meja " + nomorMeja + ")");
            System.out.println("Pesanan: " + namaMakanan + " x " + jumlah + " @ " + hargaSatuan);
            System.out.println("Total: " + totalHarga);

            if (pembeli.cekBisaBayar(order) == true) {

                double saldoPembeli = pembeli.getSaldo();
                double saldoBaru = saldoPembeli - totalHarga;
                pembeli.setSaldo(saldoBaru);
                
                double currSaldo = pembeli.getSaldo();
                


                System.out.println("Bisa Bayar: Bisa");
                System.out.println("Saldo setelah bayar: " + currSaldo + "\n");
            } else {
                System.out.println("Bisa Bayar: Gak Bisa\n");
            }

            // TODO: Cetak laporan pembeli i
            // HINT: Jika pembeli tidak bisa membayar, tidak perlu tampilkan saldo setelah bayar
            // HINT: Perhatikan lagi format output yang diharapkan
            
            i++;
        }

        sc.close();
    }
}