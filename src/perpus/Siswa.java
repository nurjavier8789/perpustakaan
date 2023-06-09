package perpus;

import java.util.ArrayList;

public class Siswa implements User {
    private ArrayList<String> namaSiswa = new ArrayList<String>();
    private ArrayList<String> alamat = new ArrayList<String>();
    private ArrayList<String> telepon = new ArrayList<String>();
    private ArrayList<Boolean> status = new ArrayList<Boolean>(); // true = Sudah Pinjam | false = Belum Pinjam
    private ArrayList<Integer> bukuPinjam = new ArrayList<Integer>();
    
    public Siswa() {
        this.namaSiswa.add("Asep");
        this.alamat.add("Perlimaan Mars");
        this.telepon.add("081234567890");
        this.status.add(false);
        this.bukuPinjam.add(0);
        
        this.namaSiswa.add("Mamat");
        this.alamat.add("Perempatan Bumi");
        this.telepon.add("085123456789");
        this.status.add(false);
        this.bukuPinjam.add(0);
        
        this.namaSiswa.add("Sololiquy");
        this.alamat.add("Pertigaan Venus");
        this.telepon.add("083123456789");
        this.status.add(true);
        this.bukuPinjam.add(1);
    }
    
    public int getJmlSiswa() {
        return this.namaSiswa.size();
    }

    @Override
    public String getNama(int a) {
        return this.namaSiswa.get(a);
    }
    
    public String getAlamat(int a) {
        return this.alamat.get(a);
    }
    
    public String getTelepon(int a) {
        return this.telepon.get(a);
    }
    
    public boolean getStatus(int a) {
        return this.status.get(a);
    }
    
    public void getStatus(int a, boolean b) {
        this.status.set(a, b);
    }
    
    public int getBukuPinjam(int a) {
        return this.bukuPinjam.get(a);
    }
    
    public void editBukuPinjam(int a, int b) {
        this.bukuPinjam.set(a,b);
    }
}
