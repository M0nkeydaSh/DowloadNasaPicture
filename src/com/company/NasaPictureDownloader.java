package com.company;

import java.awt.Desktop;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NasaPictureDownloader {
    public void downloaderAndOpen (NasaPictureInfo info){
        System.out.println("Will download " + info + "...");
        System.out.println("Description: " + info.getPrettyExplanation());
        try (InputStream in  = new URL(info.fileUrl).openStream()){
            String[] arr = info.fileUrl.split("\\.");
            String fileExtension = arr[arr.length-1];
            String fileName = info.title + "." + fileExtension;
            Files.copy (in, Paths.get(fileName));
            System.out.println("Файл сохранен! ");
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(fileName));
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
