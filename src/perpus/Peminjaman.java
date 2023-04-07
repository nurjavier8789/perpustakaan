package perpus;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Scanner;

public class Peminjaman {
    
    private ArrayList<Integer> idSiswa = new ArrayList<Integer>();
    private ArrayList<Integer> idBuku = new ArrayList<Integer>();
    private ArrayList<Integer> banyak = new ArrayList<Integer>();
    private ArrayList<Boolean> status = new ArrayList<Boolean>(); // true = Sudah Pinjam | false = Belum Pinjam
    
    private int idMember, idBook;
    
    public Peminjaman() {
        this.idSiswa.add(2);
        this.idBuku.add(0);
        this.banyak.add(1);
        this.status.add(true);
        
        this.idSiswa.add(1);
        this.idBuku.add(1);
        this.banyak.add(1);
        this.status.add(true);
        
        this.idSiswa.add(0);
        this.idBuku.add(2);
        this.banyak.add(1);
        this.status.add(true);
    }

    public void prosesPinjam(Siswa siswa, Buku buku) throws AWTException, InterruptedException {
        Scanner input = new Scanner(System.in);
        uh bot = new uh();

        System.out.print("Masukkan ID siswa anda > ");
        idMember = input.nextInt();
        this.idSiswa.add(idMember);

        if (idMember >= siswa.getJmlSiswa() && idMember >= 0) {
            System.out.println("ID tidak ditemukan");
        } else {
            bot.bot();
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Halo " + siswa.getNama(idMember) + "!");
            System.out.println("Selamat datang di perpustakaan!");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

            if (siswa.getStatus(idMember) == false) {
                System.out.print("\nAnda Belum pinjam buku hari ini\nMau meminjam buku hari ini? (y/n) > ");
                String pinjam = input.next();

                // bagian peminjaman
                if (pinjam.equalsIgnoreCase("y")) {
                    System.out.println("\nLIST BUKU\n| ID |\t| Nama Buku \t|\t| Stok |");
                    for (int i = 0; i < buku.getJmlBuku(); i++) {
                        System.out.println("| " + i + " |\t| " + buku.getNama(i) + " |\t| " + buku.getStok(i) + " |");
                    }

                    System.out.print("\nSilahkan memilih buku berdasarkan ID > ");
                    idBook = input.nextInt();
                    this.idBuku.add(idBook);
                    this.banyak.add(1);
                    this.status.add(true);

                    siswa.editStatus(idMember, true);
                    buku.editStok(idBook, (buku.getStok(idBook) - 1));

                    System.out.println("\nTerima kasih telah meminjam buku hari ini\nSemoga harimu menyenangkan :D");
                    System.out.println("\nDETAIL PEMINJAMAN");
                    System.out.println("Buku dengan ID > " + idBook + "\nJudul Buku > " + buku.getNama(idBook) + "\nStatus anda saat ini adalah > sudah meminjam");
                } else if (pinjam.equalsIgnoreCase("n")) {
                    System.out.println("ok then");
                } else {
                    System.out.println("\nTidak ada opsi itu...");
                }
            }
            
            // bagian pengembalian
            else {
                System.out.print("Maaf anda sudah meminjam buku hari ini...\nSilahkan mengembalikan buku untuk dapat meminjam buku\nIngin mengenbalikan buku? (y/n) > ");
                String balek = input.next();

                if (balek.equalsIgnoreCase("y")) {
                    System.out.print("\nSilahkan masukkan ID buku yang anda pinjam > ");
                    int idBuku = input.nextInt();
                    
                    siswa.editStatus(idMember, false);
                    buku.editStok(idBuku, (buku.getStok(idBuku) + 1));
                    this.idBuku.add(idBook);
                    this.banyak.add(1);
                    this.status.add(false);
                    System.out.println("Pengembalian buku berhasil!");
                    System.out.println("\nDETAIL PENGEMBALIAN");
                    System.out.println("Buku dengan ID > " + idBuku + "\nJudul Buku > " + buku.getNama(idBuku) + "\nStatus anda saat ini adalah > belum meminjam");
                } else if (balek.equalsIgnoreCase("n")) {
                    System.out.println("ok.");
                } else {
                    System.out.println("\nTidak ada opsi itu...");
                }
            }
        }
    }

    public int getIdSiswa(int a) {
        return this.idSiswa.get(a);
    }

    public int getIdBuku(int a) {
        return this.idBuku.get(a);
    }

    public int getBanyak(int a) {
        return this.banyak.get(a);
    }

    public boolean getStatus(int a) {
        return this.status.get(a);
    }
    
    public int getJmlHistor() {
        return this.idSiswa.size();
    }
}
