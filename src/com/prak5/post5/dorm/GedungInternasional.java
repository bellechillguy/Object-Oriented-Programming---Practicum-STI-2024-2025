import java.util.ArrayList;
import java.util.List;

public final class GedungInternasional implements Asrama {
    List<Mahasiswa> penghuni;
    Integer kapasitas;

    /*
     * TODO: Implementasikan constructor kelas GedungInternasional
     * penghuni diinisialisasi dengan ArrayList baru
     * kapasitas diinisialisasi sesuai parameter
     */
    public GedungInternasional(Integer kapasitas) {
        this.penghuni = new ArrayList<>();
        this.kapasitas = kapasitas;
    }

    /*
     * TODO: Implementasikan method infoAsrama
     * Tampilkan "Asrama Gedung Internasional dengan kapasitas <kapasitas>"
     */
    public void infoAsrama() {
        System.out.println("Asrama Gedung Internasional dengan kapasitas " + this.kapasitas);
    }

    /*
     * TODO: Implementasikan method daftarAsrama
     * Jika kapasitas sudah penuh, tampilkan "Asrama Gedung Internasional sudah penuh"
     * Jika mahasiswa sudah terdaftar di asrama lain (assigned), tampilkan "Mahasiswa sudah terdaftar di asrama lain"
     * Jika mahasiswa domestik, tampilkan "Mahasiswa domestik tidak boleh mendaftar di asrama ini"
     * Jika mahasiswa asing dan asrama belum penuh, tambahkan mhs ke penghuni,
     * tampilkan "Mahasiswa <username> diterima di asrama Gedung Internasional"
     * Lalu set asrama mahasiswa ke asrama ini
     */
    public void daftarAsrama(Mahasiswa mhs) {
        if (penghuni.size() >= kapasitas) {
            System.out.println("Asrama Gedung Internasional sudah penuh");
        } else if (mhs.isAssigned()) {
            System.out.println("Mahasiswa sudah terdaftar di asrama lain");
        } else if (mhs instanceof MahasiswaDomestik) {
            System.out.println("Mahasiswa domestik tidak boleh mendaftar di asrama ini");
        } else {
            this.penghuni.add(mhs);
            mhs.setAsrama(this);
            System.out.println("Mahasiswa " + mhs.getUsername() + " diterima di asrama Gedung Internasional");
        }
    }
}