package com.company;

import java.io.File;

public class DiskFile extends DiskElement {
    public DiskFile(File file) {
        super(file);
        isDirectory = false;
        isFile = true;
    }
    protected void print(int depth) {
        for (int i =0 ;i < depth; i++) {
            System.out.println("-");
        }
        System.out.println(name);
        System.out.println("\t");
        System.out.println("P ");
        System.out.println(formattedDate);
        System.out.println("\n");
    }


}
