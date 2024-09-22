package com.example.producing_web_service.endpoint;

import com.example.producing_web_service.GetCountryRequest;
import com.example.producing_web_service.GetCountryResponse;
import com.example.producing_web_service.repository.CountryRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@RequiredArgsConstructor
@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/producing_web_service";

    private final CountryRepository countryRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return response;
    }
}