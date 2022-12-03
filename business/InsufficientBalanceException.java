package T1.business;

public class InsufficientBalanceException extends RuntimeException{
    //此处的amount用来储存当出现异常（买动物所需的钱多于余额时）所缺乏的钱
    private double amount;
    public InsufficientBalanceException(double amount)
    {
        this.amount = amount;
    }
    public double getAmount()
    {
        return amount;
    }
}
