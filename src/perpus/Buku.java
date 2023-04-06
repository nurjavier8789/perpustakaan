package perpus;

import java.util.ArrayList;

public class Buku {
    ArrayList<String> namaBuku = new ArrayList<String>();
    ArrayList<Integer> stok = new ArrayList<Integer>();
    ArrayList<Integer> harga = new ArrayList<Integer>();
    
    public Buku() {
        this.namaBuku.add("Buku ceritaaa");
        this.stok.add(2);
        this.harga.add(2000);
        
        this.namaBuku.add("Buku Pelajaran");
        this.stok.add(1);
        this.harga.add(2500);
        
        this.namaBuku.add("Buku Dokumenter");
        this.stok.add(4);
        this.harga.add(3000);
    }

    public String getNamaBuku(int a) {
        return this.namaBuku.get(a);
    }

    public int getStok(int a) {
        return this.stok.get(a);
    }
    
    public int getJmlBuku() {
        return this.namaBuku.size();
    }
    
    public int editStok(int a, int b) {
        return this.stok.set(a, b);
    }
}
