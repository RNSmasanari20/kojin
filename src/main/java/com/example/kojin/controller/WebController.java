package com.example.kojin.controller;

import com.example.kojin.entity.SongDateRecord;
import com.example.kojin.entity.UserRecord;
import com.example.kojin.form.LoginForm;
import com.example.kojin.service.genre.GenreService;
import com.example.kojin.service.level.LevelService;
import com.example.kojin.service.song.SongService;
import com.example.kojin.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    UserService userService;

    @Autowired
    SongService songService;

    @Autowired
    GenreService genreService;

    @Autowired
    LevelService levelService;

    @Autowired
    private HttpSession session;

    @GetMapping("/login")
    public String login(@ModelAttribute("login")LoginForm loginForm){
        return "login";
    }

    @PostMapping("login")
    public String login(@Validated @ModelAttribute("login")LoginForm loginForm, BindingResult bindingResult, Model model){
        UserRecord userRecord = userService.findUser(loginForm);
        if (bindingResult.hasErrors()){
            return "login";
        }
        if (userRecord == null){
            model.addAttribute("message", "IDまたはパスワードが不正です");
            return "login";
        }
        session.setAttribute("user", userRecord);
        return "redirect:/menu";
    }

//    @GetMapping("/menu")
//    public String menu(Model model){
//        if(session.getAttribute("user") == null){
//            return "redirect:/login";
//        }
//        model.addAttribute("songs",songService.findAllDate());
//        model.addAttribute("levels",levelService.findAll());
//        return "menu";
//    }

    @GetMapping("/menu")
    public String menu(@RequestParam(name = "keyword", defaultValue = "")String search,
                       Model model){
        if(session.getAttribute("user") == null){
            return "redirect:/login";
        }
        if (search.isEmpty()) {
            model.addAttribute("songs", songService.findAllDate());
            model.addAttribute("levels", levelService.findAll());
            return "menu";
        }
        model.addAttribute("songs", songService.findSong(search));
        model.addAttribute("levels", levelService.findAll());
        return "menu";
    }
    @PostMapping("/logout")
    public String logoutAuto() {
        session.invalidate();
        return "redirect:/login";
    }

}
