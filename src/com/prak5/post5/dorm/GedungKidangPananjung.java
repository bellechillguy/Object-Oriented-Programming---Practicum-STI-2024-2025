import java.util.ArrayList;
import java.util.List;

public final class GedungKidangPananjung implements Asrama {

    List<Mahasiswa> penghuni;
    Integer kapasitas;

    /*
     * TODO: Implementasikan constructor kelas GedungKidangPananjung
     * penghuni diinisialisasi dengan ArrayList baru
     * kapasitas diinisialisasi sesuai parameter
     */
    public GedungKidangPananjung(Integer kapasitas) {
        this.penghuni = new ArrayList<>();
        this.kapasitas = kapasitas;
    }

    /*
     * TODO: Implementasikan method infoAsrama
     * Tampilkan "Asrama Gedung Kidang Pananjung dengan kapasitas <kapasitas>"
     */
    public void infoAsrama() {
        System.out.println("Asrama Gedung Kidang Pananjung dengan kapasitas " + this.kapasitas);
    }

    /*
     * TODO: Implementasikan method daftarAsrama
     * Asrama kidang pananjung hanya untuk mahasiswa domestik PRIA
     *
     * Jika kapasitas asrama penuh, tampilkan "Asrama Gedung Kidang Pananjung sudah penuh"
     * Jika mahasiswa sudah terdaftar di asrama lain (assigned), tampilkan "Mahasiswa sudah terdaftar di asrama lain"
     * Jika mahasiswa asing, tampilkan "Mahasiswa asing tidak boleh mendaftar di asrama ini"
     * Jika mahasiswa domestik WANITA, tampilkan "Asrama Gedung Kidang Pananjung hanya untuk mahasiswa laki-laki"
     * Jika mahasiswa domestik PRIA dan asrama belum penuh, tambahkan mhs ke penghuni,
     * tampilkan "Mahasiswa <username> diterima di asrama Gedung Kidang Pananjung"
     * Lalu set asrama mahasiswa ke asrama ini
     */
    public void daftarAsrama(Mahasiswa mhs) {
        if (penghuni.size() >= kapasitas) {
            System.out.println("Asrama Gedung Kidang Pananjung sudah penuh");
        } else if (mhs.isAssigned()) {
            System.out.println("Mahasiswa sudah terdaftar di asrama lain");
        } else if (mhs instanceof MahasiswaAsing) {
            System.out.println("Mahasiswa asing tidak boleh mendaftar di asrama ini");
        } else if (mhs instanceof MahasiswaDomestik) {
            MahasiswaDomestik mhsDomestik = (MahasiswaDomestik) mhs;
            if (mhsDomestik.getGender() == Gender.WANITA) {
                System.out.println("Asrama Gedung Kidang Pananjung hanya untuk mahasiswa laki-laki");
            } else {
                this.penghuni.add(mhs);
                mhs.setAsrama(this);
                System.out.println("Mahasiswa " + mhs.getUsername() + " diterima di asrama Gedung Kidang Pananjung");
            }
        }
    }
}