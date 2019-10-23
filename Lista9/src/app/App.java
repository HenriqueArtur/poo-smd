package app;

public class App {
    public static void main(String[] args) throws Exception {
        PFisica p1 =  new PFisica("Tici", 10000.00, 11111111111L);
        PFisica p2 =  new PFisica("Oie", 1000.00, 22211111111L);
        System.out.println(p1.getIndetificador());
        System.out.println(p2.getIndetificador());
    }
}