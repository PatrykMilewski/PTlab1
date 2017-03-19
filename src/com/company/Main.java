package com.company;

import java.io.File;

public class Main {
    private static boolean sort, comparator;
    public static void main(String[] args) {
        String pathToScan = "C:\\Work";
        sort = true;
        comparator = false;

        File files = new File(pathToScan);
        DiskDirectory diskDirectory = new DiskDirectory(files, sort, comparator);
        createStructure(files.listFiles(), diskDirectory);
        diskDirectory.print(0);
    }

    private static void createStructure(File[] files, DiskDirectory diskDirectory) {
        DiskElement diskElement;
        for (File file : files) {
            if (file.isDirectory()) {
                diskElement = new DiskDirectory(file, sort, comparator);
                createStructure(file.listFiles(), (DiskDirectory) diskElement);
                diskDirectory.size += diskElement.size;
            } else {
                diskElement = new DiskFile(file, comparator);
                diskElement.size = file.length();
                diskDirectory.size += diskElement.size;
            }


            diskDirectory.add(diskElement);
        }
    }

}
