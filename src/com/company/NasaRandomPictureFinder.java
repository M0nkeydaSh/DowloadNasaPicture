package com.company;


import com.company.utils.PageDownloader;
import com.company.utils.RandomDateGenerator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NasaRandomPictureFinder {
    public NasaPictureInfo[] findRandomPictures(int count) {
    NasaPictureInfo [] arr = new NasaPictureInfo[count];
        for (int i = 0; i < count; i++) {
            String date = getRandomDateStr();
            String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&date=" + date;
            PageDownloader downloader = new PageDownloader();
            String page = downloader.downloadWebPage(url);

            String explanation = getTagValue(page, "explanation");
            String hdUrl = getTagValue(page, "hdurl");
            String mediaType = getTagValue(page, "media_type");
            String title = getTagValue(page, "title");
            NasaPictureInfo info = new NasaPictureInfo(title, date, explanation, hdUrl, mediaType);
            arr[i] = info;
        }


return arr;
    }

    private String getTagValue (String page, String tagName){
      int begin =   page.indexOf('"' + tagName + '"') + 4 + tagName.length();
      int end = page.indexOf('"'  , begin);
        return page.substring(begin, end);
    }

private String getRandomDateStr(){
    RandomDateGenerator randomDateGenerator = new RandomDateGenerator();
    LocalDate randomDate = randomDateGenerator.getRandomDate(1995, 2021);
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return randomDate.format(format);
}

    }



