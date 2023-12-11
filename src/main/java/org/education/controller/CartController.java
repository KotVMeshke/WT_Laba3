package org.education.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.education.beans.dto.AddCartDTO;
import org.education.beans.dto.AddProductDTO;
import org.education.beans.dto.BanDTO;
import org.education.beans.dto.DiscountDTO;
import org.education.service.exception.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.education.beans.Attributes.RETURN_PAGE;

@Controller
@RequestMapping("/cart")
public class CartController {

    @GetMapping("/cartPage")
    public String signUpPage(@ModelAttribute("addCart") AddCartDTO addCart) {
        return "cart";
    }

    @GetMapping
    public String adminPage(HttpServletRequest request) throws ServletException {

//        try {
////            request.getSession().setAttribute("cart",userService.getUsers());
//        } catch (ServiceException e) {
//            throw new ServletException(e.getMessage());
//        }
//        request.getSession().setAttribute(RETURN_PAGE, request.getRequestURI());
//        return "admin_page";
        return "cart";
    }

}
