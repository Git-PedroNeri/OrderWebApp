create TABLE tb_category
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)          NULL,
    CONSTRAINT pk_tb_category PRIMARY KEY (id)
);

create TABLE tb_order
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    moment       datetime              NULL,
    user_id      BIGINT                NULL,
    order_status INT                   NULL,
    CONSTRAINT pk_tb_order PRIMARY KEY (id)
);

create TABLE tb_order_item
(
    quantity   INT            NULL,
    price      DECIMAL(19, 2) NULL,
    order_id   BIGINT         NOT NULL,
    product_id BIGINT         NOT NULL,
    CONSTRAINT pk_tb_order_item PRIMARY KEY (order_id, product_id)
);

create TABLE tb_product
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255)          NULL,
    `description` VARCHAR(255)          NULL,
    price         DECIMAL(19, 2)        NULL,
    img_url       VARCHAR(255)          NULL,
    CONSTRAINT pk_tb_product PRIMARY KEY (id)
);

create TABLE tb_product_category
(
    category_id BIGINT NOT NULL,
    product_id  BIGINT NOT NULL,
    CONSTRAINT pk_tb_product_category PRIMARY KEY (category_id, product_id)
);

create TABLE tb_user
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255)          NULL,
    email    VARCHAR(255)          NULL,
    phone    VARCHAR(255)          NULL,
    password VARCHAR(255)          NULL,
    CONSTRAINT pk_tb_user PRIMARY KEY (id)
);

alter table tb_order_item
    add CONSTRAINT FK_TB_ORDER_ITEM_ON_ORDER FOREIGN KEY (order_id) REFERENCES tb_order (id);

alter table tb_order_item
    add CONSTRAINT FK_TB_ORDER_ITEM_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES tb_product (id);

alter table tb_order
    add CONSTRAINT FK_TB_ORDER_ON_USER FOREIGN KEY (user_id) REFERENCES tb_user (id);

alter table tb_product_category
    add CONSTRAINT fk_tbprocat_on_category FOREIGN KEY (category_id) REFERENCES tb_category (id);

alter table tb_product_category
    add CONSTRAINT fk_tbprocat_on_product FOREIGN KEY (product_id) REFERENCES tb_product (id);