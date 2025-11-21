public class Mage implements MagicalAttack, StrengthComparable {
    private String name;
    private int magicalPower;
    // TODO: Buat atribut private String name, int magicalPower
    
    public Mage(String name, int magicalPower) {
        this.name = name;
        this.magicalPower = magicalPower;
    }
    // TODO: Buat constructor yang menerima name dan magicalPower
    // Set kedua atribut dengan parameter yang diterima
    
    @Override
    public void performAttack() {
        // super(performAttack);
        System.out.println(name + " melancarkan sihir dahsyat! memberikan " + magicalPower + " damage sihir!");
    }
    // TODO: Override method performAttack()
    // Tampilkan: "<name> melancarkan sihir dahsyat! memberikan <magicalPower> damage sihir!"
    
    @Override
    public int getMagicalPower() {
        // super(magicalPower);
        return magicalPower;
    }
    // TODO: Override method getMagicalPower()
    // Buat getter untuk magicalPower
    
    @Override
    public void setMagicalPower(int power) {
        // super(magicalPower);
        this.magicalPower = power;
    }
    // TODO: Override method setMagicalPower(int power)
    // Buat setter untuk magicalPower
    
    // @Override
    public int compareStrength(StrengthComparable other) {
        // super(compareStrength);
        if(other instanceof Mage) {
            Mage otherMage = (Mage) other;
            if(this.getMagicalPower() < otherMage.getMagicalPower()) {
                return -1;
            }
            else if(this.getMagicalPower() == otherMage.getMagicalPower()) {
                return 0;
            }
            else {
                return 1;
            }
        }
        else {
            return -2;
        }
    }
    // TODO: Override method compareStrength(StrengthComparable other)
    // Jika other adalah instance dari Mage:
    //   - Bandingkan magicalPower:
    //     - Jika this.magicalPower < other.magicalPower, return -1
    //     - Jika this.magicalPower == other.magicalPower, return 0
    //     - Jika this.magicalPower > other.magicalPower, return 1
    // Jika other bukan instance dari Mage, return -2
    
}