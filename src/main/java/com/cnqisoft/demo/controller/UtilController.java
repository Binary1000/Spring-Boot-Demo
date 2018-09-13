package com.cnqisoft.demo.controller;

import com.cnqisoft.demo.util.PhoneValidCode;
import com.miaodiyun.httpApiDemo.IndustrySMS;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import com.cnqisoft.demo.util.VevifyUtil;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilController {

    @GetMapping("/code")
    public void code(HttpServletResponse response, HttpSession session) throws Exception {
        Object[] objs = VevifyUtil.generateImage();
        session.setAttribute("imageCode", objs[0]);
        BufferedImage image = (BufferedImage) objs[1];
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);
        os.close();
    }

    @PostMapping("/phone")
    public String phone(String phone, HttpSession session) {
        IndustrySMS.setTo(phone);
        String code = PhoneValidCode.generateCode();
        IndustrySMS.setSmsContent("【中启科技】您的验证码为" + code +"，请于10分钟内正确输入，如非本人操作，请忽略此短信。");
        String result = IndustrySMS.execute();
        session.setAttribute("phoneCode", code);
        return result;
    }

}
