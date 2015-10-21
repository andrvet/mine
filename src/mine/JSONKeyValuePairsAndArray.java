package mine;

//import javax.rmi.CORBA.Util;

import org.json.JSONArray;
import org.json.JSONObject;

//http://www.oneminuteinfo.com/2012/09/facebook-graph-api-parse-json-response.html#
public class JSONKeyValuePairsAndArray {

	public static void main(String[] args) {

		/*
		 * JSON: key-value pairsTOP
		 * 
		 * If the JSON response you are getting is as simple as a map such as
		 * the following:
		 * {"id":"36241119","name":"Michael Wen","first_name":"Michael"
		 * ,"last_name":"Wen"...} Simply do the following to parse JSON to get
		 * the data you want: In this case JSON is just like a Map where you get
		 * the value by providing a key.
		 */

		Object response;
		
		try {
			//JSONObject json = Util.parseJson(response);
			JSONObject json = null;//wrong
			
			String[] data = new String[] { "id", "name", "first_name",
					"last_name" };

			StringBuffer sb = new StringBuffer("User data:");
			for (String token : data) {
				sb.append(" " + token + "=" + json.getString(token));
			}
			System.out.println(sb.toString());

		} catch (Exception e) {
			System.out.println("Error parsing JSON:" + e);
		}

		/*
		 * JSON: arrays of key-value pairsTOP
		 * 
		 * If the JSON response contains an array of data such as the following:
		 * { "data": [ { "name": "\u5b8b\u67cf\u661f", "id": "36241119",
		 * "rsvp_status": "attending" }, { "name": "Hung-Chang Lin", "id":
		 * "36241118", "rsvp_status": "attending" } ] }
		 * 
		 * Getting the data you need may seem daunting at first but it's
		 * actually quite easy. Simply extract the array into an JSONArray
		 * object and loop through the array while getting the data of each
		 * element. Here's some sample code:
		 */
		String[] data = new String[] { "id", "name", "rsvp_status" };

		try {
			JSONObject json = null;//wrong
			//JSONObject json = Util.parseJson(response);
			JSONArray events = json.getJSONArray("data");
			for (int i = 0; i < events.length(); i++) {
				JSONObject event = (JSONObject) events.get(i);

				StringBuffer sb = new StringBuffer("Event #" + (i + 1) + ":");
				for (String token : data) {
					sb.append(" " + token + "=" + event.getString(token));
				}
				sb.append("\n\n");

				System.out.println(sb.toString());
			}
		} catch (Exception e) {
			System.out.println("Error parsing JSON: " + e);
		}
	}

}
