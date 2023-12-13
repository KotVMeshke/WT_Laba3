package org.education.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.education.beans.CartItem;
import org.education.beans.ProductEnt;
import org.education.beans.dto.*;
import org.education.service.OrderService;
import org.education.service.exception.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.education.beans.Attributes.RETURN_PAGE;

@Controller
@RequestMapping("/cart")
public class CartController {

    private OrderService orderService;

    public CartController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/cartPage")
    public String cartPage(@ModelAttribute("addCart") AddCartDTO addCart) {
        return "cart";
    }

    @PostMapping("/updateCart")
    public String updateCart(HttpServletRequest request,
                             @ModelAttribute("updateCart") AddCartDTO updateCart) {

        List<CartItem> cart = (ArrayList<CartItem>) request.getSession().getAttribute("cart");
        for (CartItem object : cart) {
            if (object.getProduct().getProId() == Integer.parseInt(updateCart.getProdId2())) {
                object.amount = Integer.parseInt(updateCart.getProdAmount());
            }
        }

        // Updating the cart in the session
        request.getSession().removeAttribute("cart");
        request.getSession().setAttribute("cart", cart);

        return "cart";
    }
    @GetMapping("/orderPage")
    public String orderPage2(@ModelAttribute("order") OrderDTO order){
        return "orderPage";
    }

    @PostMapping("/removeCart")
    public String removeCart(HttpServletRequest request,
                             @ModelAttribute("addCart") AddCartDTO addCart,
                             @ModelAttribute("updateCart") AddCartDTO updateCart,
                             @ModelAttribute("order") OrderDTO order) {

            int productId = Integer.parseInt(addCart.getProdId());
            List<CartItem> cart = (List<CartItem>)request.getSession().getAttribute("cart");
            removeItemByProductId(cart,productId);
            request.getSession().setAttribute("cart", cart);

        return "cart";
    }

    @PostMapping("processOrder")
    public String processOrder(HttpServletRequest request,@ModelAttribute("order") OrderDTO order){
        try {

            List<CartItem> cart = (ArrayList<CartItem>) request.getSession().getAttribute("cart");
            orderService.createOrder(order.getAddress(),cart);

            request.getSession().removeAttribute("cart");
        } catch (ServiceException ex) {
            throw new RuntimeException(ex);
        }
        return "redirect:/";
    }
    public void removeItemByProductId(List<CartItem> cart, int productId) {
        Iterator<CartItem> iterator = cart.iterator();
        while (iterator.hasNext()) {
            CartItem cartItem = iterator.next();
            if (cartItem.getProduct().getProId() == productId) {
                iterator.remove();
                break;
            }
        }
    }
}
