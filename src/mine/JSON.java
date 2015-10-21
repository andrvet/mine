package mine;

//import org.json.JSONObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;



public class JSON {
	
	public static void main(String[] args) {
        String s = args[0].toString();
        System.out.println("=>" + s);
        try {
            JSONObject json = (JSONObject) new JSONParser().parse(s);
            System.out.println(json);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
	
	
}
