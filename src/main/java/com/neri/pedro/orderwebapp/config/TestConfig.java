package com.neri.pedro.orderwebapp.config;

import com.neri.pedro.orderwebapp.modules.order.OrderStatus;
import com.neri.pedro.orderwebapp.modules.order.domain.Order;
import com.neri.pedro.orderwebapp.modules.order.repository.OrderRepository;
import com.neri.pedro.orderwebapp.modules.user.domain.User;
import com.neri.pedro.orderwebapp.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @Created 07/07/2022 - 10:08
 * @Author pedro.neri
 */
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(
                null,
                "Maria Brown",
                "maria@gmail.com",
                "988888888",
                "123456", null);

        User u2 = new User(null,
                "Alex Green",
                "alex@gmail.com",
                "977777777",
                "123456", null);

        User u3 = new User(null,
                "Peter Pan",
                "pete.pan@gmail.com",
                "92454577777",
                "123", null);

        User u4 = new User().builder()
                .id(null)
                .name("Bruce Waine")
                .email("bat.man@email.com")
                .phone("12387654")
                .password("abc123")
                .build();


        Order o1 = new Order(null, LocalDateTime.now(), u1, OrderStatus.CANCELED);
        Order o2 = new Order(null, LocalDateTime.now().plusMonths(2), u2,OrderStatus.PAID);
        Order o3 = new Order(null, LocalDateTime.now().plusDays(5), u1,OrderStatus.WAITING_PAYMENT);
        Order o4 = new Order(null, LocalDateTime.now().plusDays(5), u4,OrderStatus.DELIVERED);
        Order o5 = new Order(null, LocalDateTime.now().plusDays(3), u3,OrderStatus.SHIPPED);

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));

    }
}
