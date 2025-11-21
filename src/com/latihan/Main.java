package com.latihan;

class Mahasiswa {
    // data mahasiswa
    String nama;
    String NIM;

    // constructor
    Mahasiswa(String nama, String NIM) {
        this.nama = nama; // (this) merujuk ke class
        this.NIM = NIM;
    }

    // METHOD tanpa RETURN, tanpa PARAMETER
    void show() {
        System.out.println("Nama: " + this.nama);
        System.out.println("NIM: " + this.NIM + "\n");
    }

    // METHOD tanpa RETURN, tanpa PARAMETER
    void setNama(String nama) {
        this.nama = nama;
    }

    // METHOD dengan RETURN, tanpa PARAMETER
    String getNama() {
        return this.nama + " chan!";
    }

    // METHOD dengan RETURN, dengan PARAMETER
    String welcoming(String message) {
        return message + this.nama;

    }
}

public class Main {
    public static void main(String[] args) {
        Mahasiswa mahasiswa1 = new Mahasiswa("Nisrina Zakiyah", "18224001");

        // METHOD
        mahasiswa1.show();

        mahasiswa1.setNama("Belle");
        mahasiswa1.show();

        System.out.println(mahasiswa1.getNama());

        String data = mahasiswa1.welcoming("Selamat datang putra dan putri terbaik bangsa, ");
        System.out.println(data);
    }
}
