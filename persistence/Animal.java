package T1.persistence;

public abstract class Animal {
    protected String kind,name, gender;
    protected int age;
    protected double price;
    public Animal(String kind,String name,String gender,int age,double price){
        this.kind=kind;
        this.name=name;
        this.gender=gender;
        this.age=age;
        this.price=price;
    }
    public String getKind(){
        return this.kind;
    }
    public String getName() {
        return this.name;
    }
    public String getGender() {
        return this.gender;
    }
    public int getAge(){
        return this.age;
    }
    public double getPrice(){
        return this.price;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public abstract String toString();
}





