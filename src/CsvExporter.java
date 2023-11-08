import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvExporter {
    public static void saveDataToCsvFile(List<WineryInfo> wineryData, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.append("Name,Address,Rating,Location\n");
            for (WineryInfo info : wineryData) {
                String address = info.address.replace(",", "-");
                fileWriter.append(info.name).append(",");
                fileWriter.append(address).append(",");
                fileWriter.append(String.valueOf(info.rating)).append(",");
                fileWriter.append(info.location.toString()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}