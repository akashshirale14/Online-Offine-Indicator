import static spark.Spark.*;

public class RequestHandler {
    public static void main(String[] args) {
        get("/users/getUserId","application/json",(request, response) -> {
            String id = request.queryParams("userId");
            return "Hello " + id;
        });
    }


}
