package model;

class Status {
    private boolean dipinjam = false;
    private String catatan = "" ;

    void pinjam(String catatan) {
        dipinjam = true;
        this.catatan = catatan;
    }

    void kembalikan() {
        dipinjam = false;
        catatan = ""; 
    }

    boolean isDipinjam() {
        return dipinjam;
    }

    String getStatusText() {
    return dipinjam ? "Dipinjam" : "Tersedia";
    }

    String catatan(){
        return catatan ;
    }


}