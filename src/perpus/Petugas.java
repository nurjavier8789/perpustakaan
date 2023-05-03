package perpus;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Scanner;

public class Petugas implements User {

    private ArrayList<String> namaKaryawan = new ArrayList<String>();
    private ArrayList<String> alamat = new ArrayList<String>();
    private ArrayList<String> telepon = new ArrayList<String>();

    private int pilihMenu = 0;
    
    public Petugas() {
        this.namaKaryawan.add("Cecep");
        this.alamat.add("Jl. Buntu mas No. 69");
        this.telepon.add("037562547568");

        this.namaKaryawan.add("Hendro");
        this.alamat.add("Jl. bucin No. 24");
        this.telepon.add("086423571894");

        this.namaKaryawan.add("Heru");
        this.alamat.add("Jl. kangen kamu No. 23");
        this.telepon.add("083467263789");
    }

    public void modePetugas() throws AWTException, InterruptedException {
        Scanner input = new Scanner(System.in);
        uh bot = new uh();

        System.out.print("Masukkan ID petugas anda > ");
        int idPetugas = input.nextInt();
        bot.bot();

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Halo " + getNama(idPetugas) + "!");
        System.out.println("Selamat datang di perpustakaan! (Mode Petugas)");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        
        System.out.println("\n-= MENU =-");
        System.out.print("1. List Buku\n2. List Siswa\n> ");
        pilihMenu = input.nextInt();
        
        if (pilihMenu == 1) {
            System.out.println("\n-= LIST BUKU =-");
            System.out.print("1. Edit\n2. Tambah\n> ");
            pilihMenu = input.nextInt();
            
            if (pilihMenu == 1) {
                System.out.println("Edit");
            } else if (pilihMenu == 2) {
                System.out.println("Tambah");
            } else {
                System.out.println("Tidak ada pilihan itu ://");
            }
            
        } else if (pilihMenu == 2) {
            System.out.println("\n-= LIST SISWA =-");
            System.out.print("1. Edit\n2. Tambah\n> ");
            pilihMenu = input.nextInt();
            
            if (pilihMenu == 1) {
                System.out.println("Edit");
            } else if (pilihMenu == 2) {
                System.out.println("Tambah");
            } else {
                System.out.println("Tidak ada pilihan itu ://");
            }
        }
    }

    @Override
    public String getNama(int a) {
        return this.namaKaryawan.get(a);
    }
}
