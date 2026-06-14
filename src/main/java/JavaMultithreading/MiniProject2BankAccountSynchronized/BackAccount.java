package JavaMultithreading.MiniProject2BankAccountSynchronized;

public class BackAccount {
    private int balance = 10_000;

    public synchronized void withdrow(int amoint){
        this.balance=this.balance - 10;
    }

    public synchronized void deposit(int amount){
        this.balance= this.balance + 10;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
