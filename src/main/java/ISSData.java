import java.sql.Timestamp;

public class ISSData {
    private String timestamp;
    private String message;
    private ISSDataPosition iss_position;

    public String getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public ISSDataPosition getIss_position() {
        return iss_position;
    }

}


