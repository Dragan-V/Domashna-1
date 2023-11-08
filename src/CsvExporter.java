import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvExporter {
    public static void saveDataToCsvFile(List<WineryInfo> wineryData, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.append("Name;Address;Rating;Location\n");
            for (WineryInfo info : wineryData) {
                fileWriter.write(info.name + ";");
                fileWriter.write(info.address + ";");
                fileWriter.write(info.rating + ";");
                fileWriter.write(info.location + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
