# Web Scraper - Multi-Threaded News Scraping Tool

## Overview
This is a multi-threaded web scraper tool built with **Spring Boot** that scrapes headlines from major news websites. It uses **ExecutorService** to manage multiple threads and scrape news articles concurrently from the following websites:

- [BBC News](https://www.bbc.com/news)
- [CNN](https://www.cnn.com)
- [The New York Times](https://www.nytimes.com)

The scraper fetches headlines from each of these websites and stores them in a database using **Spring Data JPA**.

## Features
- **Multi-Threading**: Uses a fixed thread pool (`ExecutorService`) to scrape multiple websites concurrently.
- **Spring Boot Integration**: The scraper is integrated into a Spring Boot application as a command line runner.
- **Headlines Repository**: The scraped headlines are saved in a repository, and you can easily modify the repository to store data in your preferred database (e.g., MySQL, H2, etc.).

- 
- 
### Scraper Workflow
The scraper follows these steps:

1. **URLs Initialization**: 
   - The URLs to scrape (BBC News, CNN, and The New York Times) are defined in the code. Each of these websites is a target for the scraper to fetch headlines.

2. **ExecutorService**: 
   - The scraper uses a fixed thread pool (`ExecutorService`) to manage 3 threads. Each thread is responsible for scraping one URL concurrently. This approach helps speed up the process by allowing the scraper to fetch headlines from multiple websites at the same time.

3. **Scraping**: 
   - Each thread executes the `Scraper` class, which fetches and processes the headlines from the given URL. The class extracts the required data, such as article headlines, from the web page.

4. **Storage**: 
   - The scraped headlines are stored in a database using a **Spring Data JPA repository**. The repository allows easy integration with various databases (e.g., MySQL, H2, etc.) to persist the scraped data for future use or analysis.






