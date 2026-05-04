package model;

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

    String getStatusText() {
    return dipinjam ? "Dipinjam" : "Tersedia";
    }


}