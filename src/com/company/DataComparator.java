package com.company;

import java.util.Comparator;

public class DataComparator implements Comparator<DiskElement> {
    @Override
    public int compare(DiskElement e1, DiskElement e2) {
        int elementCompare = (int) e2.size - (int) e1.size;
        if (elementCompare == 0)
            return e1.name.compareTo(e2.name);

        else
            return elementCompare;
    }
}
