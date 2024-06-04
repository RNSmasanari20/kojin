package com.example.kojin;

import com.example.kojin.form.LoginForm;
import com.example.kojin.form.SearchForm;
import com.example.kojin.service.genre.IGenreService;
import com.example.kojin.service.level.ILevelService;
import com.example.kojin.service.song.ISongsService;
import com.example.kojin.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KojinApplication {

    public static void main(String[] args) {
//		SpringApplication.run(KojinApplication.class, args);

        var context = SpringApplication.run(KojinApplication.class, args);

        IUserService userService = context.getBean(IUserService.class);
        ISongsService songsService = context.getBean(ISongsService.class);
        IGenreService genreService = context.getBean(IGenreService.class);
		ILevelService levelService = context.getBean(ILevelService.class);

//		LoginForm loginForm = new LoginForm();
//		loginForm.setLoginId("002");
//		loginForm.setPassword("pass02");
//		System.out.println(userService.findUser(loginForm));

//		var list = songsService.findAll();
//		list.forEach(System.out::println);

//        var list = songsService.findAllDate();
//        list.forEach(System.out::println);

// 		var list = genreService.findAll();
//		list.forEach(System.out::println);

//		var list = levelService.findAll();
//		list.forEach(System.out::println);

//		var list = songsService.findSong("ア");
//		list.forEach(System.out::println);
    }

}
