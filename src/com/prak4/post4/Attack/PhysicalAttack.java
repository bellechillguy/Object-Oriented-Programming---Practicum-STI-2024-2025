public interface PhysicalAttack extends Attack {
    public int getPhysicalPower();

    public void setPhysicalPower(int power);
    
    public default void refineBlade() {
        setPhysicalPower(getPhysicalPower() + 10);
    }
    // TODO: Buat default method refineBlade()
    // Tambahkan 10 ke physicalPower dengan memanggil getPhysicalPower() dan setPhysicalPower()
    
    public default void showPhysicalStats() {
        System.out.println("Kekuatan Fisik: " + getPhysicalPower());
    }
    // TODO: Buat default method showPhysicalStats()
    // Tampilkan: "Kekuatan Fisik: <physicalPower>"
}