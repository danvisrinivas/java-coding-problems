package threads;

public class InventoryServiceImpl implements Runnable {

    @Override
    public void run() {
        updateInventory();
    }

    public void updateInventory() {
        System.out.println("Inventory update is in progress");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Inventory update process is completed");
    }

}
