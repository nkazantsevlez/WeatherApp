import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AppUI
{

    public JPanel MainPanel;
    private JButton UpdateButton;
    private JLabel NowValues;
    private JLabel SensationValue;

    public AppUI() throws IOException {
        //System.out.println("Погода в Москве: ");

        Document doc=null;

        doc= (Document) Jsoup.connect("https://www.gismeteo.ru/weather-moscow-4368/").get();

       // System.out.println("Сейчас: ");
        Elements spans=doc.select("span [class=js_value tab-weather__value_l]");
        Element span=spans.get(0);
        // System.out.println(span.text());

        //System.out.println("По ощущению: ");
        Elements spans2=doc.select("span [class=unit unit_temperature_c] ");
        Element span2=spans2.get(0);
        //System.out.println(span2.text());


        UpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NowValues.setText(span.text());
                SensationValue.setText(span2.text());

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
