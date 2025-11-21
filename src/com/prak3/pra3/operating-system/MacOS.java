public class MacOS extends OperatingSystem {
    private boolean hasMSeriesChip;

    /**
     * Konstruktor untuk kelas MacOS.
     */
    public MacOS(String name, String version, String kernelType, double baseScore, boolean hasMSeriesChip) {
        super(name, version, kernelType, baseScore);
        this.hasMSeriesChip = hasMSeriesChip;
    }

    public boolean hasMSeriesChip() {
        return hasMSeriesChip;
    }

    @Override
    protected String getAdditionalInfo() {
        return "Has M-Series Chip: " + (this.hasMSeriesChip ? "Yes" : "No");
    }

    @Override
    public double calculateCompatibility(UsageType usage) {
        double multiplier = 0.0;
        switch (usage) {
            case DEVELOPMENT:
                multiplier += 0.25; // +25%
                break;
            case GAMING:
                multiplier += -0.20; // -20%
                break;
            default:
                break;
        }

        if (this.hasMSeriesChip) {
            multiplier += 0.10; // +10%
        }

        double finalScore = getBaseScore() + (getBaseScore() * multiplier);
        return clampScore(finalScore);
    }
}