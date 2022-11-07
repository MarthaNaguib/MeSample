package com.example.mesample.service;
import com.example.mesample.entity.Bucket;
import com.example.mesample.repositories.AerospikeBucketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BucketService implements IBucketService {
    @Autowired
    private AerospikeBucketRepository aerospikeBucketRepository;

    @Override
    public Bucket getBucketById(int id) {
        Bucket obj = aerospikeBucketRepository.findById(id).get();
        return obj;
    }
    @Override
    public List<Bucket> getAllBuckets(){
        List<Bucket> list = new ArrayList<>();
        aerospikeBucketRepository.findAll().forEach(e -> list.add(e));
        return list;
    }
    @Override
    public boolean addBucket(Bucket bucket){
        aerospikeBucketRepository.save(bucket);
        return true;
    }

    @Override
    public void updateBucket(Bucket bucket) {
        aerospikeBucketRepository.save(bucket);
    }
    @Override
    public void deleteBucket(Bucket bucket) {
        aerospikeBucketRepository.delete(bucket);
    }
}
