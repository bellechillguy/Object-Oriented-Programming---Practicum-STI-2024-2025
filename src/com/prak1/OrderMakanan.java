package com.prak1;

public class OrderMakanan {
    private String namaMakanan;
    private int countMakanan;
    private double hargaSatuan;

    /**
     * Konstruktor OrderMakanan
     * @param nama
     * @param count
     * @param harga
     */

    public OrderMakanan(String nama, int count, double harga) {
        // TODO: inisialisasi atribut
        this.namaMakanan = nama;
        this.countMakanan = count;
        this.hargaSatuan = harga;
    }

    /**
     * getNamaMakanan
     * @return namaMakanan
     */
    public String getNamaMakanan() {
        return this.namaMakanan;
        // TODO: return namaMakanan
    }

    /**
     * setNamaMakanan
     * @param namaBaru
     */
    public void setNamaMakanan(String namaBaru) {
        this.namaMakanan = namaBaru;
        // TODO: ubah nilai namaMakanan
    }

    /**
     * getcountMakanan
     * @return countMakanan
     */

    public int getcountMakanan() {
        return this.countMakanan;
        // TODO: return countMakanan
    }

    /**
     * setcountMakanan
     * @param countBaru
     */
    public void setcountMakanan(int countBaru) {
        this.countMakanan = countBaru;
        // TODO: ubah nilai countMakanan
    }

    /**
     * getHargaSatuan
     * @return hargaSatuan
     */

    public double getHargaSatuan() {
        return this.hargaSatuan;
        // TODO: return hargaSatuan
    }

    /**
     * setHargaSatuan
     * @param hargaBaru
     */
    public void setHargaSatuan(double hargaBaru) {
        this.hargaSatuan = hargaBaru;
        // TODO: ubah nilai hargaSatuan
    }

    /**
     * increasecountMakanan
     * Menambahkan countMakanan pesanan
     * @param tambahan
     */
    public void increasecountMakanan(int tambahan) {
        if (tambahan > 0) {
            this.countMakanan += tambahan;
        }
        // TODO: tambahkan nilai countMakanan dengan tambahan
        // Hint: hanya jika tambahan > 0
    }

    /**
     * decreasecountMakanan
     * Mengurangi countMakanan pesanan
     * @param pengurangan
     */
    public void decreasecountMakanan(int pengurangan) {
        if (pengurangan > 0) {
            this.countMakanan -= pengurangan;
        }
        // TODO: kurangi nilai countMakanan dengan pengurangan
        // Hint: hanya jika pengurangan > 0
    }

    /**
     * getTotalHarga
     * Menghitung total harga pesanan
     * @return totalHarga
     */
    

    public double getTotalHarga() {
        return this.countMakanan * this.hargaSatuan;
        // TODO: hitung total harga pesanan
    }
}

// public class Main {
//     public static void main(String[] args) {
//         System.out.println(totalHarga);
//     }
// }