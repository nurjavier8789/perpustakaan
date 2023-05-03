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
        
        System.out.println("Selamat datang di Perpustakaan!");
        System.out.print("Masuk sebagai? ('S'iswa/'P'etugas)\n> ");
        String pil = input.next();
        
        do {
            if (pil.equalsIgnoreCase("s")) {
                pinjam.prosesPinjam(siswa, buku);
            } else if (pil.equalsIgnoreCase("p")) {
                petugas.modePetugas();
            } else {
                System.out.println("\nTidak ada opsinya :D\nBye~");
            }
            
            System.out.print("Apakah ingin menggunakan akun lainnya? (y/n)\n> ");
            last = input.next();
        } while (last.equalsIgnoreCase("y"));
    }
}