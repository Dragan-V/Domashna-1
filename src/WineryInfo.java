import com.google.maps.model.LatLng;

public class WineryInfo {
    String name;
    String address;
    LatLng location;

    public WineryInfo(String name, String address, LatLng location) {
        this.name = name;
        this.address = address;
        this.location = location;

    }
}