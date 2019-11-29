package com.maxmayev.compservice.DAO;

import com.maxmayev.compservice.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
@Repository
public class OrderRepositoryImpl implements OrderRepository {

    JdbcTemplate jdbc;

    @Autowired
    public OrderRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Order> getOrdersByConsumerId(int id) {
        log.info("in query");
        return jdbc.query("select id, id_consumer, appenddate, receiveplan, receivefact, calldate, active, technic, brand, model, serialnumber, conditionType,conditiondescription,orderdescription,note from compservice.`order` where id_consumer = ?",this::mapRowToOrder, id);
    }

    private Order mapRowToOrder(ResultSet rs, int rowNum) throws SQLException{
        Order order = new Order(rs.getInt("id"), rs.getDate("appenddate"), rs.getDate("receiveplan"), rs.getDate("receivefact"), rs.getDate("calldate"),
                rs.getInt("active"),Order.Technic.Other /*Order.Technic.valueOf(rs.getString("technic"))*/,rs.getString("brand"), rs.getString("model"), rs.getString("serialnumber"),
                /*Order.ConditionType.valueOf(rs.getString("conditionType"))*/Order.ConditionType.NotSet, rs.getString("conditiondescription"), rs.getString("orderdescription"), rs.getString("note"));
        log.info(order.toString());
        return order;
    }
}
