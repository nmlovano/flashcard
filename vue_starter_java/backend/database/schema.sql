-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

-- CREATE statements go here
DROP TABLE IF EXISTS users    CASCADE;
DROP TABLE IF EXISTS deck         CASCADE;
DROP TABLE IF EXISTS card         CASCADE;
DROP TABLE IF EXISTS audit        CASCADE;
DROP TABLE IF EXISTS app_user     CASCADE;
DROP TABLE IF EXISTS deckscreated  CASCADE;

DROP SEQUENCE IF EXISTS seq_deck_id;        --deck table
DROP SEQUENCE IF EXISTS seq_card_id;        --card table
DROP SEQUENCE IF EXISTS seq_user_id; --deckscreated table
DROP SEQUENCE IF EXISTS seq_session_id;     --audit table

CREATE SEQUENCE seq_deck_id;
CREATE SEQUENCE seq_card_id;
CREATE SEQUENCE seq_user_id;
CREATE SEQUENCE seq_session_id;

CREATE TABLE users (
        id         serial        PRIMARY KEY,
        email      text          NOT NULL,
        username  varchar(32)   NOT NULL UNIQUE,
        password   varchar(32)   NOT NULL,
        role       varchar(255)  NOT NULL DEFAULT('user'),
        first_name varchar(25)   NOT NULL,
        last_name  varchar(25)   NOT NULL,
        salt       varchar(255)  NOT NULL
);

CREATE TABLE deck (
        deck_id                 integer              NOT NULL DEFAULT nextval('seq_deck_id'),   --primary key
        deck_name               varchar(50)          NOT NULL,
        deck_description        varchar(350)         NOT NULL,
        user_id                 integer              NOT NULL,   
        CONSTRAINT pk_deck_deck_id PRIMARY KEY(deck_id)
);

CREATE TABLE card (
        card_id                 integer              NOT NULL DEFAULT nextval('seq_card_id'),   --primary key
        deck_id                 integer              NOT NULL,                                  --foreign key
        card_front              varchar(100)         NOT NULL,
        card_back               varchar(100)         NOT NULL,
        card_tag                varchar(100)         NOT NULL,
        CONSTRAINT pk_card_card_id PRIMARY KEY(card_id)
);

CREATE TABLE audit (
        session_id              integer              NOT NULL DEFAULT nextval('seq_session_id'),--primary key
        deck_id                 integer              NOT NULL,                                  --foreign key
        num_right               integer              NOT NULL DEFAULT 0,
        date                    date                 NOT NULL,
        user_id                 integer              NOT NULL,
        CONSTRAINT pk_audit_session_id PRIMARY KEY(session_id)
);

ALTER TABLE audit               ADD FOREIGN KEY (deck_id) REFERENCES    deck(deck_id);
ALTER TABLE audit               ADD FOREIGN KEY (user_id) REFERENCES    users(id);
ALTER TABLE card                ADD FOREIGN KEY (deck_id) REFERENCES    deck(deck_id);
ALTER TABLE deck                ADD FOREIGN KEY (user_id) REFERENCES    users(id);

COMMIT;