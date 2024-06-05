package com.example.kojin.controller;

import com.example.kojin.entity.SongDateRecord;
import com.example.kojin.entity.UserRecord;
import com.example.kojin.form.EditForm;
import com.example.kojin.form.InsertForm;
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

    String successMessage;

    @GetMapping("/login")
    public String login(@ModelAttribute("login") LoginForm loginForm) {
        return "login";
    }

    @PostMapping("login")
    public String login(@Validated @ModelAttribute("login") LoginForm loginForm, BindingResult bindingResult, Model model) {
        UserRecord userRecord = userService.findUser(loginForm);
        if (bindingResult.hasErrors()) {
            return "login";
        }
        if (userRecord == null) {
            model.addAttribute("message", "IDまたはパスワードが不正です");
            return "login";
        }
        session.setAttribute("user", userRecord);
        return "redirect:/menu";
    }

    @GetMapping("/menu")
    public String menu(@RequestParam(name = "keyword", defaultValue = "") String search,
                       Model model) {
        if (session.getAttribute("user") == null) {
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
    public String logout() {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/insert")
    public String insert(@ModelAttribute("insert") InsertForm insertForm, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        model.addAttribute("genres", genreService.findAll());
        return "insert";
    }

    @PostMapping("/insert")
    public String insertPost(@Validated @ModelAttribute("insert") InsertForm insertForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("genres", genreService.findAll());
            return "insert";
        }
        int isInsert = songService.insertSong(insertForm);
        if (isInsert == -1) {
            model.addAttribute("message", "曲IDが重複しています");
        } else if (isInsert == 0) {
            model.addAttribute("message", "追加に失敗しました");
        } else {
            successMessage = "追加に成功しました";
        }
        return "redirect:/success";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") int id, @ModelAttribute("edit") EditForm editForm, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        model.addAttribute("edit", songService.findById(id));
        model.addAttribute("genres", genreService.findAll());
        return "detail";
    }

    @RequestMapping(value = "/detail/{id}", params = "update", method = RequestMethod.POST)
    public String update(@PathVariable("id") int id, @Validated @ModelAttribute("edit") EditForm editForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", editForm);
            model.addAttribute("genres", genreService.findAll());
            return "detail";
        }
        int isUpdate = songService.updateSong(editForm);
        if (isUpdate == -1) {
            model.addAttribute("message", "曲IDが重複しています");
            model.addAttribute("edit", editForm);
            model.addAttribute("genres", genreService.findAll());
            return "detail";
        } else if (isUpdate == 0) {
            model.addAttribute("message", "更新に失敗しました");
            model.addAttribute("edit", songService.findById(id));
            model.addAttribute("genres", genreService.findAll());
            return "detail";
        }
        successMessage = "更新に成功しました";
        return "redirect:/success";
    }

    @RequestMapping(value = "/detail/{id}", params = "delete", method = RequestMethod.POST)
    public String delete(@PathVariable("id") int id, Model model) {
        int isDelete = songService.deleteSong(id);
        if (isDelete == 0) {
            model.addAttribute("message", "削除に失敗しました");
            model.addAttribute("edit", songService.findById(id));
            model.addAttribute("genres", genreService.findAll());
            return "detail";
        }
        successMessage = "削除に成功しました";
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String success(Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        String message = successMessage;
        successMessage = "";
        model.addAttribute("message", message);
        return "success";
    }

}
