public class COD extends Pembayaran {
    public COD(String namaPelanggan, double jumlah) {
        super(namaPelanggan, jumlah);
    }

    public double hitungTotal() {
        return getJumlah() + 5000;
    }
}