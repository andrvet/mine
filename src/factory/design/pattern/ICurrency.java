package factory.design.pattern;

interface ICurrency {
    String getSymbol();
}

//Concrete Rupee Class code
class Rupee implements ICurrency {
    @Override
    public String getSymbol() {
           return "Rs";
    }
}

//Concrete SGD class Code
class SGDDollar implements ICurrency {
    @Override
    public String getSymbol() {
           return "SGD";
    }
}

//Concrete US Dollar code
class USDollar implements ICurrency {
    @Override
    public String getSymbol() {
           return "USD";
    }
}
