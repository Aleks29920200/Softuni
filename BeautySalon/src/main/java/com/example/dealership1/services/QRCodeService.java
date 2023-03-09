package com.example.dealership1.services;

import com.example.dealership1.util.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.stream.IntStream;

@Service
public class QRCodeService {
    private static String CONTENT="";
   private UserServiceImpl userService;
   private LoggedUser loggedUser;
    private Random RANDOM = new Random();
    public QRCodeService(UserServiceImpl userService, LoggedUser loggedUser) {
        this.userService = userService;
        this.loggedUser=loggedUser;
    }

    public String qrCodeContent(){
        if(CONTENT.equals("")){
            IntStream.range(0, 10).mapToLong(i -> RANDOM.nextLong(30)).mapToObj(String::valueOf).forEach(number -> CONTENT = CONTENT.concat(number));
            IntStream.range(0, 15).forEach(i -> {
                char c = (char) (RANDOM.nextInt(26) + 'a');
                String letter = String.valueOf(c);
                CONTENT = CONTENT.concat(letter);
            });
        }
        return CONTENT;
    }
}
