package mine;

public class HelloWorld {

    public static void main(String[] args) {
    	//PW-249 redirectUri before replacement: 
    	//http%3A%2F%2Fdemotair.arabi.org%2Fservlets%2FOrder%3Fstate%3Dsearch%26mode%3Dstock%26stock_numbers%3DSALK_024277C
        String redirectUri = "http%3A%2F%2Fdemotair.arabi.orgggggggggggghttphttps";
        //String replacedRedirectUri = redirectUri.replace("http", "https");
        //redirectUri = replacedRedirectUri;
 
        redirectUri = redirectUri.replaceFirst("http", "https");
        System.out.println(redirectUri);
    }

}
