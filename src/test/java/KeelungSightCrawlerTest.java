import com.example.entity.Sight;
import com.example.model.KeelungSightsCrawler;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
public class KeelungSightCrawlerTest {
    public static void main(String[] args) throws IOException {
        KeelungSightsCrawler crawler = new KeelungSightsCrawler();
        List<Sight> sights = crawler.getItems("七堵");
        for(Sight s : sights){
            System.out.println(s);
        }
    }
}
