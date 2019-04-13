
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
