package kz.kaznu.api.telegram.services;

import kz.kaznu.api.telegram.models.TelegramChat;
import kz.kaznu.api.telegram.repositories.TelegramChatDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelegramChatService {

    @Autowired
    TelegramChatDaoService telegramChatDaoService;

    public List<TelegramChat> getAll(Integer page, Integer size) {
        int limit = size;
        int offset = size * (page - 1);

        return telegramChatDaoService.getAll(limit, offset);
    }

    public void edit(TelegramChat request) {
        Long id = request.getId();
        Long countryId = request.getCountryId();

        telegramChatDaoService.edit(countryId, id);


    }

}
