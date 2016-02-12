package generic.factoryimpl;

public class Main {
    public static void main(String[] string) {
        Generic<Araba> gen = new Generic<Araba>(new Araba.ArabaFactory());
        System.out.print(gen.get());
    }
}

//Constructor with Factory<T> parameter
//Abubeee
