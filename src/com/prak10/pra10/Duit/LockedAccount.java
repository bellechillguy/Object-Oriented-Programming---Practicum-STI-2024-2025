import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LockedAccount merepresentasikan akun bank yang menggunakan ReentrantLock
 * untuk operasi thread-safe dengan kontrol yang lebih eksplisit.
 */
public class LockedAccount {
    private long balance;
    private final Lock lock;

    public LockedAccount(long initialBalance) {
        this.balance = initialBalance;
        // Inisialisasi lock. ReentrantLock memungkinkan thread yang sama 
        // masuk ke lock yang sudah ia pegang berulang kali.
        this.lock = new ReentrantLock();
    }

    public void deposit(long amount) {
        lock.lock(); // 1. Acquire lock
        try {
            // 2. Critical section
            balance += amount;
        } finally {
            // 3. Release lock (WAJIB di finally agar terpanggil meski ada error)
            lock.unlock();
        }
    }

    public boolean withdraw(long amount) {
        lock.lock();
        try {
            // Check-then-act pattern
            if (balance >= amount) {
                balance -= amount;
                return true;
            }
            return false;
        } finally {
            // Unlock tetap akan dipanggil sebelum method return value
            lock.unlock();
        }
    }

    public long getBalance() {
        lock.lock();
        try {
            // Read juga perlu di-lock untuk "memory visibility"
            // Agar thread ini melihat update terbaru dari thread lain
            return balance;
        } finally {
            lock.unlock();
        }
    }
}