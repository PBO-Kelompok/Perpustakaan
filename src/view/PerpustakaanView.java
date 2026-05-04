package view;

import javax.swing.*;

public class PerpustakaanView extends JFrame {
    public JTextArea area = new JTextArea();
    public JButton btnTampil = new JButton("Tampilkan");

    public PerpustakaanView() {
        setTitle("Perpustakaan");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new JScrollPane(area), "Center");
        add(btnTampil, "South");
    }
}