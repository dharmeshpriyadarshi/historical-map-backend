package com.example.historicalmap;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// The main change is here: we extend MongoRepository instead of JpaRepository.
// We also use <Story, String> because the ID for a MongoDB document is a String.
public interface StoryRepository extends MongoRepository<Story, String> {

    // This custom query method still works perfectly without any changes!
    // Spring Data's magic will automatically implement this for MongoDB.
    List<Story> findByEra(int era);
}

