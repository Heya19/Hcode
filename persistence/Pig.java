package T1.persistence;

public class Pig extends Animal {
    private String kind="Pig";
    private double price=300;

    public Pig(String kind,String name, String gender, int age) {
        super(kind,name, gender, age, 300.0);
    }
    @Override
    public String toString() {
        return "猪猪："+this.getName()+"的年龄是"+this.getAge()+",性别是"+this.getGender()+
                ",价格是300元.";
    }
}

