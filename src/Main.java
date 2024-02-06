//Создать три потока Т1, Т2, Т3
//Реализовать выполнение поток в последовательности Т3 -> T2 -> T1
public class Main {
    public static void main(String[] args) {
        ThreadOne t3 = new ThreadOne();
        ThreadOne t2 = new ThreadOne(t3);
        ThreadOne t1 = new ThreadOne(t2);

        t1.setName("T1");
        t2.setName("T2");
        t3.setName("T3");

        t1.start();
        t2.start();
        t3.start();
    }
}