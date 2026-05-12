package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
// import java.awt.event.*;

public class PerpustakaanView extends JFrame {
    public JTextField txtCari = new JTextField();
    public JButton btnTampil = new JButton("Tampilkan");
    public JButton btnSort = new JButton("Sort");   
    public JButton btnSearch = new JButton("Search");   
    public JTable table;
    public DefaultTableModel tableModel;
    public JButton btnTambah = new JButton("Tambah");
public JButton btnDelete = new JButton("Delete");
public JButton btnPinjam = new JButton("Pinjam");
public JButton btnKembali = new JButton("Kembalikan");
public JButton btnEdit = new JButton("Edit");
public JButton btnKeluar = new JButton("Keluar");

    public PerpustakaanView() {
        setTitle("Sistem Perpustakaan GUI");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] kolom = {"No Seri", "Judul", "Penulis", "Tahun", "Status"};

tableModel = new DefaultTableModel(kolom, 0);
table = new JTable(tableModel);

JScrollPane scroll = new JScrollPane(table);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10,1,5,5));

        panel.add(btnTampil);
        panel.add(btnSort);
        panel.add(btnSearch);
        panel.add(btnTambah);
        panel.add(btnDelete);
        panel.add(btnPinjam);
        panel.add(btnEdit);
        panel.add(btnKembali);
        
        panel.add(btnKeluar);

        add(panel, BorderLayout.WEST);
        add(scroll, BorderLayout.CENTER);
    }
}