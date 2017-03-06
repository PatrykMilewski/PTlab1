package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {
    private static boolean sort = true;
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        String pathToScan = scanIn.nextLine();
        scanIn.close();

        File files = new File(pathToScan);
        DiskDirectory diskDirectory = new DiskDirectory(files, sort);
        createStructure(files.listFiles(), diskDirectory);
        diskDirectory.print(0);
    }
    public static void createStructure(File[] files, DiskDirectory diskDirectory) {
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
