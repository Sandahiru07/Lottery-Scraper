import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LotteryScraper {
    public static void main(String[] args) {
        try {
            //site which display lottery results
            Document doc = Jsoup.connect("https://www.lankayp.com/lottery/result/govisetha").get();

            //Select the div containing the lottery numbers
            Element lottoNumbersSection = doc.selectFirst("div.lotto_numbers");

            if (lottoNumbersSection != null) {
                System.out.println("Govisetha Lottery Result:");

                //Extract all the numbers inside divs with the class
                Elements numbers = lottoNumbersSection.select("div.lotto_no_r");

                //Display lottery results using System.out
                for (Element number : numbers) {
                    System.out.println("Number: " + number.text());
                }
            } else {
                System.out.println("Govisetha lottery result section not found.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
