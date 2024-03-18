package com.example.http.parser;

import com.example.http.IRequest;
import com.example.http.response.IResponse;
import com.example.http.result.IResult;

public interface IParse {

    IResult parseResponse(IRequest request, IResponse response);
}
