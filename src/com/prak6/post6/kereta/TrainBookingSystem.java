import java.util.List;

public class TrainBookingSystem {
    // private List<Train> trains;
    // private BookingManager bookingManager;
    private List<Train> trains;
    private BookingManager bookingManager;
    /*
     * Konstruktor Kelas TrainBookingSystem
     * TODO: Lengkapi state awal dari attribut TrainBookingSystem
     *      - Inisialisasi trains dari parameter konstruktor
     *      - Inisialisasi bookingManager dengan objek BookingManager baru
     */
    public TrainBookingSystem(List<Train> trains) {
        this.trains = trains;
        this.bookingManager = new BookingManager();

        // TODO: lengkapi konstruktor
    }

    /*
     * Method showTrains
     * TODO:    Method ini berupa prosedur yang akan menampilkan semua kereta yang ada di dalam list trains.
     *          Awali dengan menampilkan header "=== Daftar Kereta Tersedia ==="
     *          - Jika tidak ada kereta, tampilkan pesan "(Tidak ada kereta tersedia)\n"
     *          - Jika trains tidak kosong, print objek train satu per satu dengan format "<index>. <train.toString()>"
     *          - Index dimulai dari 1
     *          - Akhiri dengan baris kosong
     */
    public void showTrains() {
        int index = 1;
        System.out.printf("=== Daftar Kereta Tersedia ===%n");
        if (this.trains.isEmpty()) {
            System.out.printf("(Tidak ada kereta tersedia)\n");
        } else {
            for (Train train : trains) {
                System.out.printf("%d. %s%n", index, train.toString());
                index++;
            }
        }
        // TODO: Lengkapi method showTrains
    }

    /*
     * Method bookTicket
     * TODO:    Method ini berupa prosedur yang akan melakukan booking tiket 
     *          untuk customerName pada kereta dengan nama trainName.
     *          - Jika kereta dengan nama trainName tidak ditemukan, 
     *              tampilkan pesan "Kereta tidak ditemukan: <trainName>"
     *          - Jika kereta ditemukan tetapi tidak ada kursi tersedia, 
     *              tampilkan pesan "Kursi penuh pada kereta: <trainName>"
     *          - Jika booking berhasil, buat objek Booking baru dengan 
     *              customerName dan objek Train yang bersangkutan.
     *              Tambahkan booking ke dalam BookingManager, kurangi kursi pada kereta, 
     *              dan tampilkan pesan "Booking berhasil: <booking.toString()>"
     */
    public void bookTicket(String customerName, String trainName) {
        boolean found = false;
        for (Train train : trains) {
            if (train.getName().equals(trainName)) {
                found = true;
                if (!train.hasAvailableSeats()) {
                    System.out.printf("Kursi penuh pada kereta: %s%n", train.getName());
                } else {
                    Booking booking = new Booking(customerName, train);
                    BookingManager.Action newBooking = bookingManager.new Action();
                    newBooking.addBooking(booking);
                    System.out.printf("Booking berhasil: %s%n", booking.toString());
                    train.reduceSeat();
                }
            }
        }

        if (!found) {
            System.out.printf("Kereta tidak ditemukan: %s%n", trainName);
        }
        // TODO: lengkapi method bookTicket
    }

    /*
     * Method cancelBooking
     * TODO: Method ini berupa prosedur yang akan membatalkan booking dengan bookingId tertentu.
     *         Gunakan method cancel dari BookingManager.Action untuk membatalkan booking.
     * 
     */
    public void cancelBooking(String bookingId) {
        BookingManager.Action cancel = bookingManager.new Action();
        cancel.cancelBooking(bookingId);
        // TODO: lengkapi method cancelBooking
    }

    /*
     * Method showAllBookings
     * TODO: Method ini berupa prosedur yang akan menampilkan semua booking yang ada di dalam BookingManager.
     *        Gunakan method showAllBookings dari BookingManager untuk menampilkan semua booking.
     */
    public void showAllBookings() {
        bookingManager.showAllBookings();
        // TODO: lengkapi method showAllBookings
    }
}
