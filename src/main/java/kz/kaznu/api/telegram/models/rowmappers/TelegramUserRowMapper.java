package kz.kaznu.api.telegram.models.rowmappers;

import kz.kaznu.api.telegram.models.TelegramUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelegramUserRowMapper implements RowMapper<List<TelegramUser>> {

    @Override
    public List<TelegramUser> mapRow(ResultSet rs, int rowNumber) throws SQLException {
        List<TelegramUser> telegramUsers = new ArrayList<>();

        telegramUsers.add(extractInfo(rs));
        while(rs.next()) {
            telegramUsers.add(extractInfo(rs));
        }

        return telegramUsers;
    }

    private TelegramUser extractInfo(ResultSet rs) throws SQLException {
        TelegramUser telegramUser = new TelegramUser();
        telegramUser.setId(rs.getLong("id"));
        telegramUser.setFirstName(rs.getString("first_name"));
        telegramUser.setLastName(rs.getString("last_name"));
        telegramUser.setUserName(rs.getString("user_name"));
        telegramUser.setPhoneNumber(rs.getString("phone_number"));
        telegramUser.setLanguageCode(rs.getString("lang_code"));
        telegramUser.setType(rs.getString("type"));
        telegramUser.setCountryId(rs.getLong("country_id"));

        return telegramUser;
    }
}
