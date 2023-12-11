package org.education.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
//import org.education.service.UserService;
import jakarta.servlet.http.Part;
import jakarta.validation.Valid;
import org.education.beans.dto.AddProductDTO;
import org.education.beans.dto.BanDTO;
import org.education.beans.dto.DiscountDTO;
import org.education.beans.dto.SignUpDTO;
import org.education.service.ProductService;
import org.education.service.UserService;
import org.education.service.exception.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

import static org.education.beans.Attributes.RETURN_PAGE;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final ProductService productService;

    public AdminController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/users/delete/{idUser}")
    public String deleteUser(HttpServletRequest request, @PathVariable int idUser) throws ServletException {
        try {
            userService.deleteUser(idUser);
        } catch (ServiceException e) {
            throw new ServletException(e.getMessage());
        }
        return "redirect:/admin";
    }

    @GetMapping
    public String adminPage(HttpServletRequest request,
                            @ModelAttribute("ban") BanDTO ban,
                            @ModelAttribute("discountItem") DiscountDTO discount,
                            @ModelAttribute("addProd") AddProductDTO addProd
    ) throws ServletException {

        try {
            request.setAttribute("users",userService.getUsers());
        } catch (ServiceException e) {
            throw new ServletException(e.getMessage());
        }
        request.getSession().setAttribute(RETURN_PAGE, request.getRequestURI());
        return "admin_page";
    }

    @PostMapping("/addProd")
    public String addProd(@ModelAttribute("addProd") @Valid AddProductDTO addProd){
        try{
            InputStream inputStream = null;
//            Part filePart = addProd.getImage();
//            if (filePart != null) {
//                inputStream = filePart.getInputStream();
//            }
            productService.AddProduct(addProd.getNameP(),addProd.getPrice(),addProd.getCategory(),inputStream);
        }catch (ServiceException e){
            throw new RuntimeException(e);
        }
//        catch (IOException e){
//            throw new RuntimeException(e);
//        }
        return "redirect:/admin";
    }
    @PostMapping("/discount")
    public String discount(@ModelAttribute("discountItem") @Valid DiscountDTO discount){
        try{
            productService.SetDiscount(discount.getId(),discount.getDiscount());
        }catch (ServiceException e){
            throw new RuntimeException(e);
        }
        return "redirect:/admin";
    }
    @PostMapping("/ban")
    public String ban(@ModelAttribute("ban") @Valid BanDTO ban){

        try {
            userService.changeStatus(ban.getName());
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/admin";
    }
}
