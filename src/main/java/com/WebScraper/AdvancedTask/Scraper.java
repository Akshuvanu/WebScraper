package com.WebScraper.AdvancedTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Scraper implements Runnable {

    private final String url;
    private final HeadlineRepository repository;

    @Autowired
    public Scraper(@Value("${scraper.url}") String url, HeadlineRepository repository) {
        this.url = url;
        this.repository = repository;
    }

    @Override
    public void run() {
        try {
            // Fetch the webpage
            Document doc = Jsoup.connect(url).get();

            // Select headlines (or any data you want to scrape)
            Elements headlines = doc.select("h3"); // Adjust the selector based on the site structure

            // Loop through and save each headline
            for (Element headline : headlines) {
                Headlines hl = new Headlines(headline.text(), url);
                repository.save(hl);
            }

            System.out.println("Headlines from " + url + " have been stored in the database.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
