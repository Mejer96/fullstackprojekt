package com.example.projekt2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class indexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/show-wishlists")
    public String showWishlists(Model model) {
        Wishlist wishlist = new Wishlist("Wishlist", "test", "testID");
        model.addAttribute("wishlist", wishlist);

        return "show-wishlists";
    }

    @GetMapping("/wishlist/{id}")
    // pathvariable gør det muligt for os at hente en variable gennem en URL.
    // dermed kan vi få en værdi fra MySQL, indsætte dette i en URL, også bruge denne værdi
    // til at hente ønsker fra en ønskeliste dynamisk.
    public String showWishlist(@PathVariable("id") String id, Model model) {
        // test
        Wish wish = new Wish("testwish", 20, "testwishdescription", id);
        model.addAttribute("wish", wish);
        return "wishlist";
    }

    @GetMapping("/delete-wishlist/{id}")
    public String deleteWishlist(@PathVariable("id") String id, Model model) {
        return "show-wishlists";
    }


    @PostMapping("/create-wishlist")
    // gennem en HTML form kan vi hente user input fra vores hjemmeside og sende dem videre til vores backend.
    public String getWishlist(@RequestParam("name") String name, @RequestParam("description") String description) {
        return "create-wishlist";
    }

    @PostMapping("create-wish")
    public String createWish(@RequestParam("description") String description, @RequestParam("price") float price, @RequestParam("size") String size, @RequestParam("link") String link, HttpSession session) {

        return "create-wish";
    }

    @PostMapping("/join")
    public String createUser(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("repeatedPassword") String repeatedPassword, HttpSession session) {
        // test
        session.setAttribute("user", new User(username, password));
        return "redirect:/index";
    }

    @PostMapping("/sign-in")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return "redirect:/index";
    }

}
