/*7. MyAnimalShop自己的宠物店 (implements AnimalShop)
变量:
    店的余额double
    一个存放动物的列表 (使用ArrayList、LinkedList或其他你喜欢的List实现)
    一个顾客列表留作纪念
    是否正在营业
....
实现接口中的方法
    1.买入动物 -> 买入一只动物，记得在动物列表中添加，
      如余额不足则抛出异常InsufficientBalanceException
    2.招待客户 -> 接受客户参数，在顾客列表中加入新顾客，
      出售动物，如果店内没有动物，抛出AnimalNotFoundException。
      通过toString输出动物信息，并把钱入账，将动物移除列表
    3歇业 -> (LocalDate判断) 输出当天光顾的客户的列表信息，计算并输出一天的利润
*/
package T1.business;

import T1.persistence.*;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

interface AnimalShop{
    void buy(ArrayList<Animal> buyInList);
    void greet(ArrayList<Customer> cuss);
    void close();//定义歇业时间t为：最后一个顾客的到来时间+20min;
}
public class MyAnimalShop implements AnimalShop{
    private double balance;
    //public static ArrayList<Animal> curListDog=new ArrayList<>();会有ConcurrentModificationException异常，因为用了在遍历的同时用了remove.
    public static CopyOnWriteArrayList<Animal> curListDog=new CopyOnWriteArrayList<>();//public ArrayList<ChinaDog> curList1;为什么不行？说需要将Chinadog public
    public static CopyOnWriteArrayList<Animal> curListCat=new CopyOnWriteArrayList<>();
    public static CopyOnWriteArrayList<Animal> curListPig=new CopyOnWriteArrayList<>();
    public static ArrayList<Customer> curList2=new ArrayList<>();
    private boolean isClosed;
    @Override
    public void buy(ArrayList<Animal> buyInList){
        CheckingShopAccount checkingShopAccount = new CheckingShopAccount();
        for(Animal a:buyInList){
            try {
                checkingShopAccount.buyAnimal(a.getPrice());
                System.out.println(a);
                switch (a.getKind()){
                    case("ChinaDog"):
                        curListDog.add(a);
                        break;
                    case("Cat"):
                        curListCat.add(a);
                        break;
                    case("Pig"):
                        curListPig.add(a);
                        break;
                }
            }catch(InsufficientBalanceException e){
                System.out.println("因为宠物店当前还缺："+ e.getAmount()+"元。");
                System.out.println("宠物店未能成功购入该动物！该动物信息为：" +a.toString());
                e.printStackTrace();//e.printStackTrace() 是输出错误日志，并不中断程序
            }

        }

    }

    @Override
    public void greet(ArrayList<Customer> cuss) {
        for(Customer cus:cuss) {
            CheckDog cd = new CheckDog();
            CheckCat cc = new CheckCat();
            CheckPig cp = new CheckPig();
            curList2.add(cus);
            Scanner sc = new Scanner(System.in);
            System.out.println(cus.getName() + "客户您好:");
            System.out.println("请问您需要买什么动物呢？");
            System.out.println("1:中华田园犬");
            System.out.println("2.猫猫");
            System.out.println("3.猪猪");
            System.out.println("请您输入相对应的序号:");
            int n = sc.nextInt();
            System.out.println("请您输入想买的动物只数：");
            int m = sc.nextInt();
            switch (n) {
                case (1):
                    try {
                        int i = 0;
                        cd.saleOut(curListDog.size(),m, 100);
                        for (Animal a : curListDog) {
                            if (i == m) break;
                            System.out.println(a);
                            curListDog.remove(a);
                            i++;
                        }
                    } catch (AnimalNotFountException a) {
                        a.printStackTrace();
                    }
                    break;
                case (2):
                    try {
                        int i = 0;
                        cc.saleOut(curListCat.size(),m, 200);
                        for (Animal a : curListCat) {
                            if (i == m) break;
                            System.out.println(a);
                            curListCat.remove(a);
                            i++;
                            if(i==curListDog.size())break;
                        }
                    } catch (AnimalNotFountException a) {
                        a.printStackTrace();
                    }
                    break;
                case (3):
                    try {
                        int i = 0;
                        cp.saleOut(curListPig.size(),m, 300);
                        for (Animal a : curListPig) {
                            if (i == m) break;
                            System.out.println(a);
                            curListPig.remove(a);
                            i++;
                            if(i==curListPig.size())break;
                        }
                    } catch (AnimalNotFountException a) {
                        a.printStackTrace();
                    }
                    break;

            }
        }
    }

    @Override
    public void close() {
        double a=CheckingShopAccount.getBalance();
        LocalDate dateLatest = LocalDate.now();
        System.out.println("叮咚叮咚~");
        System.out.println("宠物店关门啦，今天到店的客人有：");
        for(Customer cus:curList2){
            if(dateLatest.equals(cus.getDate())){
                System.out.println(cus);
            }
        }
        System.out.println("到今天，宠物店的利润为："+CheckingShopAccount.getBalance());
    }
}