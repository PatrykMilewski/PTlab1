package com.company;

import java.io.File;

public class DiskFile extends DiskElement {
    public DiskFile(File file) {
        super(file);
        isDirectory = false;
        isFile = true;
    }

    protected void print(int depth) {
        String finalPrint = "";
        for (int i = 0; i < depth; i++) {
            finalPrint += '-';
        }
        finalPrint += name + '\t' + "K " + formattedDate;
        System.out.println(finalPrint);
    }
}
