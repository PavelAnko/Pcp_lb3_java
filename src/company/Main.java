package company;

public class Main {
    public static void main(String[] args) {
        int storageSize = 5;
        int[] producerItems = { 6, 4, 7 };
        int[] consumerItems = { 3, 6, 7, 4 };

        Manager manager = new Manager(storageSize);

        for (int i = 0; i < producerItems.length; i++) {
            new Thread(new Producer(i + 1, producerItems[i], manager)).start();
        }

        for (int i = 0; i < consumerItems.length; i++) {
            new Thread(new Consumer(i + 1, consumerItems[i], manager)).start();
        }
    }
}
