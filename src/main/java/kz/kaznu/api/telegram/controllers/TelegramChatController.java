package kz.kaznu.api.telegram.controllers;

import kz.kaznu.api.telegram.services.TelegramChatService;
import kz.kaznu.api.telegram.models.TelegramChat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/chat")
public class TelegramChatController {

    @Autowired
    TelegramChatService telegramChatService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<TelegramChat> getAllTelegramChats(@RequestParam("page") Integer page,
                                                  @RequestParam("size") Integer size) throws IOException {

        return telegramChatService.getAll(page, size);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public void edit(TelegramChat request){
        telegramChatService.edit(request);
    }

}
