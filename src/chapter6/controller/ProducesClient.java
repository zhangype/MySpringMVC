package chapter6.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

public class ProducesClient {
public static void main(String[] args) throws IOException, URISyntaxException {
        jsonRequest();
        xmlRequest();
    }

    private static void xmlRequest() throws IOException, URISyntaxException {
        String url = "http://localhost:8080/MySpringMVC/produces";
        
        //1、创建Http Request(内部使用HttpURLConnection)
        ClientHttpRequest request = new SimpleClientHttpRequestFactory().createRequest(new URI(url), HttpMethod.POST);
        //2、设置客户端可接受的媒体类型（即需要什么类型的响应体数据）
        request.getHeaders().set("Accept", "application/xml");
        
        //3、发送请求并得到响应
        ClientHttpResponse response = request.execute();
        
        //4、得到响应体的编码方式
        Charset charset = response.getHeaders().getContentType().getCharSet();
        
        //5、得到响应体的内容        
        InputStream is = response.getBody();
        byte bytes[] = new byte[(int)response.getHeaders().getContentLength()];
        is.read(bytes);

        String xmlData = new String(bytes, charset);
        System.out.println("charset : " + charset + ", xml data : " + xmlData);
        
    }

    private static void jsonRequest() throws IOException, URISyntaxException {
        String url = "http://localhost:8080/MySpringMVC/produces";
        
        //1、创建Http Request(内部使用HttpURLConnection)
        ClientHttpRequest request = new SimpleClientHttpRequestFactory().createRequest(new URI(url), HttpMethod.POST);
        
        //2、设置客户端可接受的媒体类型（即需要什么类型的响应体数据）
        request.getHeaders().set("Accept", "application/json");
        
        //3、发送请求并得到响应
        ClientHttpResponse response = request.execute();
        
        //4、得到响应体的编码方式
        Charset charset = response.getHeaders().getContentType().getCharSet();
        
        //5、得到响应体的内容        
        InputStream is = response.getBody();
        byte bytes[] = new byte[(int)response.getHeaders().getContentLength()];
        is.read(bytes);

        String jsonData = new String(bytes, charset);
        System.out.println("charset : " + charset + ", json data : " + jsonData);
    }
}
