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
    }

    private void tampilkanBuku(ArrayList<Buku> data) { 
        view.tableModel.setRowCount(0);

        for (Buku b : data) {
            view.tableModel.addRow(new Object[]{
                b.getNoSeri(),
                b.getJudul(),
                b.getPenulis(),
                b.getTahunTerbit(),
                b.getStatus()
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
        JOptionPane.showMessageDialog(null, "Pilih buku dulu!");
        return;
    }
    int noSeri = (int) view.tableModel.getValueAt(row, 0);
        for (Buku b : daftarBuku) {
            if (b.getNoSeri() == noSeri) {
                try {
                    String judulBaru = JOptionPane.showInputDialog("Judul baru:", b.getJudul());
                    String penulisBaru = JOptionPane.showInputDialog("Penulis baru:", b.getPenulis());
                    int tahunBaru = Integer.parseInt(
                            JOptionPane.showInputDialog("Tahun baru:", b.getTahunTerbit())
                    );

                    // update data
                    b.setJudul(judulBaru);
                    b.setPenulis(penulisBaru);
                    b.setTahunTerbit(tahunBaru);

                    break;

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Input tidak valid!");
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

            // Hanya tampilkan buku yang dipinjam
            if (b.getStatus().equals("Dipinjam")) {

                view.tableModel.addRow(new Object[]{
                    b.getNoSeri(),
                    b.getJudul(),
                    b.getPenulis(),
                    b.getTahunTerbit(),
                    b.getStatus()
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
}