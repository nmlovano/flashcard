-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

-- CREATE statements go here
DROP TABLE IF EXISTS app_user CASCADE;
DROP TABLE IF EXISTS users CASCADE;

DROP SEQUENCE IF EXISTS user_id;

CREATE TABLE app_user (
        id SERIAL PRIMARY KEY,
        user_name varchar(32)  NOT NULL UNIQUE,
        password  varchar(32)  NOT NULL,
        role      varchar(32),
        salt      varchar(255) NOT NULL
);

CREATE TABLE users (
        user_id    integer          NOT NULL DEFAULT nextval('seq_user_id'),
        password   varchar(15)      NOT NULL,
        first_name varchar(25)      NOT NULL,
        last_name  varchar(25)      NOT NULL,
        CONSTRAINT pk_users_user_id PRIMARY KEY(user_id)
);

COMMIT;