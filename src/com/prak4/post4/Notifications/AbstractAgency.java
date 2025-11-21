import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractAgency implements Publisher {
    private static int agencyCount;
    private String agencyName;

    private static final List<AbstractAgency> REGISTRY = new ArrayList<>();
    private final List<Subscriber> subscribers = new ArrayList<>();
    private final List<List<String>> subscriberCategories = new ArrayList<>();

    protected AbstractAgency(String agencyName) {
        this.agencyName = agencyName;
        agencyCount++;
        REGISTRY.add(this);
    }

    /**
     * FUNGSI getAgencyCount
     *
     * Spesifikasi: Mengembalikan jumlah objek agensi yang sudah dibuat selama
     * aplikasi berjalan.
     */
    public static int getAgencyCount() {
        return agencyCount;
    }

    /**
     * FUNGSI findByName
     *
     * Spesifikasi: Mengembalikan objek agensi yang namanya sama dengan
     * parameter, atau null bila tidak ditemukan.
     */
    public static AbstractAgency findByName(String name) {
        for (AbstractAgency agency : REGISTRY) {
            if (agency.getAgencyName().equals(name)) {
                return agency;
            }
        }
        return null;
    }

    /**
     * FUNGSI getAgencyName
     *
     * Spesifikasi: Mengembalikan nama agensi
     */
    public String getAgencyName() {
        return agencyName;
    }

    /**
     * FUNGSI getSubscribers
     *
     * Spesifikasi: Mengembalikan daftar seluruh pelanggan yang terdaftar.
     */
    public List<Subscriber> getSubscribers() {
        return Collections.unmodifiableList(subscribers);
    }

    @Override
    public void addSubscriber(Subscriber s) {
        if(subscribers.contains(s)) {
            System.out.println("Agensi " + getAgencyName() + " melewatkan penambahan pelanggan karena sudah terdaftar.");
        }
        else {
            subscribers.add(s);
            subscriberCategories.add(new ArrayList<>());
            System.out.println("Agensi " + getAgencyName() + " menambahkan pelanggan baru.");
        }
    }

    @Override
    public void removeSubscriber(Subscriber s) {
        if(subscribers.contains(s)) {
            int index = subscribers.indexOf(s);
            subscribers.remove(index);
            subscriberCategories.remove(index);
            System.out.println("Agensi " + getAgencyName() + " menghapus pelanggan.");
        }
        else {
            System.out.println("Agensi " + getAgencyName() + " tidak menemukan pelanggan untuk dihapus.");
        }
    }

    @Override
    public void broadcast(String message, String category) {
        for (int i = 0; i < subscribers.size(); i++) {
            Subscriber subscriber = subscribers.get(i);
            List<String> categories = subscriberCategories.get(i);
            
            if (categories.contains(category)) {
                subscriber.receive(getAgencyName(), message, category);
            }
        }
    }

    public void publishUpdate(String message, String category) {
        System.out.println("Agensi " + getAgencyName() + " menyiarkan pembaruan kategori '" + category + "': " + message);
        broadcast(message, category);
    }

    public boolean assignCategoryToSubscriber(Subscriber subscriber, String category) {
        if (subscriber == null || category == null || category.isEmpty()) {
            return false;
        }

        int index = subscribers.indexOf(subscriber);
        if (index < 0) {
            return false;
        }

        List<String> categories = subscriberCategories.get(index);
        if (categories.contains(category)) {
            return false;
        }
        categories.add(category);
        return true;
    }

    public boolean removeCategoryFromSubscriber(Subscriber subscriber, String category) {
        if (subscriber == null || category == null) {
            return false;
        }
        int index = subscribers.indexOf(subscriber);
        if (index < 0) {
            return false;
        }
        List<String> categories = subscriberCategories.get(index);
        return categories.remove(category);
    }

    public boolean hasCategoryForSubscriber(Subscriber subscriber, String category) {
        if (subscriber == null || category == null) {
            return false;
        }
        int index = subscribers.indexOf(subscriber);
        if (index < 0) {
            return false;
        }
        List<String> categories = subscriberCategories.get(index);
        return categories.contains(category);
    }

    public boolean hasCategoriesForSubscriber(Subscriber subscriber) {
        int index = subscribers.indexOf(subscriber);
        if (index < 0) {
            return false;
        }
        List<String> categories = subscriberCategories.get(index);
        return !categories.isEmpty();
    }
}