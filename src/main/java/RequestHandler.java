import static spark.Spark.get;
import static spark.Spark.post;

public class RequestHandler {
    static StorageHandler storageHandler = getStorageHandler();
    public static void main(String[] args) {
        startHttpServer();
    }

    public static StorageHandler getStorageHandler(){
        StorageHandler storageHandler = RedisStorageHandler.getInstance();
        return storageHandler;
    }

    public static void startHttpServer(){
        get("/users/getUserId","application/json",(request, response) -> {
            String id = request.queryParams("userId");
            int ans= storageHandler.get(id);
            return "Hello " + ans;
        });

        post("/updateStatus/userId","application/x-www-form-urlencoded",((request, response) -> {
            System.out.println("userid: " +request.body().split(":")[1]);
            return "Update successful "+ request.body().split(":")[1];
        }));
    }

}
