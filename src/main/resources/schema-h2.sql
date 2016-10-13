DROP TABLE IF EXISTS CUSTOMER;
CREATE TABLE CUSTOMER(id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                      firstname VARCHAR(255) NOT NULL,
                      lastname VARCHAR(255) NOT NULL,
                      email VARCHAR(255) NOT NULL,
                      password VARCHAR(255) NOT NULL
              );

DROP TABLE IF EXISTS `ORDER`;
CREATE TABLE `ORDER`(id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                      date_created DATE NOT NULL,
                      total DECIMAL NOT NULL,
                      customer_id BIGINT NOT NULL,
                      FOREIGN KEY (customer_id) references CUSTOMER(id),
                    );