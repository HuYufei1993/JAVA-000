package io.transwarp.twmw.tag.service.impl;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

/**
 * httpclientDemo
 * @author hyf
 * @date 2020-10-28
 */
public class HttpClientDemo {

    public static void main(String[] args){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("http://localhost:8080");
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            System.out.println("returncode :" + response.getStatusLine().getStatusCode());
            HttpEntity entity = response.getEntity();
            System.out.println("returnmsg :" + entity.getContent().toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
