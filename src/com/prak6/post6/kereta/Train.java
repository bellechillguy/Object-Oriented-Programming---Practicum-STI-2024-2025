public class Train {
    // private String name;
    // private int capacity;
    // private int availableSeats;
    private String name;
    private int capacity;
    private int availableSeats;

    /*
     * Konstruktor Kelas Train
     * TODO: Lengkapi state awal dari attribut Train
     *      - Inisialisasi name dan capacity dari parameter konstruktor
     *      - Inisialisasi availableSeats dengan nilai yang sama dengan capacity
     */
    public Train(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.availableSeats = capacity;
        // TODO: lengkapi konstruktor
    }

    /*
     * Getter untuk name
     * TODO: Getter ini akan mengembalikan String name
     */
    public String getName() {
        return this.name;
        // TODO: lengkapi getter
    }

    /*
     * Method hasAvailableSeats
     * TODO: Method ini akan mengembalikan true jika availableSeats > 0,
     *          mengembalikan false jika tidak
     */
    public boolean hasAvailableSeats() {
        if (this.availableSeats > 0) {
            return true;
        } else {
            return false;
        }
        // TODO: lengkapi method hasAvailableSeats
    }

    /*
     * Method reduceSeat
     * TODO: Method ini berupa prosedur yang akan mengurangi availableSeats 
     *          sebanyak 1 jika availableSeats > 0
     */
    public void reduceSeat() {
        if (this.hasAvailableSeats()) {
            this.availableSeats--;
        }
        // TODO: lengkapi method reduceSeat
    }

    /*
     * Method increaseSeat
     * TODO: Method ini berupa prosedur yang akan menambah availableSeats
     *         sebanyak 1 jika availableSeats < capacity
     */
    public void increaseSeat() {
        if (this.availableSeats < this.capacity) {
            this.availableSeats++;
        }
        // TODO: lengkapi method increaseSeat
    }

    /* 
     * Method toString
     *  TODO: Method ini akan mengembalikan representasi String dari objek Train
     *        dengan format "<name> (Sisa kursi: <availableSeats>/<capacity>)"
     */
    @Override
    public String toString() {
        return String.format("%s (Sisa kursi: %d/%d)", this.name, this.availableSeats, this.capacity);
        // TODO: lengkapi method toString
    }
}
