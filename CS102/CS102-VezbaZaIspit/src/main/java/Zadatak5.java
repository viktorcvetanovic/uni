import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;

public class Zadatak5 {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread(null));
        thread.run();
    }


    @Data
    @AllArgsConstructor
    public static class MyThread implements Runnable {
        private List<News> list;

        @Override
        public void run() {
            try {
                var document = Jsoup.connect("http://www.b92.net/sport/vesti.php").get();
                Elements elements = document.getElementsByClass("container main ");
                for (var el : elements) {
                    Document doc=Jsoup.connect("http://www.b92.net/"+el.select(".left .blog .item .text h2 a")
                                                        .attr("href")).get();
                    for(var elem:doc.getAllElements()){

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class News {
        private String header;
        private String sport;
        private Date date;
        private String time;
        private int commentsCount;
    }
}
