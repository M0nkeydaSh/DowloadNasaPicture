package com.company;

import java.util.Scanner;

public class NasaPictureShowroom {
    public void show(){
        NasaRandomPictureFinder randomPictureFinder =new NasaRandomPictureFinder();
        System.out.println("Поиск картинок: ");
        NasaPictureInfo [] pictures = randomPictureFinder.findRandomPictures(5);
        System.out.println("Картинки найдены: ");
        for (int i = 0; i < pictures.length; i++) {
            System.out.println((i+1) + ": " + pictures[i]);
        }
        System.out.println("Какую картинку вы хотите увидеть?");
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();
        NasaPictureDownloader downloader = new NasaPictureDownloader();
        downloader.downloaderAndOpen(pictures[answer-1]);
    }
}
