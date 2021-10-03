package kz.kaznu.api.telegram.repositories;

import kz.kaznu.api.telegram.models.TelegramChat;
import kz.kaznu.api.telegram.models.rowmappers.TelegramChatRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TelegramChatRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TelegramChatRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    List<TelegramChat> findAll(Integer limit, Integer offset) {
        final String query = "select * from telegram_chat order by id limit ? offset ?";
        return jdbcTemplate.queryForObject(query, new Object[]{limit, offset}, new TelegramChatRowMapper());
    }

    void edit(Long countryId, Long id) {
        final String query = "update telegram_chat " +
                "set country_id = ? " +
                "where id = ?";

        jdbcTemplate.update(
                query,
                countryId, id);
    }

}
