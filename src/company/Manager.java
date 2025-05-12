package company;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Manager {
    public Semaphore access;
    public Semaphore full;
    public Semaphore empty;
    public ArrayList<String> storage;

    public Manager(int storageSize) {
        this.access = new Semaphore(1);
        this.full = new Semaphore(0);
        this.empty = new Semaphore(storageSize);
        this.storage = new ArrayList<>();
    }
}
