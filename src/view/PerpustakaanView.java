package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PerpustakaanView extends JFrame {
    public JTextField txtCari = new JTextField();
    public JButton btnTampil = new JButton("Tampilkan Daftar Buku");
    public JButton btnSort = new JButton("Sorting Buku");   
    public JButton btnSearch = new JButton("Cari No seri Buku");   
    public JTable table;
    public DefaultTableModel tableModel;
    public JButton btnTambah = new JButton("Tambahkan Buku");
public JButton btnDelete = new JButton("Hapus Buku ");
public JButton btnPinjam = new JButton("Pinjam Buku");
public JButton btnKembali = new JButton("Kembalikan Buku");
public JButton btnEdit = new JButton("Edit Buku");
public JButton btnDPD = new JButton("Daftar Buku Dipinjam");

    public PerpustakaanView() {
        setTitle("Sistem Perpustakaan GUI");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

            String[] kolom = {
                "No Seri",
                "Judul",
                "Penulis",
                "Tahun",
                "Status",
                "Catatan",
                "Genre",
                "Volume",
                "Negara Asal",
                "Ilustrator"
            };
tableModel = new DefaultTableModel(kolom, 0);
table = new JTable(tableModel);

JScrollPane scroll = new JScrollPane(table);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10,1,5,5));

        panel.add(btnTampil);
        panel.add(btnSort);
        panel.add(btnSearch);
        panel.add(btnTambah);
        panel.add(btnEdit);
        panel.add(btnDelete);
        panel.add(btnDPD);
        panel.add(btnPinjam);
        panel.add(btnKembali);
        

        add(panel, BorderLayout.WEST);
        add(scroll, BorderLayout.CENTER);
    }
}