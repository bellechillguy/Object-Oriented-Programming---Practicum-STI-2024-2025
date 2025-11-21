import java.util.*;

public class RequestQueue {
    private final Queue<Integer> q = new LinkedList<>();

    /*
     * Implementasikan method void enqueue(int id) yang akan melakukan penambahan id request ke queue
     * dan melakukan notifyAll() untuk memberitahu thread yang menunggu.
     */
    public synchronized void enqueue(int id) {
        q.add(id);
        notifyAll();
    }


    /*
     * Implementasikan method int dequeue() 
     * Method ini akan melakukan pengambilan id request dari queue. 
     * dan menghapus elemen yang sudah diambil
     * Method melakukan wait() jika queue sedang kosong. 
     * Hint: method throws InterruptedException
     */
    public synchronized int dequeue() throws InterruptedException {
        while (q.isEmpty()) {
            wait();
        }
        return q.poll();
    }
}