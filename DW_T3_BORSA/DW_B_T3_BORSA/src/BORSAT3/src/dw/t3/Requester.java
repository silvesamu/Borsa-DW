package dw.t3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;

public class Requester {

    /**
     * Requests stock data from the API.
     * @return the JSON string with the stock values. If an exception occurs, null.
     */
    public String makeAPIRequest() {
        try {
            LocalDate to = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
            LocalDate from = to.minusYears(1);
            URL url = new URL("http://api.marketstack.com/v1/eod?access_key=ad6efcf74f8bee5e5615cc2146452418&symbols=NFLX&limit=500&date_from=" + from + "&date_to=" + to);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            return content.toString();
        } catch (Exception ex) {
            return null;
        }
    }

}
