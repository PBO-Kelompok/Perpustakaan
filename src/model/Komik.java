package model;

public class Komik extends Buku {
    private String genre;
    private int volume;
    private String negaraAsal;
    private String ilustrator;

    public Komik(String judul, String penulis, int noSeri, int tahunTerbit, String genre, int volume, String negaraAsal, String ilustrator) {
        super(judul, penulis, noSeri, tahunTerbit);
        this.genre = genre;
        this.volume = volume;
        this.negaraAsal = negaraAsal;
        this.ilustrator = ilustrator;
    }

    public String getNegaraAsal(){ 
        return negaraAsal; 
    }
    public String getIlustrator(){ 
        return ilustrator; 
    }
    public String getGenre(){
        return genre;
    }
    public int getVolume(){
        return volume;
    }
    public void setGenre(String genre) {
    this.genre = genre;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }
    public void setNegaraAsal(String negaraAsal) {
        this.negaraAsal = negaraAsal;
    }
    public void setIlustrator(String ilustrator) {
        this.ilustrator = ilustrator;
    }
}