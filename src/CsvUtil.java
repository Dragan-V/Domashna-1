import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CsvUtil {

    public static void copyUniqueEntries(String inputCsvFileName, String outputCsvFileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputCsvFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputCsvFileName))) {

            String line;
            Set<String> uniqueEntries = new HashSet<>();

            while ((line = reader.readLine()) != null) {
                if (uniqueEntries.add(line)) {
                    writer.write(line);
                    writer.newLine();
                }
            }

            System.out.println("Unique entries copied to " + outputCsvFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
