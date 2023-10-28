package com.coderdot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"status","version","apiName","data", "errorCode", "errorMsg"})
public class BaseResponse {

   @JsonProperty("version")
    public  String version;

   @JsonProperty("apiName")
    public String apiName;

    @JsonProperty("data")
    public Object data;

    @JsonProperty("errorCode")
    public int errorCode;

    @JsonProperty("status")
    public boolean status;

    @JsonProperty("errorMsg")
    public String errorMsg = "";

}
