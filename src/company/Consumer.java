package company;

public class Consumer implements Runnable {
    private final int id;
    private final int itemCount;
    private final Manager manager;

    public Consumer(int id, int itemCount, Manager manager) {
        this.id = id;
        this.itemCount = itemCount;
        this.manager = manager;
    }

    @Override
    public void run() {
        for (int i = 0; i < itemCount; i++) {
            try {
                manager.full.acquire();
                manager.access.acquire();

                String item = manager.storage.remove(0);
                System.out.printf("[СПОЖИВАЧ %2d] Взяв  : %s%n", id, item);

                manager.access.release();
                manager.empty.release();

                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
