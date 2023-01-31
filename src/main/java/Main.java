import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("latitude: " + ISSApi.latitude());
        System.out.println("longitude: " + ISSApi.longitude());
        System.out.println("timestamp: " + ISSApi.timestamp());
        System.out.println("message: " + ISSApi.message());
    }
}
