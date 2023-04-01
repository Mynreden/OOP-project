public class Main {
    public static void main(String[] args) {
        Readers reader1 = new Readers("Baitas Dias",13,"BD","11.11.11",1223);
        reader1.takebook(3);
        reader1.takebook("kkkk, BBB, JJJ");
        reader1.returnBook(2);
        reader1.returnBook("kkk, BBB");
    }
}