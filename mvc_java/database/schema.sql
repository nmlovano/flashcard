-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

-- CREATE statements go here
DROP TABLE IF EXISTS users    CASCADE;
DROP TABLE IF EXISTS deck         CASCADE;
DROP TABLE IF EXISTS card         CASCADE;
DROP TABLE IF EXISTS deckscreated CASCADE;
DROP TABLE IF EXISTS audit        CASCADE;

DROP SEQUENCE IF EXISTS seq_deck_id;        --deck table
DROP SEQUENCE IF EXISTS seq_card_id;        --card table
DROP SEQUENCE IF EXISTS seq_cool_secret_id; --deckscreated table
DROP SEQUENCE IF EXISTS seq_session_id;     --audit table

CREATE SEQUENCE seq_deck_id;
CREATE SEQUENCE seq_card_id;
CREATE SEQUENCE seq_cool_secret_id;
CREATE SEQUENCE seq_session_id;

CREATE TABLE users (
        email      text          NOT NULL,
        user_name  varchar(32)   NOT NULL UNIQUE,
        password   varchar(32)   NOT NULL,
        is_admin   boolean       NOT NULL DEFAULT FALSE,
        first_name varchar(25)   NOT NULL,
        last_name  varchar(25)   NOT NULL,
        salt       varchar(255)  NOT NULL,
        CONSTRAINT pk_users_email PRIMARY KEY(email)
);

CREATE TABLE deck (
        deck_id                 integer              NOT NULL DEFAULT nextval('seq_deck_id'),   --primary key
        deck_name               varchar(50)          NOT NULL,
        deck_description        varchar(350)         NOT NULL,
        CONSTRAINT pk_deck_deck_id PRIMARY KEY(deck_id)
);

CREATE TABLE card (
        card_id                 integer              NOT NULL DEFAULT nextval('seq_card_id'),   --primary key
        deck_id                 integer              NOT NULL,                                  --primary key
        card_front              varchar(100)         NOT NULL,
        card_back               varchar(100)         NOT NULL,
        card_tag                text                 NOT NULL,
        CONSTRAINT pk_card_card_id PRIMARY KEY(card_id)
);

CREATE TABLE deckscreated(
        cool_secret_id          integer              NOT NULL DEFAULT nextval('seq_cool_secret_id'),
        deck_id                 integer              NOT NULL,
        email                   text                 NOT NULL,
        CONSTRAINT pk_deckscreated_cool_secret_id PRIMARY KEY(cool_secret_id)
);

CREATE TABLE audit (
        session_id              integer              NOT NULL DEFAULT nextval('seq_session_id'),--primary key
        deck_id                 integer              NOT NULL,                                  --foreign key
        num_right               integer              NOT NULL DEFAULT 0,
        date                    date                 NOT NULL,
        email                   text                 NOT NULL,
        CONSTRAINT pk_audit_session_id PRIMARY KEY(session_id)
);

ALTER TABLE audit               ADD FOREIGN KEY (deck_id) REFERENCES    deck(deck_id);
ALTER TABLE audit               ADD FOREIGN KEY (email)   REFERENCES    app_user(email);
ALTER TABLE card                ADD FOREIGN KEY (deck_id) REFERENCES    deck(deck_id);
ALTER TABLE deckscreated        ADD FOREIGN KEY (deck_id) REFERENCES    deck(deck_id);
ALTER TABLE deckscreated        ADD FOREIGN KEY (email)   REFERENCES    users(email);

COMMIT;