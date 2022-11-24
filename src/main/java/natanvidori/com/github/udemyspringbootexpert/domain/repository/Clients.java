package natanvidori.com.github.udemyspringbootexpert.domain.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import natanvidori.com.github.udemyspringbootexpert.domain.entity.Client;

@Repository
public class Clients {

    private static String INSERT = "insert into client (name) values (?)";
    private static String SELECT_ALL = "select * from client";
    private static String UPDATE = "update client set name = ? where id = ?";
    private static String DELETE = "delete from client where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Client save(Client client) {
        jdbcTemplate.update(INSERT, new Object[] { client.getName() });
        return client;
    }

    public Client update(Client client) {
        jdbcTemplate.update(UPDATE, new Object[] {
                client.getName(), client.getId() });
        return client;
    }

    public void deletar(Client client) {
        deletar(client.getId());
    }

    public void deletar(Integer id) {
        jdbcTemplate.update(DELETE, new Object[] { id });
    }

    public List<Client> findByName(String name) {
        return jdbcTemplate.query(
                SELECT_ALL.concat(" where name like ?"),
                getRowMapperClient(),
                new Object[] { "%" + name + "%" });
    }

    private RowMapper<Client> getRowMapperClient() {
        return new RowMapper<Client>() {
            @Override
            public Client mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                return new Client(id, name);
            }
        };
    }

    public List<Client> listAll() {
        return jdbcTemplate.query(SELECT_ALL, getRowMapperClient());
    }
}
