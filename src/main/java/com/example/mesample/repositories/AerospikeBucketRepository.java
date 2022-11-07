package com.example.mesample.repositories;


import com.example.mesample.entity.Bucket;
import org.springframework.data.aerospike.repository.AerospikeRepository;

public interface AerospikeBucketRepository extends AerospikeRepository<Bucket, Integer> {
}

