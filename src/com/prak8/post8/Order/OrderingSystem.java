import java.util.ArrayList;
import java.util.List;

public class OrderingSystem {
  private List<Item> items;
  private List<Customer> customers;

  public OrderingSystem() {
    items = new ArrayList<>();
    customers = new ArrayList<>();
  }

  public void addItem(Item item) throws DuplicateItemException {
    if (item == null) {
      throw new NullPointerException("Item tidak boleh null.");
    }
    String newName = item.getName();
    for (Item existingItem : items) {
      String existingName = existingItem.getName();
      if (existingName != null && newName != null && existingName.equalsIgnoreCase(newName)) {
        throw new DuplicateItemException("Item dengan nama '" + item.getName() + "' sudah ada.");
      }
    }
    items.add(item);
  }

  public void addCustomer(Customer customer) {
    if (customer == null) {
      throw new NullPointerException("Customer tidak boleh null.");
    }
    customers.add(customer);
  }

  public Item findItem(String name) throws ItemNotFoundException {
    for (Item item : items) {
      String iname = item.getName();
      if (iname != null && name != null && iname.equalsIgnoreCase(name)) {
        return item;
      }
    }
    throw new ItemNotFoundException("Item '" + name + "' tidak ditemukan.");
  }

  public Customer findCustomer(String name) throws CustomerNotFoundException {
    for (Customer customer : customers) {
      String cname = customer.getName();
      if (cname != null && name != null && cname.equalsIgnoreCase(name)) {
        return customer;
      }
    }
    throw new CustomerNotFoundException("Customer '" + name + "' tidak ditemukan.");
  }

  public void processOrder(String customerName, String itemName, int quantity)
      throws ItemNotFoundException, OutOfStockException, InvalidQuantityException,
             InsufficientBalanceException, CustomerNotFoundException, OrderLimitExceededException {

    Customer customer = findCustomer(customerName);
    customer.incrementOrderCount();
    Item item = findItem(itemName);
    double totalPrice = item.getFinalPrice() * quantity;
    customer.deductBalance(totalPrice);

    try {
      item.reduceStock(quantity);
      System.out.println("Pesanan berhasil! " + customerName + " membeli " + quantity + " " + itemName + " seharga Rp" + totalPrice);
    } catch (InvalidQuantityException | OutOfStockException e) {
      try {
        customer.addBalance(totalPrice);
      } catch (InvalidQuantityException ignored) {
      }
      throw e;
    }
  }

  public void displayItems() {
    System.out.println("Daftar Item:");
    if (items.isEmpty()) {
      System.out.println("(tidak ada item)");
      return;
    }
    for (Item item : items) {
      System.out.println("- " + item);
    }
  }

  public void displayCustomers() {
    System.out.println("Daftar Customer:");
    if (customers.isEmpty()) {
      System.out.println("(tidak ada customer)");
      return;
    }
    for (Customer customer : customers) {
      System.out.println("- " + customer);
    }
  }
}
