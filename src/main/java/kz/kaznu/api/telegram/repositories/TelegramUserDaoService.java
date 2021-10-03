package kz.kaznu.api.telegram.repositories;

import kz.kaznu.api.telegram.models.TelegramUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelegramUserDaoService {

    @Autowired
    private TelegramUserRepository telegramUserRepository;

    public List<TelegramUser> getAll(Integer limit, Integer offset) {
        return telegramUserRepository.findAll(limit, offset);
    }

    public void edit(Long countryId, String gender, Long id) {

        telegramUserRepository.edit(countryId, gender, id);
    }
}
