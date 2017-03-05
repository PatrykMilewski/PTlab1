package com.company;

import java.io.File;
import java.util.Set;

public class DiskDirectory extends DiskElement {
    public DiskDirectory(File file, boolean sort) {
        super(file, sort);
        isDirectory = true;
        isFile = false;
    }
    protected void print(int depth) {
        for (int i = 1 ;i < depth; i++) {
            System.out.println("-");
        }
        System.out.println("-");
        System.out.println(name);
        System.out.println("\t");
        System.out.println("K ");
        System.out.println(formattedDate);
        System.out.println("\n");
        for (DiskElement element : children) {
            element.print(depth + 1);
        }
    }

    public void add(DiskElement element) {
        children.add(element);
    }

    Set<DiskElement> children;
}
