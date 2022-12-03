package T1.persistence;

import java.time.LocalDate;

public class Customer{
    private String name;
    private int count;
    private LocalDate date;
    public Customer(String name, int count, LocalDate date){
        this.name=name;
        this.count=count;
        this.date=date;
    }
    public String getName(){
        return this.name;
    }
    public LocalDate getDate(){
        return this.date;
    }
    @Override
    public String toString(){
        return "顾客："+this.name+",到店次数为："+this.count+",最新到店时间为："+this.date;
    }
}