package kz.kaznu.api.telegram.repositories;

import kz.kaznu.api.telegram.models.TelegramChat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelegramChatDaoService {

    @Autowired
    private TelegramChatRepository telegramChatRepository;

    public List<TelegramChat> getAll(Integer limit, Integer offset) {
        return telegramChatRepository.findAll(limit, offset);
    }

    public void edit(Long countryId, Long id) {
        telegramChatRepository.edit(countryId, id);
    }

}
