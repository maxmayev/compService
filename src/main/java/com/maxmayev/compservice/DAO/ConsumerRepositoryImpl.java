package com.maxmayev.compservice.DAO;

import com.maxmayev.compservice.Consumer;
import com.maxmayev.compservice.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class ConsumerRepositoryImpl implements ConsumerRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public  ConsumerRepositoryImpl(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Consumer> findAll() {
        return jdbc.query("select id,name,surname,patronymic,id, name, surname, patronymic, phoneNumber from consumer", this::mapRowToConsumer);
    }

    @Override
    public Consumer findOne(int id) {
        return jdbc.queryForObject("select id,name,surname,patronymic,id, name, surname, patronymic, phoneNumber from consumer where id=?",this::mapRowToConsumer,id);
    }

    @Override
    public Consumer save(Consumer consumer) {
        jdbc.update("insert into consumer(name, surname, patronymic, phoneNumber) values (?,?,?,?)",consumer.getName(),consumer.getSurname(),consumer.getPatronymic(),consumer.getPhoneNumber());
        return consumer;
    }

    private Consumer mapRowToConsumer (ResultSet rs, int rowNum) throws SQLException {
       /* Consumer consumer = new Consumer();
        consumer.setId(rs.getInt("id"));
        consumer.setName(rs.getString("name"));
        consumer.setSurname(rs.getString("surname"));
        consumer.setPatronymic(rs.getString("patronymic"));
        consumer.setPhoneNumber(rs.getString("phoneNumber"));*/
        return new Consumer(rs.getInt("id"),rs.getString("name"),rs.getString("surname"),rs.getString("patronymic"),rs.getString("phoneNumber"),new ArrayList<>());
    }

    @Override
    public Consumer deleteById(String id) {
        jdbc.execute("delete from consumer where id =" + id);
        return null;
    }
}
