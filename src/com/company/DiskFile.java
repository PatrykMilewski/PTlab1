package com.company;

import java.io.File;

public class DiskFile extends DiskElement {
    DiskFile(File file, boolean comparator) {
        super(file, false, comparator);
        isDirectory = false;
        isFile = true;
        size = file.length();
    }

    protected void print(int depth) {
        String finalPrint = "";
        if (depth > 1) {
            for (int i = 0; i < depth - 1; i++) {
                finalPrint += '.';
            }
        }
        finalPrint += '|';

        finalPrint += name + '\t' + "F " + size;
        System.out.println(finalPrint);

    }

}
