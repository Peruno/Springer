public class Main {
    public static void main(String[] args) {
        RandomExplorer randomExplorer = new RandomExplorer();
        int attempt = 0;
        while (true) {
            attempt += 1;
            randomExplorer.doRandomRun(attempt);
        }


    }
}