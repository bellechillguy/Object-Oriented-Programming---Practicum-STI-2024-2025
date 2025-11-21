/**
 * SynchronizedAccount merepresentasikan akun bank yang menggunakan synchronized methods
 * untuk memastikan operasi yang thread-safe.
 */
public class SynchronizedAccount {
    private long balance;

    public SynchronizedAccount(long initialBalance) {
        this.balance = initialBalance;
    }

    /**
     * Keyword 'synchronized' memastikan hanya 1 thread yang bisa masuk
     * ke method ini (atau method synchronized lain di object ini) pada satu waktu.
     */
    public synchronized void deposit(long amount) {
        balance += amount;
    }

    public synchronized boolean withdraw(long amount) {
        // Aman dari race condition karena dilindungi synchronized
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public synchronized long getBalance() {
        // Synchronized pada getter penting agar thread tidak membaca
        // nilai "stale" (kadaluarsa) saat thread lain sedang menulis.
        return balance;
    }
}