class Mahasiswa {
    String nama; int nim ; 
    Mahasiswa(String n, int u){ nama=n; nim =u; } 
    void sapa(){ System.out.println("Halo world i am, " + nama + " - "+nim ); } 
}

public class HelloOOP {
   public static void main(String[] args) {
      Mahasiswa m = new Mahasiswa("WAHYU SEPTIYAN", 240202846); 
      m.sapa(); 
   }
}