package T1.persistence;

public class ChinaDog extends Animal {
    //子类的成员变量与父类成员变量同名时, 父类成员变量被”隐藏”
    //要想访问与父类的同名的成员变量, 两种方法
    //①: 在子类中是用 super
    //②:将该变量强转成父类的类
    private String kind="ChinaDog";
    private double price=100;
    private boolean isVaccineInjected;

    //子类的构造方法里有个默认的super方法，调用父类的构造方法，父类没有这个无参方法给他调用当然会报错
    public ChinaDog(String kind,String name, String gender, int age, double price,boolean isVaccineInjected) {
        super(kind,name, gender, age, price);
        this.isVaccineInjected=isVaccineInjected;
    }

    public boolean getIsVaccineInjected(){
        return this.isVaccineInjected;
    }

    public void setVaccineInjected(boolean vaccineInjected) {
        isVaccineInjected = vaccineInjected;
    }

    @Override
    public String toString() {
        return "中华田园犬："+this.getName()+"的年龄是"+this.getAge()+",性别是"+this.getGender()+
                ",价格是100元"+",是否注射狂犬病疫苗："+this.isVaccineInjected;
    }
}