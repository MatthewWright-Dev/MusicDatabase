import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * WebScrubber.java utilizes the jsoup library to scrape and parse HTML
 * from a URL.
 *
 */

public class WebScrubber {

    private String url;

    public WebScrubber(String site) {
        url = site;
    }

    public void getPage()   {

        try {
            String html = Jsoup.connect(url).get().html();
            //System.out.println(html);
            Document doc = Jsoup.parse(html);
            Element body = doc.body();

            System.out.println(body);
//            Set<String> names = body.className();
//            for (String i : names)  {
//                System.out.println(i);
//            }

            //System.out.println(body);
//            String middle = body.text();
//            middle = middle.replaceAll("Editors' Choice", "\n");
//            System.out.println(middle);

        } catch (IOException e) {
            System.out.println(e);
        }


    }

}
