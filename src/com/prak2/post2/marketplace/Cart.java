package com.prak2.post2.marketplace;

import java.util.ArrayList;

class Cart {
    private double totalPrice;
    private ArrayList<Product> products;
    // TODO: Deklarasikan list products untuk menyimpan Product (Gunakan ArrayList)
    // TODO: Deklarasikan atribut totalPrice (double)

    // TODO: Constructor cart untuk inisialisasi list dengan list kosong dan totalPrice dengan 0.0
    Cart() {
        this.totalPrice = 0.0;
        this.products = new ArrayList<Product>();
    }
    
    // TODO: Buat method addProduct(Product p) untuk menambah produk ke list & tambah totalPrice dengan harga produk
    public void addProduct(Product p) {
        products.add(p);
        this.totalPrice += p.getPrice();
    }

    // TODO: Buat method getTotalPrice() untuk mendapatkan totalPrice
    public double getTotalPrice() {
        return this.totalPrice;
    }

    // TODO: Buat method showCart() untuk menampilkan isi cart & total harga
    // Case 1 (jika keranjang kosong):
    // Isi Keranjang:
    // (Kosong)

    // Case 2 (jika keranjang ada isinya):
    // Isi Keranjang:
    // - Nama Produk 1 : Harga Produk 1
    // - Nama Produk 2 : Harga Produk 2
    // Total harga: totalPrice
    
    // Hint : Manfaatkan method toString() dari class Product
    public void showCart() {
        if (products.isEmpty()){
            System.out.println ("Isi Keranjang:");
            System.out.println ("(Kosong)");
        } else {
            System.out.println ("Isi Keranjang:");
            for (Product p : products){
                System.out.println (p.toString());
            }
            System.out.println ("Total harga: " + totalPrice);
            
        }
        
    }

    // TODO: Buat method clearCart() untuk mengosongkan list products dan reset totalPrice ke 0.0
    public void clearCart() {
        products.clear();
        totalPrice = 0.0;
    }
}