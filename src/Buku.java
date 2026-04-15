
import java.util.ArrayList;

public class Buku {
    private String judul;
    private String penulis;
    private int tahunTerbit;
    private int noSeri;
    private String keterangan ;
    private Status status = new Status();

    public Buku(String judul, String penulis, int noSeri, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.noSeri = noSeri;
        this.tahunTerbit = tahunTerbit;
    }
    
    public String getJudul() {
        return judul; 
    }
    public String getPenulis() {
        return penulis; 
    }
    public int getNoSeri() {
        return noSeri; 
    }
    public int getTahunTerbit() {
        return tahunTerbit; 
    }
    public boolean getIsDipinjam() {
    return status.isDipinjam();
    }

   public boolean setNoSeri(int noSeri, ArrayList<Buku> semuaBuku) {
        if (noSeri <= 0) {
            System.out.println(" No Seri tidak valid!");
            return false;
        }
        for (Buku b : semuaBuku) {
            if (b.getNoSeri() == noSeri) {
                System.out.println(" No Seri sudah digunakan!");
                return false;
            }
        }
        this.noSeri = noSeri;
        return true;
    }

   public void tampilkanInfo() {
    System.out.println("Nomor Seri : " + noSeri);
    System.out.println("Judul : " + judul);
    System.out.println("Penulis : " + penulis);
    System.out.println("Tahun Terbit : " + tahunTerbit);
    System.out.println("Status : " + (getIsDipinjam() ? "Dipinjam" : "Tersedia"));

        if (getIsDipinjam() && !keterangan.isEmpty()) {
            System.out.println("Catatan: " + keterangan);
        }
    }

    public void pinjamBuku(String keterangan) {
        if (!getIsDipinjam()) {
            status.pinjam();
            this.keterangan = keterangan;
        } 
        else {
            System.out.println("Buku sudah dipinjam!");
        }   
    }   
    

    public void kembalikanBuku() {
        status.kembalikan();
        keterangan = "";
    }
    


    class Status {
        private boolean dipinjam = false;

        void pinjam() {
            if (!dipinjam) {
                dipinjam = true;
                System.out.println("Buku berhasil dipinjam");
            } else {
                System.out.println("Buku sudah dipinjam!");
            }
        }

        void kembalikan() {
            if (dipinjam) {
                dipinjam = false;
                System.out.println("Buku berhasil dikembalikan");
            } else {
                System.out.println("Buku belum dipinjam!");
            }
        }

        boolean isDipinjam() {
            return dipinjam;
        }
    }

}