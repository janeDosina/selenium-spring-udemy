DROP TABLE IF EXISTS user CASCADE;
CREATE TABLE user AS SELECT * FROM CSVREAD('classpath:tables/user_visa.csv');