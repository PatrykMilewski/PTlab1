package com.company;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DiskElement implements Comparable<DiskElement> {
    public DiskElement(File file) {
        this.file = file;
        name = file.getName();
        long temp = file.lastModified();
        lastModified = new Date(temp);
        formattedDate = template.format(lastModified);
        sort = false;
    }

    public DiskElement(File file, boolean sort) {
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
        int elementCompare = name.compareTo(element.name);

        if (elementCompare == 0)
            return formattedDate.compareTo(element.formattedDate);

        else
            return elementCompare;
    }

    public void print() { print(0); }

    protected File file;
    protected String name;
    protected Date lastModified;
    protected SimpleDateFormat template = new SimpleDateFormat("yyyy-MM-dd");
    protected String formattedDate;
    protected boolean isDirectory;
    protected boolean isFile;
    protected boolean sort;

}
