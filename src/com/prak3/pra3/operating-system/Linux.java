public class Linux extends OperatingSystem {
    public enum Distro {
        UBUNTU,
        FEDORA,
        ARCH,
        DEBIAN
    }

    private Distro distroType;

    /**
     * Konstruktor untuk kelas Linux.
     * Menggunakan Distro.UBUNTU jika distroType null.
     */
    public Linux(String name, String version, String kernelType, double baseScore, Distro distroType) {
        super(name, version, kernelType, baseScore);
        this.distroType = (distroType == null) ? Distro.UBUNTU : distroType;
    }
    
    public Distro getDistroType() {
        return distroType;
    }
    
    @Override
    protected String getAdditionalInfo() {
        return "Distribution: " + this.distroType.name();
    }

    @Override
    public double calculateCompatibility(UsageType usage) {
        double multiplier = 0.0;
        switch (usage) {
            case SERVER:
                multiplier = 0.20; // +20%
                break;
            case DEVELOPMENT:
                multiplier = 0.10; // +10%
                break;
            case GAMING:
                multiplier = -0.15; // -15%
                break;
        }
        double finalScore = getBaseScore() + (getBaseScore() * multiplier);
        return clampScore(finalScore);
    }
}