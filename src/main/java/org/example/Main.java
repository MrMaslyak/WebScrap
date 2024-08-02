import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public static void main(String[] args) {
    String url = "https://navi.gg/ua/teams/cs2";

    try {
        Document doc = Jsoup.connect(url).get();

        Elements playerCards = doc.select(".player-card");


        for (Element playerCard : playerCards) {
            Elements devices = playerCard.select(".player-card__device");


            for (Element device : devices) {
                Element deviceName = device.selectFirst(".player-card__device-name");

                if (deviceName != null) {
                    if (deviceName.ownText().contains("Мишка:")) {
                        Element deviceModel = device.selectFirst(".player-card__device-model");
                        if (deviceModel != null) {
                            System.out.println("Игровая мышь игрока NAVI: " + deviceModel.text());
                        } else {
                            System.out.println("Элемент deviceModel не найден.");
                        }
                    }
                } else {
                    System.out.println("Элемент deviceName не найден.");
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}


