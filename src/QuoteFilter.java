import java.util.List;

public class QuoteFilter {
    public static void quoteFilter(List<WineryInfo> wineryData) {

            for (WineryInfo info : wineryData) {
                if(info.address.contains("\"")){
                    info.address = info.address.replace("\"", "“");
                }
            }
        }
    }
