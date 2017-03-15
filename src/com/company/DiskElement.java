package com.company;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DiskElement {
    DiskElement(File file) {
        this.file = file;
        name = file.getName();
        long temp = file.lastModified();
        lastModified = new Date(temp);
        formattedDate = template.format(lastModified);
        sort = false;
    }

    DiskElement(File file, boolean sort) {
        this.file = file;
        name = file.getName();
        long temp = file.lastModified();
        lastModified = new Date(temp);
        formattedDate = template.format(lastModified);
        this.sort = sort;
    }

    protected abstract void print(int depth);

//    @Override
//    public int compareTo(DiskElement element) {
//        int elementCompare = name.compareTo(element.name);
//
//        if (elementCompare == 0)
//            return formattedDate.compareTo(element.formattedDate);
//
//        else
//            return elementCompare;
//    }

    File file;
    String name;
    private Date lastModified;
    private SimpleDateFormat template = new SimpleDateFormat("yyyy-MM-dd");
    String formattedDate;
    boolean isDirectory;
    boolean isFile;
    boolean sort;


}
