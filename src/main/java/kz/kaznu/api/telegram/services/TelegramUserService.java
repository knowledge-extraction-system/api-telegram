package kz.kaznu.api.telegram.services;

import kz.kaznu.api.telegram.models.TelegramUser;
import kz.kaznu.api.telegram.repositories.TelegramUserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelegramUserService {

    @Autowired
    TelegramUserDaoService telegramUserDaoService;

    public List<TelegramUser> getAll(Integer page, Integer size) {
        int limit = size;
        int offset = size * (page - 1);

        return telegramUserDaoService.getAll(limit, offset);
    }

    public void edit(TelegramUser request) {
        Long id = request.getId();
        Long countryId = request.getCountryId();
        String gender = request.getGender().toString();

        telegramUserDaoService.edit(countryId, gender, id);


    }

}
