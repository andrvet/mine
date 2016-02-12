package factory.design.pattern;

//Factory client code
public class Factory {
	
  public static void main(String args[]) {
         String country = "US";
         ICurrency rupee = CurrencyFactory.createCurrency(country);
         System.out.println(rupee.getSymbol());
  }
}
