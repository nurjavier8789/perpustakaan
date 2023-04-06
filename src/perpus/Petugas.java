package perpus;

import java.util.ArrayList;

public class Petugas {
    ArrayList<String> namaKaryawan = new ArrayList<String>();
    ArrayList<String> alamat = new ArrayList<String>();
    ArrayList<String> telepon = new ArrayList<String>();
    
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
}
