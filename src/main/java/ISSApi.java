import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class ISSApi {

    // Metoda odpowiadająca za mapowanie Jsona do Java Class
    private static ISSData mappingToObject() throws IOException {
        // Stworzenie obiektu URL, który reprezentuje adres API
        URL url = new URL("http://api.open-notify.org/iss-now.json");

        // Utworzenie połączenia za pomocą HttpURLConnection
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        // Pobranie odpowiedzi od serwera i przetwarzanie JSON za pomocą biblioteki GSON
        InputStream inputStream = conn.getInputStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Gson gson = new Gson();
        return gson.fromJson(json, ISSData.class);
    }

    public static double latitude() throws IOException {
        return mappingToObject().getIss_position().getLatitude();
    }
    public static double longitude() throws IOException {
        return mappingToObject().getIss_position().getLongitude();
    }

    public static String timestamp() throws IOException {
        return mappingToObject().getTimestamp();
    }

    public static String message() throws IOException {
        return mappingToObject().getMessage();
    }
}
