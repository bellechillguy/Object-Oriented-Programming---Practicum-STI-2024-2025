public class EWallet extends Pembayaran {
    public EWallet(String namaPelanggan, double jumlah) {
        super(namaPelanggan, jumlah);
    }

    public double hitungTotal() {
        return getJumlah() + (getJumlah() * 0.01);
    }
}
