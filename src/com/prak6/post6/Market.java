import java.util.List;
import java.util.ArrayList;

public class Market {
  private String name;
  private List<Cart> carts;

  /**
   * Constructor
   * * Initializes a market with a name and an empty list of carts.
   * * @param name
   */
  public Market(String name) {
    this.name = name;
    this.carts = new ArrayList<>();
  }

  /**
   * Gets the name of the market.
   * * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets the list of carts associated with the market.
   * * @return carts
   */
  public List<Cart> getCarts() {
    return this.carts;
  }

  /**
   * Adds a cart to the market.
   * * Instantiate a new Cart and add it to the carts list.
   */
  public void addCart() {
    this.carts.add(new Cart());
  }

  /**
   * Adds a specific cart to the market.
   * * @param cart
   */
  public void addCart(Cart cart) {
    this.carts.add(cart);
  }

  /**
   * Adds a cart with a specific item to the market.
   * Total amount for cart [cartId]: Rp 
   * Hint: Instantiate a new Cart and a new Item, add an Item to it, then add the
   * Cart to the carts list.
   * 
   * @param itemName
   * @param itemPrice
   */
  public void addCartWithItem(String itemName, double itemPrice) {
    Cart newCart = new Cart();
    newCart.addItem(itemName, itemPrice);
    this.carts.add(newCart);


  }

  /**
   * Removes a cart from the market.
   * * @param cart
   */
  public void removeCart(Cart cart) {
    this.carts.remove(cart);
  }

  /**
   * Clears all carts from the market.
   * * Hint: gunakan clear
   */
  public void clearCarts() {
    this.carts.clear();
  }

  /**
   * Checks out all carts in the market and prints the total amount for each cart.
   * * Hint:
   * - gunakan method checkout pada Cart
   * - gunakan printf untuk format output
   * - Format: "Total amount for cart %d: Rp %.0f%n"
   * "Grand total for all carts: Rp %.0f%n"
   * * * Output:
   * Checking out all carts in market: [market name]
   * Total amount for cart [cartId]: Rp [total amount]
   * ...
   * Total amount for cart [cartId]: Rp [total amount]
   * Grand total for all carts: Rp [grand total amount]
   */
  public void checkoutAllCarts() {
    System.out.println("Checking out all carts in market: " + this.name);
    double grandTotal = 0;
    for (Cart cart : this.carts) {
      double cartTotal = cart.checkout();
      grandTotal += cartTotal;
      System.out.printf("Total amount for cart %d: Rp %.0f%n", cart.getCartId(), cartTotal);
    }
    System.out.printf("Grand total for all carts: Rp %.0f%n", grandTotal);
  }

  /**
   * Nested Static Class: Cart
   * * Represents a shopping cart that can hold multiple items.
   */
  public static class Cart {
    public static int cartCounter = 0;
    private int cartId;
    private List<Item> items;

    /**
     * Constructor
     * * Initializes an empty shopping cart.
     * Creates a new cart with a unique ID (Incremental).
     */
    public Cart() {
      this.cartId = ++cartCounter;
      this.items = new ArrayList<>();
    }

    /**
     * Adds an item to the cart.
     * * @param item
     */
    public void addItem(Item item) {
      this.items.add(item);
    }

    /**
     * Adds an item to the cart by specifying its name and price.
     * * @param name
     * @param price
     */
    public void addItem(String name, double price) {
      Item newItem = new Item(name, price);
      this.items.add(newItem);
    }

    /**
     * Removes an item from the cart.
     * * @param item
     */
    public void removeItem(Item item) {
      this.items.remove(item);
    }

    /**
     * Removes an item from the cart by its unique ID.
     * * Hint: gunakan removeIf
     * * @param id
     */
    public void removeItemById(int id) {
      this.items.removeIf(item -> item.getId() == id);
    }

    /**
     * Clears all items from the cart.
     * * Hint: gunakan clearitems
     */
    public void clearCart() {
      this.items.clear();
    }

    /**
     * Calculates the total price of all items in the cart.
     * * @return total price
     */
    public double checkout() {
      double total = 0;
      for (Item item : this.items) {
        total += item.getPrice();
      }
      return total;
    }

    /**
     * Gets the unique ID of the cart.
     * * @return cartId
     */
    public int getCartId() {
      return this.cartId;
    }

    /**
     * Nested Static Class: Item
     * * Represents an item that can be added to a cart.
     */
    public static class Item {
      private static int idCounter = 0;
      private int id;
      private String name;
      private double price;

      /**
       * Constructor
       * * Creates a new item with a unique ID (Incremental), name, and price.
       * * @param name
       * @param price
       */
      public Item(String name, double price) {
        this.id = ++idCounter;
        this.name = name;
        this.price = price;
      }

      /**
       * Gets the unique ID of the item.
       * * @return id
       */
      public int getId() {
        return this.id;
      }

      /**
       * Gets the name of the item.
       * * @return name
       */
      public String getName() {
        return this.name;
      }

      /**
       * Gets the price of the item.
       * * @return price
       */
      public double getPrice() {
        return this.price;
      }
    }
  }
}
