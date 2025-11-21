public class Customer {
  private String name;
  private double balance;
  private int orderCount;
  private static final int MAX_ORDERS_PER_CUSTOMER = 10;

  public Customer(String name, double balance) throws InvalidQuantityException {
    if (balance < 0) {
      throw new InvalidQuantityException("Saldo tidak boleh negatif.");
    }
    this.name = name;
    this.balance = balance;
    this.orderCount = 0;
  }

  public String getName() {
    return name;
  }

  public double getBalance() {
    return balance;
  }

  public int getOrderCount() {
    return orderCount;
  }

  public void incrementOrderCount() throws OrderLimitExceededException {
    if (orderCount >= MAX_ORDERS_PER_CUSTOMER) {
      throw new OrderLimitExceededException("Customer '" + name + "' telah mencapai batas maksimum order (" + MAX_ORDERS_PER_CUSTOMER + ").");
    }
    orderCount++;
  }

  public void addBalance(double amount) throws InvalidQuantityException {
    if (amount < 0) {
      throw new InvalidQuantityException("Jumlah top-up tidak boleh negatif.");
    }
    balance += amount;
  }

  public void deductBalance(double amount) throws InvalidQuantityException, InsufficientBalanceException {
    if (amount < 0) {
      throw new InvalidQuantityException("Jumlah pengurangan tidak boleh negatif.");
    }
    if (balance < amount) {
      throw new InsufficientBalanceException("Saldo tidak mencukupi. Saldo: Rp" + balance + ", Dibutuhkan: Rp" + amount);
    }
    balance -= amount;
  }

  @Override
  public String toString() {
    return name + " - Saldo: Rp" + balance + ", Orders: " + orderCount;
  }
}
