package com.fork.cash.services.repository;

import com.fork.cash.services.entity.FeedType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FeedTypeRepo extends JpaRepository<FeedType, Long> {

    @Query(value = "select  distinct feed_type_id, feed_type_cd, data_source_id from cru.feed_type", nativeQuery = true)
    Collection<FeedType> getProjectionLevels();


}
