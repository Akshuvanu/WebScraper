package com.WebScraper.AdvancedTask.Controller;

import com.WebScraper.AdvancedTask.HeadlineRepository;
import com.WebScraper.AdvancedTask.Headlines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/headlines")
public class HeadlinesController {

    private final HeadlineRepository headlineRepository;

    @Autowired
    public HeadlinesController(HeadlineRepository headlineRepository) {
        this.headlineRepository = headlineRepository;
    }

    @GetMapping
    public List<Headlines> getAllHeadlines() {
        return headlineRepository.findAll();
    }
}