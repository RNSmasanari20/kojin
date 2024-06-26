package com.example.kojin;

import com.example.kojin.entity.UserRecord;
import com.example.kojin.form.EditForm;
import com.example.kojin.form.InsertForm;
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

//        InsertForm insertForm = new InsertForm();
//        insertForm.setId(6);
//        insertForm.setSong("テスト用ソング");
//        insertForm.setSongId("765");
//        System.out.println(songsService.insertSong(insertForm));

//        System.out.println(songsService.findById(2));

//        EditForm editForm = new EditForm();
//        editForm.setId(17);
//        editForm.setName("第六天魔王");
//        editForm.setSongId("765");
//        editForm.setGenreId(6);
//        System.out.println(songsService.updateSong(editForm));

//        System.out.println(songsService.deleteSong(17));

//        UserRecord userRecord = new UserRecord(2,"002","pass02","ユーザー2",2);
//        System.out.println(userService.updateUser(userRecord));
    }

}
