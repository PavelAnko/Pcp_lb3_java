package company;

public class Producer implements Runnable {
    private final int itemCount;
    private final Manager manager;

    public Producer(int itemCount, Manager manager) {
        this.itemCount = itemCount;
        this.manager = manager;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < itemCount; i++) {
            try {
                manager.empty.acquire();
                manager.access.acquire();
                int index = i +1;
                String item = "Item " + index + " from " + Thread.currentThread().getName();
                manager.storage.add(item);
                System.out.println("Produced: " + item);

                manager.access.release();
                manager.full.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
