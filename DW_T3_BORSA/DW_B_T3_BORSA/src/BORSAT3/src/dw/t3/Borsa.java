package dw.t3;

import java.io.*;
import java.net.URI;

public class Borsa {

    /**
     * Creates instances of the Requester and Parser classes, then makes the parser parse the JSON string obtained from the requester.
     */
    public static void main(String[] args) {
        Requester requester = new Requester();
        Parser parser = new Parser();

        String json = parser.parseJSON(requester.makeAPIRequest());
        URI jarPath;

        try {
            jarPath = Borsa.class.getProtectionDomain().getCodeSource().getLocation().toURI();
            FileReader fr = new FileReader(jarPath + "HTML/code.js");
            BufferedReader br = new BufferedReader(fr);
            String line, entireFile = "";
            int lines = 0;
            while ((line = br.readLine()) != null) {
                if (json != null) {
                    if (lines == 0) {
                        line = "st = `" + json + "`";
                    }
                }
                entireFile += line;
                lines++;
            }
            File jsFile = new File(jarPath + "HTML/code.js");

            FileWriter fw = new FileWriter(jsFile);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(entireFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
