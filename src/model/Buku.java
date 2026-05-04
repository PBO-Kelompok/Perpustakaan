package model;

public class Buku {
    private String judul;
    private String penulis;
    private int tahunTerbit;
    private int noSeri;
    // private String keterangan ;
    // private Status status = new Status();

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
}