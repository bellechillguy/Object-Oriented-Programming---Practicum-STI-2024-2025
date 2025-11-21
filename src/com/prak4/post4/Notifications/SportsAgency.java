public class SportsAgency extends AbstractAgency {
    public SportsAgency(String agencyName) {
        super(agencyName);
    }

    /**
     * FUNGSI publishSports
     *
     * Spesifikasi: Menyebarkan update olahraga dengan menggunakan fungsi publish
     * update
     */
    public void publishSports(String message, String category) {
        publishUpdate(message, category);
        // TODO: Panggil publishUpdate
    }
}
