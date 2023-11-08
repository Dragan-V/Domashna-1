import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvExporter {
    public static void saveDataToCsvFile(List<WineryInfo> wineryData, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.append("Name, Address, Rating, Location\n");
            for (WineryInfo info : wineryData) {
                fileWriter.append("\"").append(info.name).append("\",");
                fileWriter.append("\"").append(info.address).append("\",");
                fileWriter.append("\"").append(String.valueOf(info.rating)).append("\",");
                fileWriter.append("\"").append(info.location.toString()).append("\"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
