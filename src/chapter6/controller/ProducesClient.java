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
        
        //1������Http Request(�ڲ�ʹ��HttpURLConnection)
        ClientHttpRequest request = new SimpleClientHttpRequestFactory().createRequest(new URI(url), HttpMethod.POST);
        //2�����ÿͻ��˿ɽ��ܵ�ý�����ͣ�����Ҫʲô���͵���Ӧ�����ݣ�
        request.getHeaders().set("Accept", "application/xml");
        
        //3���������󲢵õ���Ӧ
        ClientHttpResponse response = request.execute();
        
        //4���õ���Ӧ��ı��뷽ʽ
        Charset charset = response.getHeaders().getContentType().getCharSet();
        
        //5���õ���Ӧ�������        
        InputStream is = response.getBody();
        byte bytes[] = new byte[(int)response.getHeaders().getContentLength()];
        is.read(bytes);

        String xmlData = new String(bytes, charset);
        System.out.println("charset : " + charset + ", xml data : " + xmlData);
        
    }

    private static void jsonRequest() throws IOException, URISyntaxException {
        String url = "http://localhost:8080/MySpringMVC/produces";
        
        //1������Http Request(�ڲ�ʹ��HttpURLConnection)
        ClientHttpRequest request = new SimpleClientHttpRequestFactory().createRequest(new URI(url), HttpMethod.POST);
        
        //2�����ÿͻ��˿ɽ��ܵ�ý�����ͣ�����Ҫʲô���͵���Ӧ�����ݣ�
        request.getHeaders().set("Accept", "application/json");
        
        //3���������󲢵õ���Ӧ
        ClientHttpResponse response = request.execute();
        
        //4���õ���Ӧ��ı��뷽ʽ
        Charset charset = response.getHeaders().getContentType().getCharSet();
        
        //5���õ���Ӧ�������        
        InputStream is = response.getBody();
        byte bytes[] = new byte[(int)response.getHeaders().getContentLength()];
        is.read(bytes);

        String jsonData = new String(bytes, charset);
        System.out.println("charset : " + charset + ", json data : " + jsonData);
    }
}
