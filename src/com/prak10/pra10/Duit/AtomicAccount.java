import java.util.concurrent.atomic.AtomicLong;

/**
 * AtomicAccount merepresentasikan akun bank yang menggunakan AtomicLong
 * untuk operasi thread-safe tanpa lock (lock-free).
 */
public class AtomicAccount {
    private final AtomicLong balance;

    public AtomicAccount(long initialBalance) {
        // Inisialisasi balance dengan nilai awal
        this.balance = new AtomicLong(initialBalance);
    }

    public void increment(long amount) {
        // addAndGet melakukan penambahan secara atomik (thread-safe)
        // Tidak perlu synchronized karena AtomicLong menanganinya di level CPU
        balance.addAndGet(amount);
    }

    public long getBalance() {
        // Mengambil value terkini dari AtomicLong
        // get() pada AtomicLong memiliki efek memori volatile (selalu fresh dari RAM)
        return balance.get();
    }
}