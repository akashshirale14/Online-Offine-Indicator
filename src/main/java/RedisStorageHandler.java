public class RedisStorageHandler implements StorageHandler {
    static StorageHandler redisHandler;

    public static StorageHandler getInstance(){
         if(redisHandler==null){
             redisHandler = new RedisStorageHandler();
         }
         return redisHandler;
    }

    @Override
    public void put(String userId) {

    }

    @Override
    public int get(String userId) {
        return 100;
    }
}
