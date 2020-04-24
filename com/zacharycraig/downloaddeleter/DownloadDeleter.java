package com.zacharycraig.downloaddeleter;
/*
 ************************************************
 * Name: DownloadDeleter.java
 * Author: Zachary Brandenburg
 * Date: 22 04 2020
 ************************************************
 * Description: Delete all downloads
 * Last Updated: 22 04 2020
 ************************************************
 */


import java.io.File;

public class DownloadDeleter {

    public static void main(String[] args) {
        String home = System.getProperty("user.home");
        File downloadPath = new File(home + "/Downloads/");
        recursiveDelete(downloadPath);
    }

    private static void recursiveDelete(File downloadPath) {
        String[] filesNames;

        try {
            filesNames = downloadPath.list();
            if (filesNames != null) {
                for (String s : filesNames) {
                    File currentFile = new File(downloadPath.getPath(), s);
                    if (currentFile.isDirectory()) {
                        recursiveDelete(currentFile);
                    }
                    System.out.println("Deleting: " + currentFile);
                    if (currentFile.delete()) {
                        System.out.println("Deleted: " + currentFile);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
