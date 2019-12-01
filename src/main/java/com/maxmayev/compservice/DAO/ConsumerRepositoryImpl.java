/*
package com.maxmayev.compservice.DAO;

import com.maxmayev.compservice.Consumer;
import com.maxmayev.compservice.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.*;

@Slf4j
@Repository
public class ConsumerRepositoryImpl implements ConsumerRepository {

    private JdbcTemplate jdbc;
    private ObjectMapper objectMapper;
    private SimpleJdbcInsert consumerInserter;
    private SimpleJdbcInsert orderInserter;
    private OrderRepository orderRepository;

    @Autowired
    public  ConsumerRepositoryImpl(JdbcTemplate jdbc, OrderRepository orderRepository){
        this.jdbc = jdbc;
        this.objectMapper = new ObjectMapper();
        this.consumerInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("consumer")
                .usingGeneratedKeyColumns("id");
        this.orderInserter =new SimpleJdbcInsert(jdbc).withTableName("order").usingGeneratedKeyColumns("id");
        this.orderRepository =orderRepository;
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
       */
/* Consumer consumer = new Consumer();
        consumer.setId(rs.getInt("id"));
        consumer.setName(rs.getString("name"));
        consumer.setSurname(rs.getString("surname"));
        consumer.setPatronymic(rs.getString("patronymic"));
        consumer.setPhoneNumber(rs.getString("phoneNumber"));*//*

       List<Order> orders = new ArrayList<>();
        orderRepository.getOrdersByConsumerId(rs.getInt("id")).forEach(o -> orders.add(o));
       Consumer consumer = new Consumer(rs.getInt("id"),rs.getString("name"),rs.getString("surname"),rs.getString("patronymic"),rs.getString("phoneNumber"),orders);
        return consumer;
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
        log.info(consumer.toString());
        log.info(String.valueOf(consId));
        return consId;
    }

    private void saveOrderToConsumer(Order order, long consId){
        log.info(order.toString());
        */
/*jdbc.update("insert into compservice.order (id_consumer, appenddate, receiveplan, receivefact, calldate) values (?, ?, ?, ?, ?)",
                1, new Timestamp(order.getAppendDate().getDate()), new Timestamp(order.getReceivePlan().getDate()), new Timestamp(order.getReceiveFact().getDate()), new Timestamp(order.getCallDate().getDate()));
*//*

        PreparedStatementCreator psc =
                new PreparedStatementCreatorFactory(
                        "insert into compservice.orders (id_consumer, appenddate, receiveplan, receivefact, calldate, active, technic, brand, model, serialnumber, conditionType,conditiondescription,orderdescription,note) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                        Types.INTEGER, Types.TIMESTAMP, Types.TIMESTAMP, Types.TIMESTAMP, Types.TIMESTAMP,Types.TINYINT,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR
            ).newPreparedStatementCreator(Arrays.asList(consId, new Timestamp(order.getAppendDate().getTime()), new Timestamp(order.getReceivePlan().getTime()),
                        new Timestamp(order.getReceiveFact().getTime()), new Timestamp(order.getCallDate().getTime()), order.getActive(), order.getTechnic().toString(),
                        order.getBrand(),order.getModel(),order.getSerialNumber(), order.getConditionType().toString(), order.getConditionDescription(), order.getOrderDescription(), order.getNote()));
        jdbc.update(psc);
        */
/*PreparedStatementCreator psc =
                new PreparedStatementCreatorFactory(
                        "insert into compservice.order (id_consumer, appenddate, receiveplan, receivefact, calldate, active, technic, brand, model, serialnumber, condition, conditiondescription, orderdescription, note) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                        Types.INTEGER, Types.TIMESTAMP, Types.TIMESTAMP, Types.TIMESTAMP, Types.TIMESTAMP, Types.TINYINT,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR
                ).newPreparedStatementCreator(Arrays.asList(consId, new Timestamp(order.getAppendDate().getTime()), new Timestamp(order.getReceivePlan().getTime()), new Timestamp(order.getReceiveFact().getTime()), new Timestamp(order.getCallDate().getTime()),order.getActive(), order.getTechnic().toString(), order.getBrand().toString(), order.getModel().toString(), order.getSerialNumber().toString(),
                        order.getCondition().toString(), order.getConditionDescription().toString(), order.getOrderDescription().toString(), order.getNote().toString()));
        jdbc.update(psc);*//*

        log.info("update id" + consId);
    }
}
*/
