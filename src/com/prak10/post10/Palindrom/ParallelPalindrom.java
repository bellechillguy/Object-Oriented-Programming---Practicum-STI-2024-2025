public class ParallelPalindrom {
    static final int NUM_OF_THREAD = 10;
    
    public boolean isPalindrom(int n) {
        if (n < 0) return false;
        int original = n;
        int reversed = 0;
        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return original == reversed;
    }
    
    // TODO: Lengkapi method ini untuk mencari bilangan palindrom dari [0, N]
    // WAJIB menggunakan concurrency dengan NUM_OF_THREAD threads!

    // Di dalam method run() dalam runnable WAJIB panggil ThreadTracker.mark();
    // Misal :
    // new Thread(() -> {
    //     ThreadTracker.mark(); <- tambahkan ini ketika ingin submit jawaban
    //     //kode lainnya
    // });
    //
    // Atau
    //
    // run(){
    //   ThreadTracker.mark(); <- tambahkan ini ketika ingin submit jawaban
    //   //kode lainnya
    // }

    public int hitungPalindrom(int N) throws InterruptedException {
        // Array untuk menyimpan hasil hitungan dari setiap thread
        final int[] partialResults = new int[NUM_OF_THREAD];
        Thread[] threads = new Thread[NUM_OF_THREAD];

        // Hitung total angka yang akan dicek (0 sampai N inclusive)
        int totalNumbers = N + 1;
        int chunkSize = totalNumbers / NUM_OF_THREAD;
        int remainder = totalNumbers % NUM_OF_THREAD;

        int currentStart = 0;

        for (int i = 0; i < NUM_OF_THREAD; i++) {
            // Menentukan range start dan end untuk thread ke-i
            // Mendistribusikan sisa (remainder) ke thread-thread awal
            int mySize = chunkSize + (i < remainder ? 1 : 0);
            int myStart = currentStart;
            int myEnd = myStart + mySize - 1;
            
            // Update start untuk thread berikutnya
            currentStart += mySize;

            final int threadIndex = i;

            threads[i] = new Thread(() -> {
                ThreadTracker.mark(); // WAJIB dipanggil
                
                int localCount = 0;
                // Pastikan range valid (myStart <= myEnd)
                // Loop dari myStart sampai myEnd untuk cek palindrom
                if (myStart <= myEnd) {
                    for (int num = myStart; num <= myEnd; num++) {
                        if (isPalindrom(num)) {
                            localCount++;
                        }
                    }
                }
                partialResults[threadIndex] = localCount;
            });
            
            threads[i].start();
        }

        // Menunggu semua thread selesai
        for (Thread t : threads) {
            t.join();
        }

        // Menggabungkan hasil dari semua thread
        int totalPalindrom = 0;
        for (int count : partialResults) {
            totalPalindrom += count;
        }

        return totalPalindrom;
    }
}