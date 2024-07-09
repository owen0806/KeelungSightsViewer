import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class KeelungSightsCrawler {
    private final Document document;
    private final String[] regions = {"七堵", "中山", "中正", "仁愛", "安樂", "信義", "暖暖"};

    public KeelungSightsCrawler() throws IOException {
        String url = "https://www.travelking.com.tw/tourguide/taiwan/keelungcity/";
        document = Jsoup.connect(url).timeout(0).get();
    }

    public Sight getSight(String link) throws IOException {
        String url = "https://www.travelking.com.tw" + link;
        Document doc = Jsoup.connect(url).timeout(0).get();
        Sight sight = new Sight();

        String sightName = doc.selectXpath("//*[@id=\"point_area\"]/h1/span").text();
        sight.setSightName(sightName);

        String zone = doc.selectXpath("//*[@id=\"content\"]/div/ol/li[5]/a").text();
        sight.setZone(zone);

        String category = doc.selectXpath("//*[@id=\"point_area\"]/cite/span[1]/span[2]").text();
        sight.setCategory(category);

        String photoURL = doc.selectXpath("//*[@id=\"galleria\"]/div[1]/div[1]/div/div[1]/div/img").attr("data-src");
        sight.setPhotoURL(photoURL);

        Elements textDiv = doc.selectXpath("//*[@id=\"point_area\"]/div[4]");
        textDiv.select("div").remove();
        String description = textDiv.text();
        sight.setDescription(description);

        String address = doc.selectXpath("//*[@id=\"point_data\"]/div[1]/p/a/span").text();
        sight.setAddress(address);

        return sight;
    }

    public Sight[] getItems(String region) throws IOException {
        ArrayList<Sight> sights = new ArrayList<>();
        for (int i = 0; i < regions.length; i++) {
            if (region.equals(regions[i])) {
                String xpath = String.format("//*[@id=\"guide-point\"]/div/ul[%d]", i+2);
                Elements elements = document.selectXpath(xpath);

                Elements links = elements.select("a");
                for(Element link : links) {
                    sights.add(getSight(link.attr("href")));
                }
                break;
            }
        }
        return sights.toArray(new Sight[0]);
    }
}