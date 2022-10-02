import static spark.Spark.get;
import static spark.Spark.post;

//Used Spark API below to create a HTTP server with REST API
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
            boolean ans= storageHandler.get(id);
            if(ans){
                return "UserId +"+ id +" is Online !! ";
            }
            return "UserId +"+ id +" is Offline." + ans;
        });

        post("/updateStatus/userId","application/x-www-form-urlencoded",((request, response) -> {
            String userid = request.body().split(":")[1];
            storageHandler.put(userid);
            return "Update successful "+ request.body().split(":")[1];
        }));
    }

}
