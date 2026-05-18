package model;

public class Novel extends Buku {
    private String genre;
    private int volume;

    public Novel(String judul, String penulis, int noSeri, int tahunTerbit, String genre, int volume) {
        super(judul, penulis, noSeri, tahunTerbit );
        this.genre = genre;
        this.volume = volume;
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
}