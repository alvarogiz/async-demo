package com.gizalvaro.asyncdemo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostcodeCoordinatesResponse {

    private String alias;

    private String postcode;

    private String longitude;

    private String latitude;

}
