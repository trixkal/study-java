class SingletonPattern {
    private SingletonPattern() {}

    private static class SingletonHelper {
        private static final SingletonPattern instance = new SingletonPattern();
    }

    public static SingletonPattern getInstance() {
        return SingletonHelper.instance;
    }
}

public class SingletonStudy {
    public static void main(String[] args) {
        SingletonPattern s1 = SingletonPattern.getInstance();
        SingletonPattern s2 = SingletonPattern.getInstance();

        if(s1.hashCode() == s2.hashCode()) {
            System.out.print("Correct Implementation of Singleton Pattern");
        }
        else {
            System.out.print("InCorrect Implementation of Singleton Pattern");
        }
    }
}

