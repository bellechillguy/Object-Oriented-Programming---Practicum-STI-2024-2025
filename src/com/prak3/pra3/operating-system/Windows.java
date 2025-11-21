public class Windows extends OperatingSystem {
    public enum Edition {
        HOME,
        PRO,
        SERVER
    }

    private Edition edition;

    /**
     * Konstruktor untuk kelas Windows.
     * Menggunakan Edition.HOME jika edition null.
     */
    public Windows(String name, String version, String kernelType, double baseScore, Edition edition) {
        super(name, version, kernelType, baseScore);
        this.edition = (edition == null) ? Edition.HOME : edition;
    }

    public Edition getEdition() {
        return edition;
    }
    
    @Override
    protected String getAdditionalInfo() {
        return "Edition: " + this.edition.name();
    }
    
    @Override
    public double calculateCompatibility(UsageType usage) {
        double multiplier = 0.0;
        if (this.edition == Edition.SERVER && usage == UsageType.SERVER) {
            multiplier = 0.30; // +30%
        } else if (usage == UsageType.GAMING) {
            multiplier = 0.20; // +20%
        } else if (this.edition == Edition.HOME && usage == UsageType.SERVER) {
            multiplier = -0.05; // -5%
        }
        
        double finalScore = getBaseScore() + (getBaseScore() * multiplier);
        return clampScore(finalScore);
    }
}
