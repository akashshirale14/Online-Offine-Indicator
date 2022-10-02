//Add this interface for ease of extensibility in future using some other DB like Memcache
public interface StorageHandler {

    void put(String userId);

    boolean get(String userId);

    static StorageHandler getInstance() {
        return null;
    }
}
