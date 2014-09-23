package org.hhymarco.guahao.http;

import org.apache.commons.httpclient.HttpClient;

/**
 * Created by ghost on 14-9-22.
 */
public class HttpClientInstance {
    private static HttpClientInstance instance = null;
    private HttpClient client;
    private byte[] yzmRes=null;

    static{
        instance = new HttpClientInstance();
    }
    private HttpClientInstance(){
        client = new HttpClient();
    }
    public static HttpClientInstance getInstance(){
        return instance;
    }

    public void setClient(HttpClient client) {
        this.client = client;
    }

    public HttpClient getClient(){
        return this.client;
    }

    public byte[] getYzmRes() {
        return yzmRes;
    }

    public void setYzmRes(byte[] yzmRes) {
        this.yzmRes = yzmRes;
    }
}
