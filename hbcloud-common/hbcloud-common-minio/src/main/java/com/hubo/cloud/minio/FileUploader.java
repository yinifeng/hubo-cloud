package com.hubo.cloud.minio;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import io.minio.errors.MinioException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class FileUploader {
    public static void main(String[] args)
            throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            // Create a minioClient with the MinIO server playground, its access key and secret key.
            MinioClient minioClient =
                    MinioClient.builder()
                            .endpoint("http://192.168.123.201:9002")
                            .credentials("YSWXRJO1RBLOG73S0J98", "JW8AsA6HqQ9aTozlJ1UHV7izwqu+7ewljc0kYbTA")
                            .build();

            // Make 'asiatrip' bucket if not exist.
            boolean found =
                    minioClient.bucketExists(BucketExistsArgs.builder().bucket("hobart-test").build());
            if (!found) {
                // Make a new bucket called 'asiatrip'.
                minioClient.makeBucket(MakeBucketArgs.builder().bucket("hobart-test").build());
            } else {
                System.out.println("Bucket 'hobart-test' already exists.");
            }

            // Upload '/home/user/Photos/asiaphotos.zip' as object name 'asiaphotos-2015.zip' to bucket
            // 'asiatrip'.
            minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket("hobart-test")
                            .object("个人参与方-批量上传模板.xlsx")
                            .filename("D:\\test\\个人参与方-批量上传模板.xlsx")
                            .build());
            System.out.println(
                    "'D:\\test\\个人参与方-批量上传模板.xlsx' is successfully uploaded as "
                            + "object '个人参与方-批量上传模板.xlsx' to bucket 'hobart-test'.");
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
            System.out.println("HTTP trace: " + e.httpTrace());
        }
    }
}

