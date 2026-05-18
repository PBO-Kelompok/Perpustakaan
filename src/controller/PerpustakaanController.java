package controller;

import model.Buku;
import model.Komik;
import model.Novel;
import model.Sorting;
import model.Searching;
import view.PerpustakaanView;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PerpustakaanController {
    private ArrayList<Buku> daftarBuku;
    private PerpustakaanView view;

    public PerpustakaanController(ArrayList<Buku> daftarBuku, PerpustakaanView view) {
        this.daftarBuku = daftarBuku;
        this.view = view;

        this.view.btnTampil.addActionListener(e -> tampilkanBuku(daftarBuku));
        this.view.btnSort.addActionListener(e -> sortingBuku());
        this.view.btnSearch.addActionListener(e -> searchBuku());
        this.view.btnEdit.addActionListener(e -> editBuku());
        this.view.btnPinjam.addActionListener(e -> pinjamBuku());
        this.view.btnKembali.addActionListener(e -> kembalikanBuku());
        this.view.btnDPD.addActionListener(e -> daftarBukuDipinjam());
        this.view.btnTambah.addActionListener(e -> tambahBuku());
        this.view.btnDelete.addActionListener(e -> deleteBuku());
    }

    private void tampilkanBuku(ArrayList<Buku> data) {

    view.tableModel.setRowCount(0);

    for (Buku b : data) {

        String genre = "-";
        String volume = "-";
        String negaraAsal = "-";
        String ilustrator = "-";

        // jika Novel
        if (b instanceof Novel) {
            Novel n = (Novel) b;

            genre = n.getGenre();
            volume = String.valueOf(n.getVolume());
        }

        // jika Komik
        if (b instanceof Komik) {
            Komik k = (Komik) b;

            genre = k.getGenre();
            volume = String.valueOf(k.getVolume());
            negaraAsal = k.getNegaraAsal();
            ilustrator = k.getIlustrator();
        }

        view.tableModel.addRow(new Object[]{
            b.getNoSeri(),
            b.getJudul(),
            b.getPenulis(),
            b.getTahunTerbit(),
            b.getStatus(),
            b.getCatatan(),
            genre,
            volume,
            negaraAsal,
            ilustrator
        });
    }
}

    private void sortingBuku(){
        ArrayList<Buku> temp = new ArrayList<>(daftarBuku);
        Sorting.sort(temp);
        tampilkanBuku(temp);
    }

    private void editBuku() {

    int row = view.table.getSelectedRow();

    if (row == -1) {

        JOptionPane.showMessageDialog(
            null,
            "Pilih buku dulu!"
        );

        return;
    }

    int noSeri = (int) view.tableModel.getValueAt(row, 0);

    for (Buku b : daftarBuku) {

        if (b.getNoSeri() == noSeri) {

            try {

                // input dasar
                String judulBaru = JOptionPane.showInputDialog(
                    "Judul baru:",
                    b.getJudul()
                );

                String penulisBaru = JOptionPane.showInputDialog(
                    "Penulis baru:",
                    b.getPenulis()
                );

                int tahunBaru = Integer.parseInt(
                    JOptionPane.showInputDialog(
                        "Tahun baru:",
                        b.getTahunTerbit()
                    )
                );

                // update data dasar
                b.setJudul(judulBaru);
                b.setPenulis(penulisBaru);
                b.setTahunTerbit(tahunBaru);

                // jika Novel
                if (b instanceof Novel) {

                    Novel n = (Novel) b;

                    String genreBaru = JOptionPane.showInputDialog(
                        "Genre baru:",
                        n.getGenre()
                    );

                    int volumeBaru = Integer.parseInt(
                        JOptionPane.showInputDialog(
                            "Volume baru:",
                            n.getVolume()
                        )
                    );

                    n.setGenre(genreBaru);
                    n.setVolume(volumeBaru);
                }

                // jika Komik
                if (b instanceof Komik) {

                    Komik k = (Komik) b;

                    String genreBaru = JOptionPane.showInputDialog(
                        "Genre baru:",
                        k.getGenre()
                    );

                    int volumeBaru = Integer.parseInt(
                        JOptionPane.showInputDialog(
                            "Volume baru:",
                            k.getVolume()
                        )
                    );

                    String negaraBaru = JOptionPane.showInputDialog(
                        "Negara asal baru:",
                        k.getNegaraAsal()
                    );

                    String ilustratorBaru = JOptionPane.showInputDialog(
                        "Ilustrator baru:",
                        k.getIlustrator()
                    );

                    k.setGenre(genreBaru);
                    k.setVolume(volumeBaru);
                    k.setNegaraAsal(negaraBaru);
                    k.setIlustrator(ilustratorBaru);
                }

                JOptionPane.showMessageDialog(
                    null,
                    "Data buku berhasil diupdate!"
                );

                break;

            } catch (Exception e) {

                JOptionPane.showMessageDialog(
                    null,
                    "Input tidak valid!"
                );
            }
        }
    }

    tampilkanBuku(daftarBuku);
}

    
    private void searchBuku(){
        ArrayList<Buku> temp = new ArrayList<>(daftarBuku);
        Sorting.sort(temp);

        String input = JOptionPane.showInputDialog("Masukkan No Seri:");

        try {
            int key = Integer.parseInt(input); 
            int hasilSearch = Searching.search(temp, key);

            view.tableModel.setRowCount(0);

            if (hasilSearch != -1) {
                Buku b = temp.get(hasilSearch);

                view.tableModel.addRow(new Object[]{
                    b.getNoSeri(),
                    b.getJudul(),
                    b.getPenulis(),
                    b.getTahunTerbit(),
                    b.getStatus()
                });

            } else {
                JOptionPane.showMessageDialog(null, "Buku tidak ditemukan");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Input harus berupa angka!");
        }
    }

    private void pinjamBuku() {
    int row = view.table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Pilih buku dulu!");
            return;
        }
    int noSeri = (int) view.tableModel.getValueAt(row, 0);
        for (Buku b : daftarBuku) {
            if (b.getNoSeri() == noSeri) {

                // Validasi apakah buku sudah dipinjam
                if (b.getStatus().equals("Dipinjam")) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Buku sedang dipinjam!"
                    );
                    return;
                }

                // Input catatan
                String catatan = JOptionPane.showInputDialog(
                    null,
                    "Masukkan catatan peminjaman:"
                );

                // Jika user cancel
                if (catatan == null) {
                    return;
                }

                b.pinjamBuku(catatan);

                JOptionPane.showMessageDialog(
                    null,
                    "Buku berhasil dipinjam"
                );

                break;
            }
        }

        tampilkanBuku(daftarBuku);
    }

    private void kembalikanBuku() {
        int row = view.table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Pilih buku dulu!");
            return;
        }

        int noSeri = (int) view.tableModel.getValueAt(row, 0);

        for (Buku b : daftarBuku) {
            if (b.getNoSeri() == noSeri) {

                // Validasi jika buku belum dipinjam
                if (b.getStatus().equals("Tersedia")) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Buku belum dipinjam!"
                    );
                    return;
                }

                b.kembalikanBuku();

                JOptionPane.showMessageDialog(
                    null,
                    "Buku berhasil dikembalikan"
                );

                break;
            }
        }

        tampilkanBuku(daftarBuku);
    }

    private void daftarBukuDipinjam() {

    view.tableModel.setRowCount(0);

    for (Buku b : daftarBuku) {

        // hanya tampilkan buku yang dipinjam
        if (b.getStatus().equals("Dipinjam")) {

            String genre = "-";
            String volume = "-";
            String negaraAsal = "-";
            String ilustrator = "-";

            // jika Novel
            if (b instanceof Novel) {

                Novel n = (Novel) b;

                genre = n.getGenre();
                volume = String.valueOf(n.getVolume());
            }

            // jika Komik
            if (b instanceof Komik) {

                Komik k = (Komik) b;

                genre = k.getGenre();
                volume = String.valueOf(k.getVolume());
                negaraAsal = k.getNegaraAsal();
                ilustrator = k.getIlustrator();
            }

            view.tableModel.addRow(new Object[]{
                b.getNoSeri(),
                b.getJudul(),
                b.getPenulis(),
                b.getTahunTerbit(),
                b.getStatus(),
                b.getCatatan(),
                genre,
                volume,
                negaraAsal,
                ilustrator
            });
        }
    }
}

    private void tambahBuku() {
        try {
            String[] pilihan = {"Buku", "Novel", "Komik"};

            String jenis = (String) JOptionPane.showInputDialog(
                null,
                "Pilih jenis buku:",
                "Tambah Buku",
                JOptionPane.QUESTION_MESSAGE,
                null,
                pilihan,
                pilihan[0]
            );

            if (jenis == null) {
                return;
            }

            String judul = JOptionPane.showInputDialog("Masukkan Judul:");
            String penulis = JOptionPane.showInputDialog("Masukkan Penulis:");

            int noSeri = Integer.parseInt(
                JOptionPane.showInputDialog("Masukkan Nomor Seri:")
            );

            int tahunTerbit = Integer.parseInt(
                JOptionPane.showInputDialog("Masukkan Tahun Terbit:")
            );

            // cek no seri duplikat
            for (Buku b : daftarBuku) {
                if (b.getNoSeri() == noSeri) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Nomor seri sudah digunakan!"
                    );
                    return;
                }
            }

            switch (jenis) {

                case "Buku":

                    Buku bukuBaru = new Buku(
                        judul,
                        penulis,
                        noSeri,
                        tahunTerbit
                    );

                    daftarBuku.add(bukuBaru);

                    break;

                case "Novel":

                    String genre = JOptionPane.showInputDialog(
                        "Masukkan Genre:"
                    );

                    int volume = Integer.parseInt(
                        JOptionPane.showInputDialog("Masukkan Volume:")
                    );

                    Novel novelBaru = new Novel(
                        judul,
                        penulis,
                        noSeri,
                        tahunTerbit,
                        genre,
                        volume
                    );

                    daftarBuku.add(novelBaru);

                    break;

                case "Komik":

                    String genreK = JOptionPane.showInputDialog(
                        "Masukkan Genre:"
                    );

                    int volumeK = Integer.parseInt(
                        JOptionPane.showInputDialog("Masukkan Volume:")
                    );

                    String negaraAsal = JOptionPane.showInputDialog(
                        "Masukkan Negara Asal:"
                    );

                    String ilustrator = JOptionPane.showInputDialog(
                        "Masukkan Ilustrator:"
                    );

                    Komik komikBaru = new Komik(
                        judul,
                        penulis,
                        noSeri,
                        tahunTerbit,
                        genreK,
                        volumeK,
                        negaraAsal,
                        ilustrator
                    );

                    daftarBuku.add(komikBaru);

                    break;
            }

            JOptionPane.showMessageDialog(
                null,
                "Buku berhasil ditambahkan!"
            );

            tampilkanBuku(daftarBuku);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                null,
                "Input angka tidak valid!"
            );
        }
    }

    private void deleteBuku() {
        int row = view.table.getSelectedRow();
        // Validasi pilih data
        if (row == -1) {
            JOptionPane.showMessageDialog(
                null,
                "Pilih data dulu!"
            );
            return;
        }
        int noSeri = (int) view.tableModel.getValueAt(row, 0);
        for (Buku b : daftarBuku) {

            if (b.getNoSeri() == noSeri) {

                // Detail buku
                String detail =
                    "No Seri : " + b.getNoSeri() +
                    "\nJudul : " + b.getJudul() +
                    "\nPenulis : " + b.getPenulis() +
                    "\nTahun : " + b.getTahunTerbit() +
                    "\nStatus : " + b.getStatus();

                // Konfirmasi hapus
                int konfirmasi = JOptionPane.showConfirmDialog(
                    null,
                    detail + "\n\nYakin ingin menghapus buku ini?",
                    "Konfirmasi Hapus",
                    JOptionPane.YES_NO_OPTION
                );

                if (konfirmasi == JOptionPane.YES_OPTION) {

                    daftarBuku.removeIf(x -> x.getNoSeri() == noSeri);

                    JOptionPane.showMessageDialog(
                        null,
                        "Buku berhasil dihapus!"
                    );

                    tampilkanBuku(daftarBuku);
                }

                return;
            }
        }
    }

}