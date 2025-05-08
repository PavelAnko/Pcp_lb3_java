package company;

public class Main {

    public static void main(String[] args) {
        int storageSize = 3;
        int totalItems = 12;
        int numProducers = 3;
        int numConsumers = 4;

        Manager manager = new Manager(storageSize);

        int consumerItems = totalItems / numConsumers;
        for (int i = 0; i < numConsumers; i++) {
            new Consumer(consumerItems, manager);
        }

        int producerItems = totalItems / numProducers;
        for (int i = 0; i < numProducers; i++) {
            new Producer(producerItems, manager);
        }
    }
}
