package ssm.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ssm.model.UserInfo;
import ssm.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int userId = Integer.parseInt(request.getParameter("id"));
        UserInfo userInfo = this.userService.selectUser(userId);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(userInfo));
        response.getWriter().close();
    }

    @RequestMapping("getAllUser")
    public ModelAndView getAllUser(){
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> userInfos = userService.getAllUsers();
        //放入转发参数
        modelAndView.addObject(userInfos);
        //放入jsp路径
        modelAndView.setViewName("listUserInfos");
        return modelAndView;
    }
}
