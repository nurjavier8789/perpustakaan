package perpus;

import java.awt.AWTException;
import java.util.Scanner;

public class run {

    public static void main(String[] args) throws AWTException, InterruptedException {
        Siswa siswa = new Siswa();
        Buku buku = new Buku();
        Peminjaman pinjam = new Peminjaman();
        Petugas petugas = new Petugas();
        Scanner input = new Scanner(System.in);

        System.out.println("Selamat datang di Perpustakaan!");
        System.out.print("Masuk sebagai? ('S'iswa/'P'etugas)\n> ");
        String pil = input.next();
        
        if (pil.equalsIgnoreCase("s")) {
            pinjam.prosesPinjam(siswa, buku);
        } else if (pil.equalsIgnoreCase("p")) {
            petugas.modePetugas();
        }
    }
}
