package T1.business;

public class CheckSale {
    CheckingShopAccount ca=new CheckingShopAccount();
    public void saleOut(int cur,int n,double price)throws AnimalNotFountException{
        if(cur>=n){
            cur -=n;
            ca.saleAnimal(n*price);
            System.out.println("恭喜您，购买成功！您宠物的信息为:");
        }
        else{
            int needs = n - cur;//还需要再进几只动物
            throw new AnimalNotFountException(needs);
        }
    }

}
class CheckDog extends CheckSale{ }
class CheckCat extends CheckSale{ }
class CheckPig extends CheckSale{ }
