public class Siswa {
    private String nama;
    private String nis;
    private boolean sudahVoting;

    public Siswa(String nama, String nis) {
        this.nama = nama;
        this.nis = nis;
        this.sudahVoting = false;
    }

    public String getNama() {
        return nama;
    }

    public String getNis() {
        return nis;
    }

    public boolean isSudahVoting() {
        return sudahVoting;
    }

    public void setSudahVoting(boolean sudahVoting) {
        this.sudahVoting = sudahVoting;
    }
}