package com.neri.pedro.orderwebapp.config;

import com.neri.pedro.orderwebapp.modules.category.domain.Category;
import com.neri.pedro.orderwebapp.modules.category.repository.CategoryRepository;
import com.neri.pedro.orderwebapp.modules.order.domain.Order;
import com.neri.pedro.orderwebapp.modules.order.domain.OrderItem;
import com.neri.pedro.orderwebapp.modules.order.enums.OrderStatus;
import com.neri.pedro.orderwebapp.modules.order.repository.OrderItemRepository;
import com.neri.pedro.orderwebapp.modules.order.repository.OrderRepository;
import com.neri.pedro.orderwebapp.modules.payment.domain.Payment;
import com.neri.pedro.orderwebapp.modules.payment.repository.PaymentRepository;
import com.neri.pedro.orderwebapp.modules.product.domain.Product;
import com.neri.pedro.orderwebapp.modules.product.repository.ProductRepository;
import com.neri.pedro.orderwebapp.modules.user.domain.Address;
import com.neri.pedro.orderwebapp.modules.user.domain.User;
import com.neri.pedro.orderwebapp.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
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
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ProductRepository productRepository;

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


        Address a1 = new Address(null, "Rua do Usuario 1", "Pet",u1);
        Address a2 = new Address(null, "Rua do Usuario 2", "Pet",u2);
        Address a3 = new Address(null, "Rua do Usuario 4", "Pet",u4);
        Address a4 = new Address(null, "Rua do Usuario 3", "Pet",u3);


        u1.setAddress(a1);
        u2.setAddress(a2);
        u3.setAddress(a4);
        u4.setAddress(a3);


        Order o1 = new Order(null, LocalDateTime.now(), u1, OrderStatus.CANCELED);
        Order o2 = new Order(null, LocalDateTime.now(), u2, OrderStatus.PAID);
        Order o3 = new Order(null, LocalDateTime.now().plusDays(5), u1, OrderStatus.WAITING_PAYMENT);
        Order o4 = new Order(null, LocalDateTime.now().plusDays(5), u4, OrderStatus.DELIVERED);
        Order o5 = new Order(null, LocalDateTime.now().plusDays(3), u3, OrderStatus.SHIPPED);


        Category cat1 = Category.builder().id(null).name("Electronics").build();
        Category cat2 = Category.builder().id(null).name("Books").build();
        Category cat3 = Category.builder().id(null).name("Computers").build();
        Category cat4 = Category.builder().id(null).name("Home").build();


        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", new BigDecimal("90.5"), "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", new BigDecimal(2190.0), "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", new BigDecimal(1250.0), "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", new BigDecimal(1200.0), "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", new BigDecimal(100.99), "");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));


        p1.getCategories().add(cat2);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);
        p2.getCategories().addAll(Arrays.asList(cat2, cat1));

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));


        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));


        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());


        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        Payment pay1 = new Payment(null, LocalDateTime.now().plusHours(2), o2);
        Payment pay2 = new Payment(null, LocalDateTime.now().plusHours(22), o3);
        Payment pay3 = new Payment(null, LocalDateTime.now().plusHours(222), o1);

        o2.setPayment(pay1);
        o3.setPayment(pay2);
        o1.setPayment(pay3);

        orderRepository.save(o2);
        orderRepository.save(o3);
        orderRepository.save(o1);


    }
}
