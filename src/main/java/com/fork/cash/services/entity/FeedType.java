package com.fork.cash.services.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FeedType {

    @Id
    private Integer feed_type_id;
    private String feed_type_cd;
    private Integer data_source_id;

    public Integer getFeed_type_id() {
        return feed_type_id;
    }

    public void setFeed_type_id(Integer feed_type_id) {
        this.feed_type_id = feed_type_id;
    }

    public String getFeed_type_cd() {
        return feed_type_cd;
    }

    public void setFeed_type_cd(String feed_type_cd) {
        this.feed_type_cd = feed_type_cd;
    }

    public Integer getData_source_id() {
        return data_source_id;
    }

    public void setData_source_id(Integer data_source_id) {
        this.data_source_id = data_source_id;
    }
}
