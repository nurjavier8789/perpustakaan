package perpus;

import java.util.ArrayList;

public class Siswa {
    ArrayList<String> namaSiswa = new ArrayList<String>();
    ArrayList<String> alamat = new ArrayList<String>();
    ArrayList<String> telepon = new ArrayList<String>();
    ArrayList<Boolean> status = new ArrayList<Boolean>(); // true = Sudah Pinjam | false = Belum Pinjam
    
    public Siswa() {
        this.namaSiswa.add("Asep");
        this.alamat.add("Mars");
        this.telepon.add("081234567890");
        this.status.add(false);
        
        this.namaSiswa.add("Mamat");
        this.alamat.add("Perempatan Bumi");
        this.telepon.add("085123456789");
        this.status.add(false);
        
        this.namaSiswa.add("Sololiquy");
        this.alamat.add("Pertigaan Venus");
        this.telepon.add("083123456789");
        this.status.add(true);
    }

    public int getJmlSiswa() {
        return this.namaSiswa.size();
    }

    public String getNamaSiswa(int a) {
        return this.namaSiswa.get(a);
    }
    
    public boolean getStatus(int a) {
        return this.status.get(a);
    }
    
    public void editStatus(int a, boolean b) {
        this.status.set(a, b);
    }
}
