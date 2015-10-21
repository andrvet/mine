package mine;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

//Following example makes use of JSONObject and JSONArray 
//where JSONObject is a java.util.Map and JSONArray is a java.util.List, 
//so you can access them with standard operations of Map or List.
class JsonDecodeDemo 
{
   public static void main(String[] args) 
   {
      JSONParser parser=new JSONParser();
      String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
      try{
         Object obj = parser.parse(s);
         JSONArray array = (JSONArray)obj;
         System.out.println("The 2nd element of array");
         System.out.println(array.get(1));
         System.out.println();

         JSONObject obj2 = (JSONObject)array.get(1);
         System.out.println("Field \"1\"");
         System.out.println(obj2.get("1"));    

         s = "{}";
         obj = parser.parse(s);
         System.out.println(obj);

         s= "[5,]";
         obj = parser.parse(s);
         System.out.println(obj);

         s= "[5,,2]";
         obj = parser.parse(s);
         System.out.println(obj);
      }catch(org.json.simple.parser.ParseException | JSONException pe){
         System.out.println("position: " + pe.getMessage());
         System.out.println(pe);
      }
   }
}