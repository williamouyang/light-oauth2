package com.networknt.oauth.service.handler;

import com.networknt.client.Client;
import com.networknt.server.Server;
import com.networknt.exception.ClientException;
import com.networknt.exception.ApiException;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
* Generated by swagger-codegen
*/
public class Oauth2ServicePutHandlerTest {
    @ClassRule
    public static TestServer server = TestServer.getInstance();

    static final Logger logger = LoggerFactory.getLogger(Oauth2ServicePutHandlerTest.class);

    @Test
    public void testOauth2ServicePutHandler() throws ClientException, ApiException, UnsupportedEncodingException {
        String service = "{\"serviceId\":\"AACT0002\",\"serviceType\":\"ms\",\"serviceName\":\"Retail Account\",\"serviceDesc\":\"Microservices for Retail Account\",\"scope\":\"act.r act.w\",\"ownerId\":\"admin\"}";

        CloseableHttpClient client = Client.getInstance().getSyncClient();
        HttpPut httpPut = new HttpPut("http://localhost:6883/oauth2/service");
        httpPut.setHeader("Content-type", "application/json");
        httpPut.setEntity(new StringEntity(service));

        try {
            CloseableHttpResponse response = client.execute(httpPut);
            logger.debug("StatusCode = " + response.getStatusLine().getStatusCode());
            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
            logger.debug("Response body = " + IOUtils.toString(response.getEntity().getContent(), "utf8"));
            //Assert.assertNotNull(IOUtils.toString(response.getEntity().getContent(), "utf8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
