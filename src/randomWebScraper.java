
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class randomWebScraper {
    public static void main(String[] args) {
        String url = "https://www.target.com/c/pc-gaming-computers-video-games/-/N-3jut8";
        crawl(1,url, new ArrayList<String>());
    }

    static void crawl(int level, String url, ArrayList<String> visisted) {
        if(level <= 5){
            Document doc = request(url, visisted);
                if(doc != null){
                    for(Element link : doc.select("a[href]")){
                        String next_link = link.absUrl("href");
                            if(visisted.contains(next_link) == false){
                                crawl(level++, next_link, visisted);
                            }
                    }
                }

        }
    }

    static Document request(String url, ArrayList<String> v){
        try {
            Connection con = Jsoup.connect(url);
            Document doc = con.get();

            if(con.response().statusCode() == 200){
                System.out.println("Link: " + url);
                System.out.println(doc.title());
                v.add(url);

                return doc;
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }
}
