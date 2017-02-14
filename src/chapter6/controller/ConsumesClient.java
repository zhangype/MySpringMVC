package chapter6.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

public class ConsumesClient {
    
    public static void main(String[] args) throws IOException, URISyntaxException {
        //请求的地址
//        String url = "http://localhost:8080/MySpringMVC/consumes";
        String url = "http://localhost:8080/MySpringMVC/method/param/commandObject?username=zhang";

        //1、创建Http Request(内部使用HttpURLConnection)
        ClientHttpRequest request = new SimpleClientHttpRequestFactory().createRequest(new URI(url), HttpMethod.POST);
        
        //2、设置请求头的内容类型头和内容编码（GBK）
        request.getHeaders().set("Content-Type", "application/json;charset=gbk");
        
        //3、以GBK编码写出响应内容体
        String jsonData = "{\"username\":\"zhang\", \"password\":\"123\"}";
        request.getBody().write(jsonData.getBytes("gbk"));
        
        //4、发送请求并得到响应
        ClientHttpResponse response = request.execute();
        System.out.println(response.getStatusCode());
    }
}
