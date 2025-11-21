public class TransferBank extends Pembayaran {
    public TransferBank(String namaPelanggan, double jumlah) {
        super(namaPelanggan, jumlah);
    }

    public double hitungTotal() {
        return getJumlah() + 4000;
    }
}
