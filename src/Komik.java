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

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Genre : " + genre);
        System.out.println("Volume : " + volume);
        System.out.println("Negara Asal : " + negaraAsal);
        System.out.println("Ilustrator : " + ilustrator);
    }
}