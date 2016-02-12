package mine;

//Question 5: Can you write critical section code for the singleton? (answer)
//
//Use double checked locking. 
//
//Remember to use the volatile variable to make Singleton thread-safe. 

public class Singleton {

    private static volatile Singleton _instance;

    /**
     * Double checked locking code on Singleton
     * @return Singelton instance
     */
    public static Singleton getInstance() {
        if (_instance == null) {
            synchronized (Singleton.class) {
                if (_instance == null) {
                    _instance = new Singleton();
                }
            }
        }
        return _instance;
    }

}
