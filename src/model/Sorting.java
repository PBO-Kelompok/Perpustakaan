package model;

import java.util.ArrayList;

public class Sorting {
    public static void sort(ArrayList<Buku> data)  {
        for (int i = 0; i < data.size() - 1; i++) {
            for (int j = 0; j < data.size() - 1 - i; j++) {

                if (data.get(j).getNoSeri() > data.get(j + 1).getNoSeri()) {

                    Buku temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);
                }
            }
        }
    }
}
