package com.coderdot.dto;

import lombok.Data;

@Data
public class HelloResponse {

    String msg;

    public HelloResponse(String msg) {
        this.msg = msg;
    }
}
