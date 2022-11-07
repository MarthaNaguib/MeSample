package com.example.mesample;

import java.util.ArrayList;
import java.util.List;

import com.example.mesample.entity.Bucket;
import com.example.mesample.generated.*;
import com.example.mesample.service.IBucketService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class BucketEndpoint {
    private static final String NAMESPACE_URI = "http://www.concretepage.com/bucket-ws";
    @Autowired
    private IBucketService bucketService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBucketByIdRequest")
    @ResponsePayload
    public GetBucketByIdResponse getBucket(@RequestPayload GetBucketByIdRequest request) {
        GetBucketByIdResponse response = new GetBucketByIdResponse();
        BucketInfo bucketInfo = new BucketInfo();
        BeanUtils.copyProperties(bucketService.getBucketById(request.getId()), bucketInfo);
        response.setBucketInfo(bucketInfo);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllBucketsRequest")
    @ResponsePayload
    public GetAllBucketsResponse getAllBuckets() {
        GetAllBucketsResponse response = new GetAllBucketsResponse();
        List<BucketInfo> bucketInfoList = new ArrayList<>();
        List<Bucket> bucketList = bucketService.getAllBuckets();
        for (int i = 0; i < bucketList.size(); i++) {
            BucketInfo ob = new BucketInfo();
            BeanUtils.copyProperties(bucketList.get(i), ob);
            bucketInfoList.add(ob);
        }
        response.getBucketInfo().addAll(bucketInfoList);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addBucketRequest")
    @ResponsePayload
    public AddBucketResponse addBucket(@RequestPayload AddBucketRequest request) {
        AddBucketResponse response = new AddBucketResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        Bucket bucket = new Bucket();
        bucket.setId(request.getId());
        bucket.setType(request.getType());
        bucket.setCapacity(request.getCapacity());
        boolean flag = bucketService.addBucket(bucket);
        if (flag == false) {
            serviceStatus.setStatusCode("CONFLICT");
            serviceStatus.setMessage("Content Already Available");
            response.setServiceStatus(serviceStatus);
        } else {
            BucketInfo bucketInfo = new BucketInfo();
            BeanUtils.copyProperties(bucket, bucketInfo);
            response.setBucketInfo(bucketInfo);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Added Successfully");
            response.setServiceStatus(serviceStatus);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateBucketRequest")
    @ResponsePayload
    public UpdateBucketResponse updateBucket(@RequestPayload UpdateBucketRequest request) {
        Bucket bucket = new Bucket();
        BeanUtils.copyProperties(request.getBucketInfo(), bucket);
        bucketService.updateBucket(bucket);
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatusCode("SUCCESS");
        serviceStatus.setMessage("Content Updated Successfully");
        UpdateBucketResponse response = new UpdateBucketResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteBucketRequest")
    @ResponsePayload
    public DeleteBucketResponse deleteBucket(@RequestPayload DeleteBucketRequest request) {
        Bucket bucket = bucketService.getBucketById(request.getId());
        ServiceStatus serviceStatus = new ServiceStatus();
        if (bucket == null) {
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("Content Not Available");
        } else {
            bucketService.deleteBucket(bucket);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Deleted Successfully");
        }
        DeleteBucketResponse response = new DeleteBucketResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }
}