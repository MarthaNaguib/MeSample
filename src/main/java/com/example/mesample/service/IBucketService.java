package com.example.mesample.service;


import com.example.mesample.entity.Bucket;

import java.util.List;

public interface IBucketService {
    List<Bucket> getAllBuckets();
    Bucket getBucketById(int id);
    boolean addBucket(Bucket bucket);
    void updateBucket(Bucket bucket);
    void deleteBucket(Bucket bucket);
}
