package com.company;

import java.io.File;
import java.util.*;

public class DiskDirectory extends DiskElement {
    DiskDirectory(File file, boolean sort, boolean comparator) {
        super(file, sort, comparator);
        isDirectory = true;
        isFile = false;
        size = 0;
        if (this.sort) {
            if (comparator)
                children = new TreeSet<>((object1, object2) -> (int) (object1.compareTo(object2)));
            else
                children = new TreeSet<>(new DataComparator());

        } else {
            children = new HashSet<>();
        }
    }
    protected void print(int depth) {
        String finalPrint = "";
        if (depth > 1) {
            for (int i = 0; i < depth - 1; i++) {
                finalPrint += '.';
            }
        }

        if (depth != 0)
            finalPrint += "\\";

        finalPrint += name + '\t' + "K " + size;
        System.out.println(finalPrint);
        for (DiskElement element : children) {
            element.print(depth + 1);
        }
    }

    void add(DiskElement element) {
        children.add(element);
    }

    private Set<DiskElement> children;
}
