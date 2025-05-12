package company;

public class Producer implements Runnable {
    private final int id;
    private final int itemCount;
    private final Manager manager;

    public Producer(int id, int itemCount, Manager manager) {
        this.id = id;
        this.itemCount = itemCount;
        this.manager = manager;
    }

    @Override
    public void run() {
        for (int i = 0; i < itemCount; i++) {
            try {
                manager.empty.acquire();
                manager.access.acquire();

                String item = "Item_" + id + "_" + (i + 1);
                manager.storage.add(item);
                System.out.printf("[ВИРОБНИК %2d] Додав : %s%n", id, item);

                manager.access.release();
                manager.full.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
