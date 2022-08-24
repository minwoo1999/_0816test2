package com.example._0816test2.Controller;


import com.example._0816test2.Dto.Item;
import com.example._0816test2.Dto.Member;
import com.example._0816test2.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class HelloController {


    @Autowired
    private MemberService memberService;



    @GetMapping("/test")
    public String hello(Model model) {
        model.addAttribute("data", "김민우");
        return "/index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser(Model model) {

        List<Member> member= memberService.getUserList();

        System.out.println(member);
        model.addAttribute("member",member);
        return "/index";
    }

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public String items(Model model) {
        List<Item> item=memberService.getItem();
        model.addAttribute("items",item);
        System.out.println(item);
        return "/items";
    }
    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
    public String item_detail(@PathVariable Integer itemId,HttpServletRequest request, Model model) {
        System.out.println(itemId);
        Item item=memberService.getItem_to_Item_id(itemId);
        System.out.println(item);
        model.addAttribute("item",item);
        return "/item";
    }



    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(HttpServletRequest request,@ModelAttribute Item item, Model model) {
        int ItemId=Integer.parseInt(request.getParameter("ItemId"));
        Item i=memberService.getItem_to_Item_id(ItemId);
        model.addAttribute("item",i);
        model.addAttribute("Item",new Item());
        return "/editForm";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit_post(@ModelAttribute Item item, Model model) {
        int result=memberService.update_Item(item);
        System.out.println(result);
        if(result!=0){
            return "redirect:/items";
        }else{
            return "edit";
        }


    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute("item",new Item());
        return "/addForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute Item item,Model model) {

        System.out.println(item.getItemname());
        System.out.println(item.getPrice());
        System.out.println(item.getQuantity());

        int result=memberService.insertItem(item);
        System.out.println(result);
        if(result==1){
            System.out.println("들어옴");
            return "redirect:/items";
        }
        else{
            return "/addForm";
        }

    }
}
