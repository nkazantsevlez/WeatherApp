import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static org.jsoup.Jsoup.connect;

public class AppUI
{

    public JPanel MainPanel;
    private JButton UpdateButton;
    private JLabel NowValues;
    private JLabel SensationValue;
    private JComboBox CityList;

    public AppUI() throws IOException {

        UpdateButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Document doc=null;
                Elements spans, spans2;
                Element span,span2;

                switch(CityList.getSelectedIndex())
                {


                    case 0:

                        try {
                            doc= (Document) Jsoup.connect("https://www.gismeteo.ru/weather-moscow-4368/").get();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        spans=doc.select("span [class=js_value tab-weather__value_l]");
                        span=spans.get(0);

                        spans2=doc.select("span [class=unit unit_temperature_c] ");
                        span2=spans2.get(0);

                        NowValues.setText(span.text());
                        SensationValue.setText(span2.text());


                        break;

                    case 1:
                        try {
                            doc= (Document) Jsoup.connect("https://www.gismeteo.ru/weather-sankt-peterburg-4079/").get();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        spans=doc.select("span [class=js_value tab-weather__value_l]");
                        span=spans.get(0);

                        spans2=doc.select("span [class=unit unit_temperature_c] ");
                        span2=spans2.get(0);

                        NowValues.setText(span.text());
                        SensationValue.setText(span2.text());
                    break;

                    case 2:
                        try {
                            doc= (Document) Jsoup.connect("https://www.gismeteo.ru/weather-novosibirsk-4690/").get();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        spans=doc.select("span [class=js_value tab-weather__value_l]");
                        span=spans.get(0);

                        spans2=doc.select("span [class=unit unit_temperature_c] ");
                        span2=spans2.get(0);

                        NowValues.setText(span.text());
                        SensationValue.setText(span2.text());
                     break;

                    case 3:
                        try {
                            doc= (Document) Jsoup.connect("https://www.gismeteo.ru/weather-vladivostok-4877/").get();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        spans=doc.select("span [class=js_value tab-weather__value_l]");
                        span=spans.get(0);

                        spans2=doc.select("span [class=unit unit_temperature_c] ");
                        span2=spans2.get(0);

                        NowValues.setText(span.text());
                        SensationValue.setText(span2.text());
                        break;

                    default:JOptionPane.showMessageDialog(null,"Ошибка!","Ошибка",JOptionPane.ERROR_MESSAGE); break;
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
