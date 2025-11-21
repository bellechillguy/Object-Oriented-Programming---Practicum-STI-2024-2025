import java.util.ArrayList;
import java.util.List;

/**
 * Merepresentasikan pengguna yang dapat berlangganan pada berbagai agensi dan
 * menerima pesan sesuai preferensi.
 */

public class UserSubscriber implements Subscriber {
    private static int userCount;
    private String name;

    private final List<SubscriptionPreference> preferences = new ArrayList<>();

    /**
     * FUNGSI UserSubscriber
     *
     * Spesifikasi: Menyimpan nama pengguna, menambah jumlah pengguna
     */
    public UserSubscriber(String name) {
        this.name = name;
        userCount++;
    }

    /**
     * FUNGSI getUserCount
     *
     * Spesifikasi: Mengembalikan jumlah pengguna yang pernah dibuat.
     */
    public static int getUserCount() {
        return userCount;
    }

    /**
     * FUNGSI getName
     *
     * Spesifikasi: Mengembalikan nama pengguna yang terdaftar.
     */
    public String getName() {
        return name;
    }

    /**
     * FUNGSI addCategoryPreference
     *
     * Spesifikasi: Menambahkan atau memperbarui preferensi kategori pada agensi
     * tertentu.
     */
    public void addCategoryPreference(String agencyName, String category, DeliveryMethod method) {
        AbstractAgency agency = AbstractAgency.findByName(agencyName);
        if (agency == null) {
            System.out.printf(
                    "Pengguna %s tidak menemukan agensi bernama %s.%n",
                    this.name,
                    agencyName);
            return;
        }

        if (!agency.getSubscribers().contains(this)) {
            System.out.printf(
                    "Pengguna %s belum terdaftar sebagai pelanggan agensi %s, kategori '%s' tidak ditambahkan.%n",
                    this.name,
                    agencyName,
                    category);
            return;
        }

        SubscriptionPreference s = findOrCreatePreference(agencyName);
        s.setDeliveryMethod(method);

        if (s.addCategory(category)) {
            System.out.printf("Pengguna %s menambahkan kategori '%s' untuk agensi %s dengan metode %s.%n", 
            getName(), category, agencyName, s.getDeliveryMethod());
        } 
    }

    /**
     * FUNGSI removeCategoryPreference
     *
     * Spesifikasi: Menghapus kategori tertentu dari preferensi pengguna pada
     * agensi.
     */
    public void removeCategoryPreference(String agencyName, String category) {
        SubscriptionPreference s = findPreference(agencyName);
        
        if(s == null) {
            System.out.printf("Pengguna %s belum memiliki preferensi untuk agensi %s, kategori '%s' diabaikan.%n", getName(), agencyName, category);
            return;
        }

        if(!s.acceptsCategory(category)) {
            System.out.printf("Pengguna %s tidak menemukan kategori '%s' pada agensi %s.%n", getName(), category, agencyName);
            return;
        }

        if(s.removeCategory(category)) {
            System.out.printf("Pengguna %s menghapus kategori '%s' dari agensi %s.%n", getName(), category, agencyName);
        }
        else {
            System.out.printf("Pengguna %s tidak dapat menghapus kategori '%s' dari agensi %s.%n", getName(), category, agencyName);
        }
    }

    /**
     * FUNGSI setDeliveryMethod
     *
     * Spesifikasi: Mengubah metode pengiriman untuk suatu agensi bila berbeda dari
     * sebelumnya.
     */
    public void setDeliveryMethod(String agencyName, DeliveryMethod method) {
        SubscriptionPreference s = findPreference(agencyName);

        if(s == null) {
            System.out.printf("Preferensi untuk agensi %s tidak ditemukan sehingga perubahan metode tidak bisa dilakukan.%n", agencyName);
            return;
        }

        if(s.getDeliveryMethod() == method ) {
            System.out.printf("Pengguna %s tetap menggunakan metode %s untuk agensi %s.%n", getName(), method, agencyName);
            return;
        }

        System.out.printf("Pengguna %s mengubah metode agensi %s dari %s menjadi %s.%n", getName(), agencyName, s.getDeliveryMethod(), method);
        s.setDeliveryMethod(method);
    }

    /**
     * FUNGSI receive
     *
     * Spesifikasi: User menerima pesan dari agensi
     */
    @Override
    public void receive(String agencyName, String message, String category) {
        SubscriptionPreference s = findPreference(agencyName);

        if(s != null && s.acceptsCategory(category)) {
            System.out.printf("[%s] dari %s melalui %s - %s: %s%n", getName(), s.getAgencyName(), s.getDeliveryMethod(), category, message);
        }
    }

    /**
     * FUNGSI findOrCreatePreference
     *
     * Spesifikasi: Mengembalikan preferensi yang cocok dengan agensi atau membuat
     * baru dengan metode delivery default yaitu APP.
     */
    private SubscriptionPreference findOrCreatePreference(String agencyName) {
        SubscriptionPreference preference = findPreference(agencyName);
        if (preference == null) {
            preference = new SubscriptionPreference(this, agencyName, DeliveryMethod.APP);
            preferences.add(preference);
        }
        return preference;
    }

    /**
     * FUNGSI findPreference
     *
     * Spesifikasi: Mengembalikan preferensi berdasarkan nama agensi atau null jika
     * belum ada.
     */
    private SubscriptionPreference findPreference(String agencyName) {
        for (SubscriptionPreference preference : preferences) {
            if (preference.getAgencyName().equals(agencyName)) {
                return preference;
            }
        }
        return null;
    }
}