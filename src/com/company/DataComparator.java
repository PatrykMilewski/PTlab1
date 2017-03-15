package com.company;

import java.util.Comparator;

public class DataComparator implements Comparator<DiskElement> {
    @Override
    public int compare(DiskElement e1, DiskElement e2) {
        int elementCompare = e1.name.compareTo(e2.name);
        if (elementCompare == 0)
            return e1.formattedDate.compareTo(e2.formattedDate);

        else
            return elementCompare;
    }
}
