package T1.ui;

import T1.business.*;
import T1.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;


public class Test {
    public static void main(String[] args) {
        MyAnimalShop myAnimalShop = new MyAnimalShop();
        System.out.println("===============宠物店buy功能测试开始=====================================");
        ArrayList<Animal> animals= new ArrayList<>();
        animals.add(new ChinaDog("ChinaDog","汪汪","雄",1,100,false));
        animals.add(new Cat("Cat","喵喵1","雌",2));
        animals.add(new Pig("pig","猪猪侠","雄",3));
        animals.add(new Cat("Cat","喵喵2","雄",1));
        animals.add(new Pig("pig","超级猪猪侠","雌",99));
        myAnimalShop.buy(animals);
        System.out.println("===============宠物店buy功能测试结束=====================================");
        System.out.println("===============宠物店greet功能测试开始===================================");
        ArrayList<Customer> customers= new ArrayList<>();
        customers.add(new Customer("何雯彧",1,LocalDate.of(2008,5,17)));
        customers.add(new Customer("何娅",5, LocalDate.now()));
        myAnimalShop.greet(customers);
        System.out.println("===============宠物店greet功能测试结束===================================");
        System.out.println("===============宠物店close功能测试开始===================================");
        myAnimalShop.close();
        System.out.println("===============宠物店close功能测试结束===================================");

    }
}
