package T1.business;

//异常类 (AnimalNotFountException) 没找到动物异常，店内没有动物可买时抛出
public class AnimalNotFountException extends RuntimeException{
    public AnimalNotFountException(int needs){
        System.out.println("抱歉，当前店内该动物已不足,还需要再进"+needs+"只该动物,欢迎您的下次光临！");
        System.out.println("====================================================================");
    }
}