package model;

class Status {
    private boolean dipinjam = false;
    private String catatan = "" ;

    void pinjam(String catatan) {
        if (!dipinjam) {
            dipinjam = true;
            this.catatan = catatan;
        } else {
            System.out.println("Buku sudah dipinjam!");
        }
    }

    void kembalikan() {
        if (dipinjam) {
            dipinjam = false;
            catatan = "";
            
        } else {
            System.out.println("Buku belum dipinjam!");
        }
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