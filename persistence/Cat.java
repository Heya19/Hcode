package T1.persistence;

public class Cat extends Animal {
    private String kind="Cat";
    private double price=200;
    public Cat(String kind,String name, String gender, int age) {
        super(kind,name, gender, age, 200.0);
    }
    @Override
    public String toString() {
        return "猫猫："+this.getName()+"的年龄是"+this.getAge()+",性别是"+this.getGender()+
                ",价格是200元.";
    }
}

