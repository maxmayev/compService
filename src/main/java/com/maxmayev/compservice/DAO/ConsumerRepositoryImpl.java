package com.maxmayev.compservice.DAO;

import com.maxmayev.compservice.Consumer;
import com.maxmayev.compservice.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ConsumerRepositoryImpl implements ConsumerRepository {

    private JdbcTemplate jdbc;
    private ObjectMapper objectMapper;
    private SimpleJdbcInsert consumerInserter;
    private SimpleJdbcInsert orderInserter;

    @Autowired
    public  ConsumerRepositoryImpl(JdbcTemplate jdbc){
        this.jdbc = jdbc;
        this.objectMapper = new ObjectMapper();
        this.consumerInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("consumer")
                .usingGeneratedKeyColumns("id");
        this.orderInserter =new SimpleJdbcInsert(jdbc).withTableName("order").usingGeneratedKeyColumns("id");
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

    @Override
    public Consumer saveConsumerOrders(Consumer consumer, List<Order> orders) {
        long consId = saveConsDetails(consumer);
        for (Order order : orders) {
            saveOrderToConsumer(order,consId);
        }
        return consumer;
    }

    private  long saveConsDetails(Consumer consumer){
        @SuppressWarnings("unchecked")
        Map<String,Object> values = objectMapper.convertValue(consumer, Map.class);
        long consId = consumerInserter.executeAndReturnKey(values).longValue();
        return consId;
    }

    private void saveOrderToConsumer(Order order, long consId){
        Map<String,Object> values = new HashMap<>();
        values.put("id_consumer",consId);
        orderInserter.execute(values);
    }
}
