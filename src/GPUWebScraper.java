
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class GPUWebScraper {
    public static void main(String[] args) {
    final String url = "https://www.newegg.com/p/pl?N=100007709%20601194948%20601202919%20601203901%20601203927%20601205646%20601294835%20601295933%20601296377%20601301599%20601305993%20601321572%20601323902%20601326374%20601331379%20601341679%20601357282%20601359511&cm_sp=Cat_video-Cards_1-_-Visnav-_-Gaming-Video-Cards_1";

    try {
        Document document = Jsoup.connect(url).get();

        for (Element collumn : document.select("div.list-wrap div")) {
            if (collumn.select(".item-title").text().equals("")) {
                continue;
            } else {
                String description = collumn.select(".item-title").text();
                System.out.println(description);
                System.out.println();
            }
        }

    } catch (Exception e){
        e.printStackTrace();
        }    
    }

}
