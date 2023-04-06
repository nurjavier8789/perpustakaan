package perpus;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Scanner;

public class Peminjaman {

    ArrayList<Integer> idSiswa = new ArrayList<Integer>();
    ArrayList<Integer> idBuku = new ArrayList<Integer>();
    ArrayList<Integer> banyak = new ArrayList<Integer>();

    public void prosesPinjam(Siswa siswa, Buku buku) throws AWTException, InterruptedException {
        Scanner input = new Scanner(System.in);
        uh bot = new uh();

        System.out.println("Selamat datang di Perpustakaan!");

        System.out.print("Masukkan ID siswa anda > ");
        int idMember = input.nextInt();

        if (idMember >= siswa.getJmlSiswa() && idMember >= 0) {
            System.out.println("ID tidak ditemukan");
        } else {
            bot.bot();
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Halo " + siswa.getNamaSiswa(idMember) + "!");
            System.out.println("Selamat datang di perpustakaan!");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

            if (siswa.getStatus(idMember) == false) {
                System.out.print("\nAnda Belum pinjam buku hari ini\nMau meminjam buku hari ini? (y/n) > ");
                String pinjam = input.next();

                if (pinjam.equalsIgnoreCase("y")) {
                    System.out.println("\nLIST BUKU\n| ID |\t| Nama Buku \t|\t| Stok |");
                    for (int i = 0; i < buku.getJmlBuku(); i++) {
                        System.out.println("| " + i + " |\t| " + buku.getNamaBuku(i) + " |\t| " + buku.getStok(i) + " |");
                    }

                    System.out.print("\nSilahkan memilih buku berdasarkan ID > ");
                    int idBuku = input.nextInt();

                    siswa.editStatus(idBuku, true);
                    buku.editStok(idBuku, buku.editStok(idBuku, buku.getStok(idBuku) - 1));

                    System.out.println("");
                } else if (pinjam.equalsIgnoreCase("n")) {
                    System.out.println("ok then");
                } else {
                    System.out.println("Uhh... gk ada pilihan :V");
                }
            } else {
                System.out.print("Maaf anda sudah meminjam buku hari ini...\nSilahkan mengembalikan buku untuk dapat meminjam buku\nIngin mengenbalikan buku? (y/n) > ");
                String balek = input.next();

                if (balek.equalsIgnoreCase("y")) {
                    System.out.println("balek");
                } else if (balek.equalsIgnoreCase("n")) {
                    System.out.println("ok then");
                } else {
                    System.out.println("Noo....");
                }
            }
        }
    }
}
