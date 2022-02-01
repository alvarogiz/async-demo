package com.gizalvaro.asyncdemo.controller;

import com.gizalvaro.asyncdemo.model.PostcodeCoordinatesRequest;
import com.gizalvaro.asyncdemo.model.PostcodeCoordinatesResponse;
import com.gizalvaro.asyncdemo.services.postcode.PostcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/async/demo")
public class AsyncDemoController {

    @Autowired
    private PostcodeService postcodeService;

    @PostMapping("/coordinates")
    public List<PostcodeCoordinatesResponse> getPostCodeCoordinates(@RequestBody List<PostcodeCoordinatesRequest> postcodeCoordinatesRequestList) {
        return postcodeService.getPostcodesCoordinates(postcodeCoordinatesRequestList);
    }

}
