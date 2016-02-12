package generic.factoryimpl;



//And this is the Factory implementation, as Jon Skeet suggested:

interface Factory<T> {
    T factory();
}

class Araba {
    //static inner class for Factory<T> implementation
    public static class ArabaFactory implements Factory<Araba> {
        public Araba factory() {
            return new Araba();
        }
    }
    public String toString() { return "Abubeee"; }
}

class Generic<T> {
    private T var;

    Generic(Factory<T> fact) {
        System.out.println("Constructor with Factory<T> parameter");
        var = fact.factory();
    }
    Generic(T var) {
        System.out.println("Constructor with T parameter");
        this.var = var;
    }
    T get() { return var; }
}


//
//Output:
//
//Constructor with Factory<T> parameter
//Abubeee


