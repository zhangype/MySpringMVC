package chapter6.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConsumesController {
    //Content-Type �������������
    @RequestMapping(value = "/consumes", consumes = {"application/json"})
    public String test(HttpServletRequest request) throws IOException {
        //��ʾ���������������Ϊjson����
        InputStream is = request.getInputStream();
        byte bytes[] = new byte[request.getContentLength()];
        is.read(bytes);
        //�õ������е����������ݣ���CharacterEncoding���룩
        //�˴��õ����ݺ������ͨ����json-libת��Ϊ��������
        String jsonStr = new String(bytes, request.getCharacterEncoding());
        System.out.println("json data��" + jsonStr);
        return "success";
    }
}
