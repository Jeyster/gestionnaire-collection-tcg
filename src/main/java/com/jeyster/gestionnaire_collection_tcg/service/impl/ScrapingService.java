package com.jeyster.gestionnaire_collection_tcg.service.impl;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Getter
public class ScrapingService {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    private volatile boolean running = false;
    private final List<String> logs = new CopyOnWriteArrayList<>();

    public void startScraping() {
        if (running) return;

        running = true;
        logs.clear();

        executor.submit(() -> {
            try {
                String os = System.getProperty("os.name").toLowerCase();

                ProcessBuilder pb;

                if (os.contains("win")) {
                    pb = new ProcessBuilder("cmd.exe", "/c", "start-scraper-CM.bat");
                } else {
                    pb = new ProcessBuilder("bash", "/home/jeyste4/Bureau/ProjetsPerso/gestionnaire-collection-tcg/src/main/resources/start-scraper-CM.sh");
                }

                pb.redirectErrorStream(true);

                Process process = pb.start();

                try (BufferedReader reader =
                             new BufferedReader(new InputStreamReader(process.getInputStream()))) {

                    String line;
                    while ((line = reader.readLine()) != null) {
                        logs.add(line);
                    }
                }

                process.waitFor();
            } catch (Exception e) {
                logs.add("❌ Erreur : " + e.getMessage());
            } finally {
                running = false;
            }
        });
    }

}
