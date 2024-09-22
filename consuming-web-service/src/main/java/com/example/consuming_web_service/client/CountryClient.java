package com.example.consuming_web_service.client;

import com.example.consuming_web_service.wsdl.GetCountryRequest;
import com.example.consuming_web_service.wsdl.GetCountryResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Slf4j
public class CountryClient extends WebServiceGatewaySupport {

   public GetCountryResponse getCountry(String country) {

        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        log.info("Requesting location for " + country);

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8081/ws/countries", request,
                        new SoapActionCallback(
                                "http://example.com/producing_web_service/GetCountryRequest"));

        return response;
    }

}