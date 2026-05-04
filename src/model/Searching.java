package model;

import java.util.ArrayList;

public class Searching {
    public static int search(ArrayList<Buku> data, int target){
        int left = 0;
        int right = data.size() - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (data.get(mid).getNoSeri() == target) {
                    return mid;
                }

                else if (data.get(mid).getNoSeri() < target) {
                    left = mid + 1;
                }

                else {
                    right = mid - 1;
                }
            }

        return -1;
    }
}
