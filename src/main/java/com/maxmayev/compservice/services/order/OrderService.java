package com.maxmayev.compservice.services.order;

import com.maxmayev.compservice.domain.Consumer;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

public interface OrderService {
    void showOrderForm(Model model, Consumer consumer, Authentication authentication);
    void editOrder(String id);
}
