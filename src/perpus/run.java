package perpus;

import java.awt.AWTException;
import java.util.Scanner;

public class run {

    public static void main(String[] args) throws AWTException, InterruptedException {
        Siswa siswa = new Siswa();
        Buku buku = new Buku();
        Peminjaman pinjam = new Peminjaman();
        Petugas petugas = new Petugas();
        History history = new History();
        Scanner input = new Scanner(System.in);
        
        String last = "";
        String init = "";
        
        System.out.println("Selamat datang di Perpustakaan!");
        
        do {
            System.out.print("Masuk sebagai? ('S'iswa/'P'etugas)\n> ");
            String pil = input.next();
            do {
                if (pil.equalsIgnoreCase("s")) {
                    pinjam.prosesPinjam(siswa, buku);
                    System.out.print("\nApakah ingin menggunakan akun lainnya? (y/n)\n> ");
                    last = input.next();
                } else if (pil.equalsIgnoreCase("p")) {
                    System.out.println("Maaf untuk saat ini belum tersedia...");
                } else {
                    System.out.println("\nTidak ada opsinya :D\nBye~");
                }
            } while (last.equalsIgnoreCase("y"));
            
            System.out.print("\nIngin Berganti mode? (y/n)\n> ");
            init = input.next();
        } while (init.equalsIgnoreCase("y"));
        
        System.out.println("\n\nSee next time!!");
    }
}