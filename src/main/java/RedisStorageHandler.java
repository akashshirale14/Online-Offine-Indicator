import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

public class RedisStorageHandler implements StorageHandler {
    static StorageHandler redisHandler;
    JedisPool jedisPool;
    static public long TIMEOUT = 25;
    public RedisStorageHandler(){
        //initializing Jedis to connect to Redis-server (Redis-server already running
        String redisUrl= "redis://localhost:6379/";
        jedisPool = new JedisPool(redisUrl);
    }


    public static StorageHandler getInstance(){
         if(redisHandler==null){
             redisHandler = new RedisStorageHandler();
         }
         return redisHandler;
    }

    //This puts the key with expiry time in the redis DB
    @Override
    public void put(String userId) {
       String ans= jedisPool.getResource().set(userId,"Alive",getTimoutTime());
       System.out.println("put " +ans);
    }

    public SetParams getTimoutTime(){
        return SetParams.setParams().ex(TIMEOUT);
    }

    //This gets the value stored in DB if its not yet expired
    @Override
    public boolean get(String userId) {
        String value = jedisPool.getResource().get(userId);
        if(value == null){
            return false;
        }
        return true;
    }
}
