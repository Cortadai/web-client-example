package com.webclient.springboot.stores.client;

import com.webclient.springboot.stores.wsdl.GetStoreRequest;
import com.webclient.springboot.stores.wsdl.GetStoreResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class StoreClient extends WebServiceGatewaySupport {

    public GetStoreResponse getStore(Integer id) {

        GetStoreRequest request = new GetStoreRequest();
        request.setId(id);

        System.out.println("Requesting location for " + id);

        GetStoreResponse response = (GetStoreResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/stores", request,
                        new SoapActionCallback(
                                "http://webservice.com/springboot/GetStoreRequest"));

        return response;
    }

    public GetStoreResponse getStoreAlt(Integer id){
        GetStoreRequest request = new GetStoreRequest();
        request.setId(id);

        return (GetStoreResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

}