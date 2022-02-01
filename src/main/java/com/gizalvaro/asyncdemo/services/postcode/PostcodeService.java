package com.gizalvaro.asyncdemo.services.postcode;

import com.gizalvaro.asyncdemo.model.PostcodeApiResponse;
import com.gizalvaro.asyncdemo.model.PostcodeCoordinatesRequest;
import com.gizalvaro.asyncdemo.model.PostcodeCoordinatesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostcodeService {

    private static final String endpoint = "https://api.postcodes.io/postcodes/";

    @Autowired
    private RestTemplate restTemplate;

    public List<PostcodeCoordinatesResponse> getPostcodesCoordinates(List<PostcodeCoordinatesRequest> postcodeCoordinatesRequestList) {

        List<PostcodeCoordinatesResponse> postcodeCoordinatesResponseList = new ArrayList<>();

        postcodeCoordinatesRequestList.forEach(postcodeCoordinatesRequest -> {

            ResponseEntity<PostcodeApiResponse> postcodeApiResponse = restTemplate.getForEntity(endpoint + postcodeCoordinatesRequest.getPostcode(), PostcodeApiResponse.class);

            PostcodeCoordinatesResponse postcodeCoordinatesResponse = PostcodeCoordinatesResponse.builder()
                .alias(postcodeCoordinatesRequest.getAlias())
                .postcode(postcodeCoordinatesRequest.getPostcode())
                .latitude(postcodeApiResponse.getBody().getResult().getLatitude())
                .longitude(postcodeApiResponse.getBody().getResult().getLongitude())
                .build();

            postcodeCoordinatesResponseList.add(postcodeCoordinatesResponse);
        });
        return postcodeCoordinatesResponseList;
    }
}
