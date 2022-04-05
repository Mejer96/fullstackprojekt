package com.example.projekt2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class indexController {
    Repository repository = new Repository();
    UserService userService = new UserService(repository);
    WishlistService wishlistService = new WishlistService(repository);

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/show-wishlists")
    public String showWishlists(Model model, HttpSession httpSession) throws SQLException {
        // henter user objekt fra vores session. Dette objekt bliver gemt i sessionen ved login.
        User user = (User) httpSession.getAttribute("user");
        // henter wishlists fra databasen, som er tilknyttet til brugerens ID.
        ArrayList<Wishlist> wishlists = wishlistService.getWishlist(user.getUser_ID());
        // arraylisten gemmes i model objektet, så det kan vises i thymeleaf template.
        model.addAttribute("wishlists", wishlists);
        return "show-wishlists";
    }

    @GetMapping("/wishlist/{wishlist-id}")
    // pathvariable gør det muligt for os at hente en variable gennem en URL.
    // dermed kan vi få en værdi fra MySQL, indsætte dette i en URL, også bruge denne værdi
    // til at hente ønsker fra en ønskeliste dynamisk.
    public String showWishlistItems(@PathVariable("wishlist-id") String wishlistID, Model model) throws SQLException {
        // test
        // henter ønskelistens indhold i databasen ud fra wishlist-id. wishlist id får vi fra vores thymeleaf template gennem en th:href url.
        ArrayList<Wish> wishlistItems = wishlistService.getWishlistItems(wishlistID);
        model.addAttribute("wishlistItems", wishlistItems);
        return "wishlist";
    }

    @GetMapping("/delete-wishlist/{wishlist-id}")
    public String deleteWishlist(@PathVariable("wishlist-id") String id, Model model) {
        // WIP
        return "show-wishlists";
    }


    @PostMapping("/create-wishlist")
    // gennem en HTML form kan vi hente user input fra vores hjemmeside og sende dem videre til vores backend.
    public String getWishlist(@RequestParam("name") String name, @RequestParam("description") String description) {
        // WIP
        return "create-wishlist";
    }

    @PostMapping("create-wish")
    public String createWish(@RequestParam("description") String description, @RequestParam("price") String price, HttpSession session) {
        // WIP
        return "create-wish";
    }

    @PostMapping("/join")
    public String createUser(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("repeatedPassword") String repeatedPassword, HttpSession session) throws SQLException {
        User user = null;
        // WIP
        // hvis metoden returner true, så oprettes en ny bruger i databasen.
        if (userService.createUser(username, password)) {
            user = userService.userLogin(username, password);
        }
        // user objektet gemmes i en session.
        session.setAttribute("user", user);
        return "redirect:/index";
    }

    @PostMapping("/sign-in")
    public String getLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession httpSession) throws SQLException {
        // user findes i databasen ud fra username og password
        // evt et if statement for at tjekke om, der er et match også returnere en fejl-side.html fil?
        User user = userService.userLogin(username, password);
        // user objekt gemmes i en session.
        httpSession.setAttribute("user", user);
        return "redirect:/index";
    }

    @GetMapping("/sign-in")
    public String signIn() {
        return "sign-in";
    }

}
