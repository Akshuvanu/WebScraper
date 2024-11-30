package com.WebScraper.AdvancedTask;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class WebScraperMultiThreaded implements CommandLineRunner {

    @Autowired
    private HeadlineRepository repository;

    @Override
    public void run(String... args) {
        String[] urls = {
                "https://www.bbc.com/news",
                "https://www.cnn.com",
                "https://www.nytimes.com"
        };

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (String url : urls) {
            Scraper scraper = new Scraper(url, repository);  // Pass repository here
            executor.execute(scraper);
        }

        executor.shutdown();
    }
}
