package team2.elearningapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnectionChecker {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseConnectionChecker(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void checkDatabaseConnection() {
        String query = "SELECT 1";
        Integer result = jdbcTemplate.queryForObject(query, Integer.class);
        if (result != null && result == 1) {
            System.out.println("Database connection is successful");
        } else {
            System.out.println("Database connection is not successful");
        }
    }
}
