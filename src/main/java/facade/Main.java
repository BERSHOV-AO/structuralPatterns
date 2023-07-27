package facade;

public class Main {
    public static void main(String[] args) {
        BinOps bins = new BinOps();
        System.out.println(bins.sum("010", "101"));
        System.out.println(bins.mult("001", "101"));
    }
}
