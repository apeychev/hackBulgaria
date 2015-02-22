package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;

/**
 * Created by aleksandar.peychev on 22.2.2015 г..
 */
public class listDuplicationgFiles {

    public static void main(String[] args) throws IOException {
        ArrayList<File> files = new ArrayList<File>();
        listf("Please enter Directory here",files);

        for (int i = 0; i < files.size(); i++) {
            System.out.println("File " + files.get(i).getName());
        }

    }

    public static void listf(String directoryName, ArrayList<File> files) throws IOException {
        File directory = new File(directoryName);
        // get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                files.add(file);
            } else if (file.isDirectory()) {
                listf(file.getAbsolutePath(), files);
            }
        }
        //remove duplicate files
        for (int i = 0; i < files.size()-1; i++) {
            for(int x = i+1; x < files.size(); x++) {
                File file1 = new File(files.get(i).getAbsolutePath());
                File file2 = new File(files.get(x).getAbsolutePath());
                if (org.apache.commons.io.FileUtils.contentEquals(file1, file2)) {
                    files.remove(files.get(i));
                }
            }
        }
    }
}
