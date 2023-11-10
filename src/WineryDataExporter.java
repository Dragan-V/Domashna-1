import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.TextSearchRequest;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;
import com.google.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;
import io.github.cdimascio.dotenv.Dotenv;


public class WineryDataExporter {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().load();
        String apiKey = dotenv.get("GOOGLE_MAPS_API_KEY");
        GeoApiContext context = new GeoApiContext.Builder().apiKey(apiKey).build();

        LatLng[] locations = {
                new LatLng(41.25303, 21.27507),
                new LatLng(41.52297, 22.35999),
                new LatLng(41.93242, 21.69960),
                new LatLng(42.14813, 22.27066),
                new LatLng(41.83265, 20.95572),
                new LatLng(41.45005,22.22156),
                new LatLng(41.75242,22.55919),
                new LatLng(42.11101,22.18597),
                new LatLng(41.81062,21.90612),
                new LatLng( 41.53209,21.58333),
                new LatLng( 41.07832,20.96742),
                new LatLng( 41.69503,20.89885),
                new LatLng( 42.05295,21.33640),
                new LatLng(41.09672,21.60100)
        };
        int radius = 50000;

        List<WineryInfo> allWineryData = new ArrayList<>();

        for (int i = 0; i < locations.length; i++) {
            try {
                TextSearchRequest request = PlacesApi.textSearchQuery(context, "wineries")
                        .location(locations[i])
                        .radius(radius);
                PlacesSearchResponse response = request.await();
                for (PlacesSearchResult result : response.results) {
                  //  System.out.println(result.rating);
                    allWineryData.add(new WineryInfo(result.name, result.formattedAddress, result.geometry.location,result.rating,result.userRatingsTotal));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        CsvExporter.saveDataToCsvFile(allWineryData, "all_winery_data.csv");
        System.out.println("all_winery_data.csv e kreirano");
        DuplicateFilter.duplicateFilter("all_winery_data.csv", "unique_winery_data.csv");

    }
}
