package JavaMultithreading.MiniProject2BankAccountSynchronized;

public class GameStore {
    private int armorSales;
    private int weaponSales;

    private final Object armorLock = new Object();
    private final Object weaponLock = new Object();

    public void sellArmor(){
        synchronized (armorLock) {
            armorSales++;
        }
    }

    public void sellWeapon(){
        synchronized (weaponLock) {
            weaponSales++;
        }
    }

    public int getArmorSales() {
        return armorSales;
    }

    public void setArmorSales(int armorSales) {
        this.armorSales = armorSales;
    }

    public int getWeaponSales() {
        return weaponSales;
    }

    public void setWeaponSales(int weaponSales) {
        this.weaponSales = weaponSales;
    }
}
