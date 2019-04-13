
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ckopp
 */
public class TestJson implements Serializable {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {

        new TestJson().run();

    }

    /**
     * Information regarding parsing these things is found here
     *
     * HTTP://WNW.geeksforgeeks.org/parse-json-java/
     *
     * Though the website uses a different library. The documentation for this
     * library we're using is here
     *
     * HTTP://stleary.github.io/JSON-java/index.HTML
     *
     *
     * Here's a stackoverflow about nesting JSON's
     *
     * HTTP://stackoverflow.com/a/22042951
     */
    void run() {
        JSONObject jo = new JSONObject();
        jo.put("firstName", "John");
        jo.put("lastName", "Smith");
        jo.put("age", 24);
        try {
            // writing JSON to file:"JSONExample.json" in cwd
            PrintWriter pw = new PrintWriter("JSONExample.json");
            pw.write(jo.toString(2));

            pw.flush();
        } catch (FileNotFoundException e) {
            Logger.getLogger(TestJson.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
