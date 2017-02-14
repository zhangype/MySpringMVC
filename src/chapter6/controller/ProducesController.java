package chapter6.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProducesController {
    @RequestMapping(value = "/produces", produces = "application/json")
    public void response2(HttpServletResponse response) throws IOException {
        //1����ʾ��Ӧ�����������ݵ�ý������Ϊjson��ʽ���ұ���Ϊutf-8(�ͻ���Ӧ����utf-8����)
        response.setContentType("application/json;charset=utf-8");
        //2��д����Ӧ������
        String jsonData = "{\"username\":\"zhang\", \"password\":\"123\"}";
        response.getWriter().write(jsonData);
    }
    
    @RequestMapping(value = "/produces", produces = "application/xml")
    public void response3(HttpServletResponse response) throws IOException {
        //1����ʾ��Ӧ�����������ݵ�ý������Ϊxml��ʽ���ұ���Ϊutf-8(�ͻ���Ӧ����utf-8����)
        response.setContentType("application/xml;charset=utf-8");
        //2��д����Ӧ������
        String xmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        xmlData += "<user><username>zhang</username><password>123</password></user>";
        response.getWriter().write(xmlData);
    }
}
