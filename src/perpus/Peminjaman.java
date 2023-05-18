package perpus;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Scanner;

public class Peminjaman extends id {

    private ArrayList<Integer> idSiswa = new ArrayList<Integer>();
    private ArrayList<Integer> idBuku = new ArrayList<Integer>();
    private ArrayList<Integer> banyak = new ArrayList<Integer>();
    private ArrayList<Boolean> status = new ArrayList<Boolean>(); // true = Sudah Pinjam | false = Belum Pinjam
    private ArrayList<Integer> bukuPin = new ArrayList<Integer>();

    public Peminjaman() {
        this.idSiswa.add(2);
        this.idBuku.add(0);
        this.banyak.add(1);
        this.status.add(true);
        this.bukuPin.add(0);

        this.idSiswa.add(1);
        this.idBuku.add(1);
        this.banyak.add(1);
        this.status.add(true);
        this.bukuPin.add(2);

        this.idSiswa.add(0);
        this.idBuku.add(2);
        this.banyak.add(1);
        this.status.add(true);
        this.bukuPin.add(1);
    }

    public void prosesPinjam(Siswa siswa, Buku buku) throws AWTException, InterruptedException {
        Scanner input = new Scanner(System.in);
        uh bot = new uh();
        String repeat = "";

        System.out.print("Masukkan ID siswa anda > ");
        setIdMember(input.nextInt());
        this.idSiswa.add(getIdMember());

        if (getIdMember() >= siswa.getJmlSiswa() && getIdMember() >= 0) {
            System.out.println("ID tidak ditemukan");
        } else {
            bot.bot();
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Halo " + siswa.getNama(getIdMember()) + "!");
            System.out.println("Selamat datang di perpustakaan!");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            do {
                repeat = "";
                if (siswa.getStatus(getIdMember()) == false) {
                    System.out.println("\n---------------------------------");
                    System.out.print("Status: Belum Meminjam Buku\nMau meminjam buku? (y/n) > ");
                    String pinjam = input.next();

                    // bagian peminjaman
                    if (pinjam.equalsIgnoreCase("y")) {
                        System.out.println("\nLIST BUKU\n| ID |\t| Nama Buku \t|\t| Stok |");
                        for (int i = 0; i < buku.getStok(); i++) {
                            System.out.println("| " + i + " |\t| " + buku.getNama(i) + " |\t| " + buku.getStok(i) + " |");
                        }

                        do {
                            System.out.print("\nSilahkan memilih buku berdasarkan ID > ");
                            setIdBook(input.nextInt());
                            
                            if (buku.getStok(getIdBook()) == 0) {
                                System.out.println("Maaf stok buku habis");
                            }
                        } while (buku.getStok(getIdBook()) == 0);
                        

                        if (idBook >= buku.getStok()) {
                            System.out.println("Salah");
                        } else {
                            this.idBuku.add(getIdBook());
                            this.banyak.add(1);
                            this.status.add(true);

                            siswa.getStatus(getIdMember(), true);
                            siswa.editBukuPinjam(getIdMember(), getIdBook());
                            buku.editStok(getIdBook(), (buku.getStok(getIdBook()) - 1));

                            System.out.println("\nTerima kasih telah meminjam buku hari ini\nSemoga harimu menyenangkan :D");
                            System.out.println("\nDETAIL PEMINJAMAN");
                            System.out.println("Nama: " + siswa.getNama(getIdMember()) + "\nNo. HP: " + siswa.getTelepon(getIdMember()));
                            System.out.println("Buku dengan ID: " + getIdBook() + "\nJudul Buku: " + buku.getNama(getIdBook()) + "\nStatus anda saat ini adalah: sudah meminjam");
                        }
                        
                        System.out.print("\n\nIngin mengembalikan buku? (y/n)\n> ");
                        repeat = input.next();
                    } else if (pinjam.equalsIgnoreCase("n")) {
                        System.out.println("");
                    } else {
                        System.out.println("\nTidak ada opsi itu...");
                    }
                } // bagian pengembalian
                else {
                    System.out.println("\n---------------------------------");
                    System.out.print("Status: Sudah Meminjam Buku\nSudah selesai membaca? Silahkan bisa mengembalikan bukunya\nIngin mengembalikan buku? (y/n) > ");
                    String balek = input.next();

                    if (balek.equalsIgnoreCase("y")) {
                        System.out.println("\nLIST BUKU\n| ID |\t| Nama Buku \t|\t| Stok |");
                        for (int i = 0; i < buku.getStok(); i++) {
                            System.out.println("| " + i + " |\t| " + buku.getNama(i) + " |\t| " + buku.getStok(i) + " |");
                        }
                        System.out.print("\nKamu telah meminjam buku dengan ID " + siswa.getBukuPinjam(getIdMember()) + ".\nApakah ingin dikembalikan? (y/n)\n> ");
                        String confirm = input.next();

                        if (confirm.equalsIgnoreCase("y")) {
                            siswa.getStatus(getIdMember(), false);
                            buku.editStok(siswa.getBukuPinjam(getIdMember()), (buku.getStok(siswa.getBukuPinjam(getIdMember())) + 1));
                            this.idBuku.add(getIdBook());
                            this.banyak.add(1);
                            this.status.add(false);
                            this.bukuPin.add(null);
                            System.out.println("Pengembalian buku berhasil!");
                            System.out.println("\nDETAIL PENGEMBALIAN");
                            System.out.println("Nama: " + siswa.getNama(getIdMember()) + "\nNo. HP: " + siswa.getTelepon(getIdMember()));
                            System.out.println("Buku dengan ID > " + siswa.getBukuPinjam(getIdMember()) + "\nJudul Buku > " + buku.getNama(siswa.getBukuPinjam(getIdMember())) + "\nStatus anda saat ini adalah > belum meminjam");
                            siswa.editBukuPinjam(getIdMember(), 0);
                            
                            System.out.print("\n\nIngin meminjam buku? (y/n)\n> ");
                            repeat = input.next();
                        } else {
                            System.out.println("Oh Belum Selesai kah? ok kalau begitu\nSelamat membaca!");
                        }
                    } else if (balek.equalsIgnoreCase("n")) {
                        System.out.println("");
                    } else {
                        System.out.println("\nTidak ada opsi itu...");
                    }
                }
            } while (repeat.equalsIgnoreCase("y"));
        }
    }

    public int getIdSiswa(int a) {
        return this.idSiswa.get(a);
    }

//    public int getIdBuku(int a) {
//        return this.idBuku.get(a);
//    }
    
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