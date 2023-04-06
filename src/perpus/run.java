package perpus;

public class run {
    public static void main(String[] args) {
        Siswa siswa = new Siswa();
        Buku buku = new Buku();
        Peminjaman pinjam = new Peminjaman();
        
        try {
            pinjam.prosesPinjam(siswa, buku);
        } catch (Exception e) {
            System.out.println("Ups...\nThere's error unexpected\nThat causing the program force close >_<");
            System.exit(0);
        }
    }
}