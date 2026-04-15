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

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Genre : " + genre);
        System.out.println("Volume : " + volume);
    }
}