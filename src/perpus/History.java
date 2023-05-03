package perpus;

public class History {
    public void laporan(Buku buku) {
        System.out.println("\nLIST BUKU");
        System.out.println("| ID |\t| Nama Siswa\t|\t| Stok | | Harga |");
        for (int i = 0; i < buku.getStok(); i++) {
            System.out.println("| " + i + " |\t| " + buku.getNama(i) + " |\t| " + buku.getStok(i) + " |\t| " + buku.getHarga(i) + " |");
        }
    }
    
    public void laporan(Siswa siswa) {
        System.out.println("\nLIST SISWA");
        System.out.println("| ID |\t| Nama Siswa |\t| Alamat\t|\t| Telepon\t|\t| Status |");
        for (int i = 0; i < siswa.getJmlSiswa(); i++) {
            System.out.println("| " + i + " |\t| " + siswa.getNama(i) + " |\t| " + siswa.getAlamat(i) + " |\t| " + siswa.getTelepon(i) + " |\t| " + siswa.getStatus(i) + " |");
        }
    }
    
    public void laporan(Peminjaman pinjam, Siswa siswa, Buku buku) {
        System.out.println("\nTABEL RIWAYAT PEMINJAMAN");
        System.out.println("| Nama Siswa |\t| Judul Buku\t|\t| Jumlah | | Status |");
        
        for (int i = 0; i < pinjam.getJmlHistor(); i++) {
                if (pinjam.getStatus(i) == true) {
                    System.out.println("| " + siswa.getNama(pinjam.getIdSiswa(i)) + " |\t| " + buku.getNama(pinjam.getIdSiswa(i)) + " |\t| " + pinjam.getBanyak(i) + "\t| | " + pinjam.getStatus(i) + " |");
                } else if (pinjam.getStatus(i) == false) {
                    System.out.println("| " + siswa.getNama(pinjam.getIdSiswa(i)) + " |\t| " + buku.getNama(pinjam.getIdSiswa(i)) + " |\t| " + pinjam.getBanyak(i) + "\t| | " + pinjam.getStatus(i) + " |");
                }
        }
        
    }
}
