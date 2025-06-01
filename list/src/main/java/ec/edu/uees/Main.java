package ec.edu.uees;

public class Main {
   public Main() {
   }

   public static void main(String[] var0) {
      System.out.println("Hello world!");
      ArrrayList<String> ejemplo = new ArrrayList<>();
      ejemplo.addLast("a");
      ejemplo.addLast("b");
      ejemplo.addLast("c");
      ejemplo.add(1,"u" );
      System.out.println(ejemplo);
   }
}