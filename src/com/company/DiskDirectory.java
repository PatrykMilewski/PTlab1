package com.company;

import java.io.File;
import java.util.*;

public class DiskDirectory extends DiskElement {
    DiskDirectory(File file, boolean sort) {
        super(file, sort);
        isDirectory = true;
        isFile = false;
        if (this.sort) {
            children = new TreeSet<>(new DataComparator());
            //children = new TreeSet<>((object1, object2) -> (int) (object1.file.getName().compareToIgnoreCase(object2.file.getName())));
        } else {
            children = new HashSet<>();
        }
    }
    protected void print(int depth) {
        String finalPrint = "";
        for (int i = 0; i < depth; i++) {
            finalPrint += '-';
        }
        finalPrint += name + '\t' + "K " + formattedDate;
        System.out.println(finalPrint);
        for (DiskElement element : children) {
            element.print(depth + 1);
        }
    }

    void add(DiskElement element) {
        children.add(element);
    }

    private Set<DiskElement> children;
    //private Set<DiskElement> children;
}
