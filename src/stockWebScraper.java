
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class stockWebScraper {
    public static void main(String[] args) {
        String url = "https://web.archive.org/web/20190104110157/http://shares.telegraph.co.uk/indices/?index=MCX";

        try {
            Document doc = Jsoup.connect(url).get();

                for(Element row : doc.select("table.tablesorter.full tr")){
                    if(row.select("td:nth-of-type(1)").text().equals("")){
                        continue;
                    } else {
                        String ticker = row.select("td:nth-of-type(1)").text();

                        String name = row.select("td:nth-of-type(2)").text();

                        String tempPrice = row.select("td.right:nth-of-type(3)").text();
                        String tempPriceNoCommas = tempPrice.replace(",", "");
                        double price = Double.parseDouble(tempPriceNoCommas);
                        System.out.println(ticker + " " + name + " " + price);
                    }
                }
        } catch(Exception e) {

        }
    }
}
