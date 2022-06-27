CREATE TABLE another_building
(
    building_id      BIGINT AUTO_INCREMENT NOT NULL,
    building_address VARCHAR(255) NULL,
    CONSTRAINT pk_another_building PRIMARY KEY (building_id)
);

CREATE TABLE another_user
(
    user_id   BIGINT AUTO_INCREMENT NOT NULL,
    user_name VARCHAR(255) NULL,
    CONSTRAINT pk_another_user PRIMARY KEY (user_id)
);

CREATE TABLE building
(
    building_id      BIGINT AUTO_INCREMENT NOT NULL,
    building_address VARCHAR(255) NULL,
    CONSTRAINT pk_building PRIMARY KEY (building_id)
);

CREATE TABLE task
(
    task_id        BIGINT AUTO_INCREMENT NOT NULL,
    description    VARCHAR(255) NOT NULL,
    is_done        BIT(1)       NOT NULL,
    parent_task_id BIGINT NULL,
    order_id       BIGINT NULL,
    CONSTRAINT pk_task PRIMARY KEY (task_id)
);

CREATE TABLE user
(
    user_id   BIGINT AUTO_INCREMENT NOT NULL,
    user_name VARCHAR(255) NULL,
    CONSTRAINT pk_user PRIMARY KEY (user_id)
);

CREATE TABLE user_building
(
    user_id     BIGINT NOT NULL,
    building_id BIGINT NOT NULL,
    time        VARCHAR(255) NULL,
    CONSTRAINT pk_user_building PRIMARY KEY (user_id, building_id)
);

CREATE TABLE user_buildings
(
    building_id BIGINT NOT NULL,
    user_id     BIGINT NOT NULL,
    CONSTRAINT pk_user_buildings PRIMARY KEY (user_id, building_id)
);

CREATE TABLE order_tab
(
    order_id  BIGINT AUTO_INCREMENT NOT NULL,
    task_name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_order PRIMARY KEY (order_id)
);

CREATE TABLE borover
(
    borover_id BIGINT AUTO_INCREMENT NOT NULL,
    CONSTRAINT pk_borover PRIMARY KEY (borover_id)
);

CREATE TABLE payment_type
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    payment_type    VARCHAR(31) NULL,
    total           BIGINT NULL,
    type            VARCHAR(255) NULL,
    `description`   VARCHAR(255) NULL,
    borover_id      BIGINT NULL,
    document_name   VARCHAR(255) NULL,
    average_monthly BIGINT NULL,
    rate            BIGINT NULL,
    CONSTRAINT pk_paymenttype PRIMARY KEY (id)
);

ALTER TABLE payment_type
    ADD CONSTRAINT FK_PAYMENTTYPE_ON_BOROVER FOREIGN KEY (borover_id) REFERENCES borover (borover_id);

ALTER TABLE task
    ADD CONSTRAINT FK_TASK_ON_PARENTTASKS_TASK FOREIGN KEY (parent_task_id) REFERENCES task (task_id);

ALTER TABLE user_building
    ADD CONSTRAINT FK_USER_BUILDING_ON_BUILDING FOREIGN KEY (building_id) REFERENCES another_building (building_id);

ALTER TABLE user_building
    ADD CONSTRAINT FK_USER_BUILDING_ON_USER FOREIGN KEY (user_id) REFERENCES another_user (user_id);

ALTER TABLE user_buildings
    ADD CONSTRAINT fk_usebui_on_building FOREIGN KEY (building_id) REFERENCES building (building_id);

ALTER TABLE user_buildings
    ADD CONSTRAINT fk_usebui_on_user FOREIGN KEY (user_id) REFERENCES user (user_id);

ALTER TABLE task
    ADD CONSTRAINT FK_TASK_ON_ORDER FOREIGN KEY (order_id) REFERENCES order_tab (order_id);