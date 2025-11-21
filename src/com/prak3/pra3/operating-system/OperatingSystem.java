public abstract class OperatingSystem {
    private String name;
    private String version;
    private String kernelType;
    private double baseScore;

    /**
     * Konstruktor untuk kelas abstrak OperatingSystem.
     * Menginisialisasi atribut dengan nilai default jika parameter null atau kosong.
     */
    public OperatingSystem(String name, String version, String kernelType, double baseScore) {
        this.name = (name == null || name.trim().isEmpty()) ? "Unknown OS" : name;
        this.version = (version == null || version.trim().isEmpty()) ? "Unknown Version" : version;
        this.kernelType = (kernelType == null || kernelType.trim().isEmpty()) ? "Unknown Kernel" : kernelType;
        this.baseScore = baseScore;
    }

    // Getters untuk semua atribut
    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getKernelType() {
        return kernelType;
    }

    public double getBaseScore() {
        return baseScore;
    }

    /**
     * Method abstrak untuk menghitung skor kompatibilitas.
     * Harus diimplementasikan oleh semua kelas turunan.
     */
    public abstract double calculateCompatibility(UsageType usage);

    /**
     * Method bantu untuk memastikan skor tetap dalam rentang 0-100.
     */
    protected double clampScore(double score) {
        return Math.max(0, Math.min(100, score));
    }
    
    /**
     * Method bantu yang bisa di-override oleh kelas turunan 
     * untuk memberikan informasi tambahan.
     */
    protected String getAdditionalInfo() {
        return "";
    }

    /**
     * Mencetak informasi lengkap mengenai sistem operasi dan skor kompatibilitasnya.
     */
    public void printInfo(UsageType usage) {
        System.out.printf("Name: %s%n", this.name);
        System.out.printf("Version: %s%n", this.version);
        System.out.printf("Kernel Type: %s%n", this.kernelType);

        String additionalInfo = getAdditionalInfo();
        if (additionalInfo != null && !additionalInfo.isEmpty()) {
            System.out.printf("%s%n", additionalInfo);
        }

        System.out.printf("Base Score: %.2f%n", this.baseScore);
        System.out.printf("Compatibility for %s: %.2f%n", usage.name(), calculateCompatibility(usage));
    }
}