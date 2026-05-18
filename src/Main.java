import model.Buku;
import model.Novel;
import model.Komik;

import view.PerpustakaanView;
import controller.PerpustakaanController;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Buku> semuaBuku = new ArrayList<>();
        semuaBuku.add(new Buku("Laskar Pelangi", "Andrea Hirata",012, 2005));
        semuaBuku.add(new Buku("Bumi", "Tere Liye", 013, 2014));
        semuaBuku.add(new Buku("Buuik","iki",015, 2012));
        semuaBuku.add(new Komik("Latna Saga", "Soon-Q", 987, 2012, "Isekai", 20, "Korea", "Khit Studio"));
        semuaBuku.add(new Komik("One Piece", "Eichiro Oda", 123, 2006, "Pirate", 2000, "Jepang", "Who know"));
        semuaBuku.add(new Komik("Isekai Smartphone", "Enda", 1, 2012, "Peak Isekai", 10, "Jepang", "Deen"));

        semuaBuku.add(new Novel("TBATE", "Yuki Tabata", 12123, 2012, "Fantasy", 450));
        semuaBuku.add(new Novel("Omniscien Reader View Point", "Sing Shong", 133, 2010, "Peak Fantasy", 100));

        PerpustakaanView view = new PerpustakaanView();
        new PerpustakaanController(semuaBuku, view);

        view.setVisible(true);
    }
}  