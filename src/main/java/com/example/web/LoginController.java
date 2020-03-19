package com.example.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@RequestMapping(value = "/admin")
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login.html")
    public String loginPage(Model model) {
        model.addAttribute(new LoginInfo());
        return "login";
    }

    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request, LoginInfo loginInfo) {
        boolean isValidUser =
                userService.hasMatchUser(loginInfo.getUserName(),
                        loginInfo.getPassword());
        System.out.println(loginInfo.getUserName() + " " + loginInfo.getPassword());
        System.out.println(isValidUser);
        if (!isValidUser) {
            return new ModelAndView("login", "error", "用户名或密码错误。");
        } else {
            User user = userService.findUserByUserName(loginInfo
                    .getUserName());
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());
            userService.saveLog(user);
            request.getSession().setAttribute("user", user);
            return new ModelAndView("main");
        }
    }

    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public String loginCheck(
            @Valid LoginInfo loginInfo,
            Errors errors,
            RedirectAttributes data
    ) throws Exception {
        if (errors.hasErrors()) {
            return "login";
        }
        // redirect loginInfo
        data.addAttribute("userName", loginInfo.getUserName());
        data.addAttribute("password", loginInfo.getPassword());
        return "redirect:/admin/loginCheck.html";
    }

}
