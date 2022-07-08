package com.neri.pedro.orderwebapp.config;

import com.neri.pedro.orderwebapp.modules.category.domain.Category;
import com.neri.pedro.orderwebapp.modules.category.repository.CategoryRepository;
import com.neri.pedro.orderwebapp.modules.order.domain.Order;
import com.neri.pedro.orderwebapp.modules.order.enums.OrderStatus;
import com.neri.pedro.orderwebapp.modules.order.repository.OrderRepository;
import com.neri.pedro.orderwebapp.modules.product.domain.Product;
import com.neri.pedro.orderwebapp.modules.product.repository.ProductRepository;
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


        Order o1 = new Order(null, LocalDateTime.now(), u1, OrderStatus.CANCELED);
        Order o2 = new Order(null, LocalDateTime.now().plusMonths(2), u2, OrderStatus.PAID);
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
        p2.getCategories().addAll(Arrays.asList(cat2,cat1));

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));


        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));


    }
}
