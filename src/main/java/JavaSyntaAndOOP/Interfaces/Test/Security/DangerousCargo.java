package JavaSyntaAndOOP.Interfaces.Test.Security;

import JavaSyntaAndOOP.Interfaces.Test.Items.WarehouseItem;

public class DangerousCargo extends WarehouseItem implements Checkable {

    public DangerousCargo(String title, int weight) {
        super(title, weight);
    }

    @Override
    public void check() {
        System.out.println("Груз " + getTitle() +" весом " + weight + " проверен на радиацию");
    }
}
