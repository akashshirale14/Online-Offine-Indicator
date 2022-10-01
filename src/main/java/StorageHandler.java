public interface StorageHandler {

    void put(String userId);

    int get(String userId);

    static StorageHandler getInstance() {
        return null;
    }
}
