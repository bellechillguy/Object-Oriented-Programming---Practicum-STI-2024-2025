public class Warrior implements PhysicalAttack, StrengthComparable {
    private String name;
    private int physicalPower;
    // TODO: Buat atribut private String name, int physicalPower
    
    public Warrior(String name, int physicalPower) {
        this.name = name;
        this.physicalPower = physicalPower;
    }
    // TODO: Buat constructor yang menerima name dan physicalPower
    // Set kedua atribut dengan parameter yang diterima
    
    @Override
    public void performAttack() {
        System.out.println(name + " mengayunkan pedang dengan kuat! memberikan " + physicalPower + " damage fisik!");
    }
    // TODO: Override method performAttack()
    // Tampilkan: "<name> mengayunkan pedang dengan kuat! memberikan <physicalPower> damage fisik!"
    
    @Override
    public int getPhysicalPower() {
        return physicalPower;
    }
    // TODO: Override method getPhysicalPower()
    // Buat getter untuk physicalPower
    
    @Override
    public void setPhysicalPower(int power) {
        this.physicalPower = power;
    }
    // TODO: Override method setPhysicalPower(int power)
    // Buat setter untuk physicalPower
    
    @Override
    public int compareStrength(StrengthComparable other) {
        if(other instanceof Warrior) {
            Warrior otherWarrior = (Warrior) other;
            if(this.getPhysicalPower() < otherWarrior.getPhysicalPower()) {
                return -1;
            }
            else if(this.getPhysicalPower() == otherWarrior.getPhysicalPower()) {
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
    // Jika other adalah instance dari Warrior:
    //   - Bandingkan physicalPower:
    //     - Jika this.physicalPower < other.physicalPower, return -1
    //     - Jika this.physicalPower == other.physicalPower, return 0
    //     - Jika this.physicalPower > other.physicalPower, return 1
    // Jika other bukan instance dari Warrior, return -2
    
}