package com.microservices.order.stubs;

import com.github.tomakehurst.wiremock.client.WireMock;
//import com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;


public class InventoryClientStub {
    public static void stubInventoryCall(String skuCode, Integer quantity){
        stubFor(get(urlEqualTo("/inventory/get?skuCode="+skuCode+"&quantity="+quantity))
                .willReturn(WireMock.aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("true")));
    }
}
