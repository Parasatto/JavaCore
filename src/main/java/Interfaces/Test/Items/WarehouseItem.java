package Interfaces.Test.Items;

public class WarehouseItem {

    private String title;
    protected int weight;

    public WarehouseItem(String title, int weight) {
        this.title = title;
        this.weight = weight;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
