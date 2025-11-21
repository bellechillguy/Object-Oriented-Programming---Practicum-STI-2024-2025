public class Staff extends Employee {
    private String department;
    // TODO: Buat atribut private String department

    public Staff(String name, int salary, String department) {
        super(name, salary, "Staff");
        this.department = department;
    }
    // TODO: Buat constructor yang menerima name, salary, department
    // Gunakan super constructor dengan position "Staff"

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Departemen : " + getDepartment());
    }
    // TODO: Override method displayInfo()
    // Panggil displayInfo() pada kelas Employee terlebih dahulu, lalu tampilkan:
    // "Departemen : <department>"

    @Override
    public void resign() {
        System.out.println(getName() + " (" + getPosition() + ") berhenti dari departemen " + getDepartment());
        super.resign();
    }
    // TODO: Override method resign()
    // Tampilkan pesan dengan format: "<name> (<position>) berhenti dari departemen <department>"
    // Lalu panggil resign() pada kelas Employee terlebih dahulu

    @Override
    public void work() {
        super.work();
        setSalary(getSalary() + calculateBonus());
    }
    // TODO: Override method work()
    // Panggil work() pada kelas Employee terlebih dahulu, lalu tambahkan salary dengan hasil calculateBonus()

    @Override
    public int calculateBonus() {
        return (int) (0.1 * getSalary());
    }
    // TODO: Override method calculateBonus()
    // Return 10% dari salary (gunakan casting int untuk hasil)

    public void requestLeave(int days) {
        System.out.println(getName() + " mengajukan cuti selama " + days + " hari");
    }
    // TODO: Buat method requestLeave(int days) yang menampilkan:
    // "<name> mengajukan cuti selama <days> hari"

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }    
    // TODO: Buat getter dan setter untuk department
}