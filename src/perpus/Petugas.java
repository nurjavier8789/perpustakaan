package perpus;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Scanner;

public class Petugas implements User {

    private ArrayList<String> namaKaryawan = new ArrayList<String>();
    private ArrayList<String> alamat = new ArrayList<String>();
    private ArrayList<String> telepon = new ArrayList<String>();

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
    }

    @Override
    public String getNama(int a) {
        return this.namaKaryawan.get(a);
    }
}
