import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherApp {

    public static void main(String[] args) throws IOException {

        System.out.println("Погода в Москве: ");

        Document doc=null;

        doc= (Document) Jsoup.connect("https://www.gismeteo.ru/weather-moscow-4368/").get();

        System.out.println("Сейчас: ");
        Elements spans=doc.select("span [class=js_value tab-weather__value_l]");
        Element span=spans.get(0);
        System.out.println(span.text());

        System.out.println("По ощущению: ");
        Elements spans2=doc.select("span [class=unit unit_temperature_c] ");
        Element span2=spans2.get(0);
        System.out.println(span2.text());

    }
}
