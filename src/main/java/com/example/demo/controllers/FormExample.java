package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FormExample {

    ArrayList<Post> data = new ArrayList<>();
    int view= 0;

    @GetMapping(value = "/form")
    public String renderForm() {
        return "form";
    }


    @PostMapping(value = "/submit-post")
    public String createNewUser(Model model, @RequestParam("titel") String titel, @RequestParam("tekst") String tekst, @RequestParam("dato") String dato, @RequestParam("isActive") String erAktiv, @RequestParam("sprog") String sprog) {
        Post post = new Post(titel, tekst, dato, erAktiv, sprog);
        data.add(post);
        return new String("redirect:/success");
    }

    @GetMapping(value = "/success")
    public String renderSuccess(Model model) {

        model.addAttribute("titel", data.get(view).titel);
        model.addAttribute("tekst", data.get(view).tekst);
        model.addAttribute("dato", data.get(view).dato);
        model.addAttribute("erAktiv", data.get(view).erAktiv);
        model.addAttribute("sprog", data.get(view).yndlingsSprog);

        view++;
        return "success";
    }


    @GetMapping(value="/dashboard")
    public String renderDashboard(Model model) {
        model.addAttribute("posts", data);
        return "dashboard.html";
    }
}
