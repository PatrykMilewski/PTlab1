package com.company;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DiskElement implements Comparable<DiskElement> {
    DiskElement(File file, boolean sort, boolean comparator) {
        this.file = file;
        name = file.getName();
        long temp = file.lastModified();
        lastModified = new Date(temp);
        formattedDate = template.format(lastModified);
        this.sort = sort;
    }

    protected abstract void print(int depth);

    @Override
    public int compareTo(DiskElement element) {
        int elementCompare = (int) element.size - (int) size;

        if (elementCompare == 0)
            return name.compareTo(element.name);

        else
            return elementCompare;


    }

    private File file;
    String name;
    private Date lastModified;
    private SimpleDateFormat template = new SimpleDateFormat("yyyy-MM-dd");
    private String formattedDate;
    boolean isDirectory;
    boolean isFile;
    boolean sort;
    boolean comparator;
    long size;


}
