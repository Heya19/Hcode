package T1.business;

public class CheckingShopAccount {
    //balance为余额
    private static double balance=1000;//默认为我的宠物店有本金1000
    //方法：卖出动物赚钱
    public void saleAnimal(double amount) {
        balance += amount;
    }
    //方法：买动物花钱
    public void buyAnimal(double amount) throws InsufficientBalanceException{
        if(amount <= balance) {
            balance -= amount;
            System.out.print("宠物店成功购入该动物！该动物信息为：");
        }
        else {
            double needs = amount - balance;
            throw new InsufficientBalanceException(needs);
        }
    }
    //方法：返回余额
    public static double getBalance() {
        return balance;
    }

}
