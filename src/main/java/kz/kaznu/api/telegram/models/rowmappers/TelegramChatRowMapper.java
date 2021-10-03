package kz.kaznu.api.telegram.models.rowmappers;

import kz.kaznu.api.telegram.models.TelegramChat;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TelegramChatRowMapper implements RowMapper<List<TelegramChat>> {

    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

    @Override
    public List<TelegramChat> mapRow(ResultSet rs, int rowNumber) throws SQLException {
        List<TelegramChat> telegramChats = new ArrayList<>();

        telegramChats.add(extractInfo(rs));
        while(rs.next()) {
            telegramChats.add(extractInfo(rs));
        }

        return telegramChats;
    }

    private TelegramChat extractInfo(ResultSet rs) throws SQLException {
        TelegramChat telegramChat = new TelegramChat();
        telegramChat.setId(rs.getLong("id"));
        telegramChat.setType(rs.getString("type"));
        telegramChat.setTitle(rs.getString("title"));
        telegramChat.setDate(rs.getTimestamp("date").toLocalDateTime());
        telegramChat.setIsChannel(rs.getBoolean("is_channel"));
        telegramChat.setCountryId(rs.getLong("country_id"));

        return telegramChat;
    }
}
