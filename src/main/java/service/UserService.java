package service;

import Model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final JdbcTemplate jdbcTemplate;

    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertData(User data) {
        String sql = "INSERT INTO user (name) VALUES (?)";
        jdbcTemplate.update(sql, data);
    }
}
