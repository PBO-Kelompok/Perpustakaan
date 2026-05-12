package model;

public class Buku {
    private String judul;
    private String penulis;
    private int tahunTerbit;
    private int noSeri;
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
        public String getStatus() {
        return status.getStatusText();
    }
    public void pinjamBuku() {
        status.pinjam();
    }
    public void kembalikanBuku() {
        status.kembalikan();
    }

    public void setJudul(String judul) {
    this.judul = judul;
}

public void setPenulis(String penulis) {
    this.penulis = penulis;
}

public void setTahunTerbit(int tahunTerbit) {
    this.tahunTerbit = tahunTerbit;
}

}