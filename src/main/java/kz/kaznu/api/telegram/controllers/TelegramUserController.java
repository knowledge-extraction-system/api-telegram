package kz.kaznu.api.telegram.controllers;

import kz.kaznu.api.telegram.models.TelegramUser;
import kz.kaznu.api.telegram.services.TelegramUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class TelegramUserController {

    @Autowired
    TelegramUserService telegramUserService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<TelegramUser> getAllTelegramUsers(@RequestParam("page") Integer page,
                                                  @RequestParam("size") Integer size) throws IOException {

        return telegramUserService.getAll(page, size);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public void edit(TelegramUser request){
        telegramUserService.edit(request);
    }

}
