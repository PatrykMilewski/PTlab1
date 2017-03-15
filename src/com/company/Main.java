package com.company;

import java.io.File;

public class Main {
    private static boolean sort = true;
    public static void main(String[] args) {
        String pathToScan = args[0];
        if (args.length > 1 && (args[1].equals(new String("Sort")) || args[1].equals(new String("sort"))))
            sort = true;
        else
            sort = false;

        File files = new File(pathToScan);
        DiskDirectory diskDirectory = new DiskDirectory(files, sort);
        createStructure(files.listFiles(), diskDirectory);
        diskDirectory.print(0);
    }

    static void createStructure(File[] files, DiskDirectory diskDirectory) {
        DiskElement diskElement;
        for (File file : files) {
            if (file.isDirectory()) {
                diskElement = new DiskDirectory(file, sort);
                createStructure(file.listFiles(), (DiskDirectory) diskElement);
            }
            else
                diskElement = new DiskFile(file);

            diskDirectory.add(diskElement);
        }
    }

}
