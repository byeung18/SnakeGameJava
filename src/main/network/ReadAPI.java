package network;

import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;


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
            String s = sb.toString();
            int min = s.indexOf("temp_min") + 10;
            int max = s.indexOf("temp_max") + 10;
            Float mintemp = Float.parseFloat(s.substring(min, min+6)) - 273;
            Float maxtemp = Float.parseFloat(s.substring(max, max+6)) - 273;

            System.out.println("London has high of " + maxtemp + " and low of " + mintemp + ".");


        } finally {

            if (br != null) {
                br.close();
            }
        }
    }
}
