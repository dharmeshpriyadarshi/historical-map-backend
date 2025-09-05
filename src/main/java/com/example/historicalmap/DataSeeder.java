package com.example.historicalmap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(StoryRepository repository) {
        return args -> {
            // Check if the database is empty before seeding
            if (repository.count() == 0) {
                System.out.println("Database is empty. Seeding initial data...");

                List<Story> stories = List.of(
                    new Story(
                        "Signing of the Magna Carta", 
                        "King John of England was forced to sign this charter, a foundational document for constitutional law.", 
                        1215, 
                        51.3833, -0.5667
                    ),
                    new Story(
                        "The Fall of Constantinople",
                        "The capture of the capital of the Byzantine Empire by the Ottoman Empire, marking the end of the Roman Empire.",
                        1453,
                        41.0138, 28.9784
                    ),
                    new Story(
                        "American Declaration of Independence",
                        "The Second Continental Congress adopted the Declaration of Independence in Philadelphia.",
                        1776,
                        39.9489, -75.1499
                    ),
                    new Story(
                        "Storming of the Bastille",
                        "A pivotal event in the French Revolution, symbolizing the end of the ancient régime.",
                        1789,
                        48.8530, 2.3694
                    ),
                    new Story(
                        "Battle of Waterloo",
                        "The final defeat of French military leader and emperor Napoleon Bonaparte.",
                        1815,
                        50.6788, 4.4045
                    ),
                    new Story(
                        "Wright Brothers' First Flight",
                        "Orville and Wilbur Wright made the first sustained, controlled, and powered heavier-than-air flight.",
                        1903,
                        35.9641, -75.6668
                    ),
                    new Story(
                        "D-Day: Normandy Landings",
                        "The largest seaborne invasion in history, beginning the liberation of France in World War II.",
                        1944,
                        49.3421, -0.4623
                    ),
                    new Story(
                        "First Human on the Moon",
                        "Apollo 11's Neil Armstrong became the first human to step onto the lunar surface.",
                        1969,
                        0.6742, 23.4729
                    ),
                    new Story(
                        "Invention of the World Wide Web",
                        "Tim Berners-Lee, a British scientist at CERN, invented the World Wide Web.",
                        1989,
                        46.2333, 6.0500
                    ),
                    new Story(
                        "Fall of the Berlin Wall",
                        "A pivotal event in world history that signaled the nearing end of the Cold War.",
                        1989,
                        52.5163, 13.3777
                    )
                );
                
                repository.saveAll(stories);
                System.out.println("Finished seeding " + stories.size() + " stories.");
            } else {
                System.out.println("Database is not empty. Skipping data seeding.");
            }
        };
    }
}
