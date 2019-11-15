package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadAPI {

    public static void main(String[] args) throws IOException {

        BufferedReader br = null;

        try {
            String apikey = "4152dedf986c5f6708ae726c5d148aa5";
            String londonweatherquery = "https://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=";
            String theURL = londonweatherquery+apikey;
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            System.out.println(sb);
        } finally {

            if (br != null) {
                br.close();
            }
        }
    }
}
