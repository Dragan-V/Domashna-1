import com.google.maps.model.LatLng;

public class WineryInfo {
    String name;
    String address;
    LatLng location;
    float rating;

    public WineryInfo(String name, String address, LatLng location, float rating) {
        this.name = name;
        this.address = address;
        this.location = location;
        this.rating = rating;

    }
}