-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

-- CREATE statements go here
DROP TABLE IF EXISTS app_user     CASCADE;
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

CREATE TABLE app_user (
        email      text          NOT NULL,
        user_name  varchar(32)   NOT NULL UNIQUE,
        password   varchar(32)   NOT NULL,
        is_admin   boolean       NOT NULL DEFAULT FALSE,
        first_name varchar(25)   NOT NULL,
        last_name  varchar(25)   NOT NULL,
        salt       varchar(255)  NOT NULL
);

CREATE TABLE deck (
        deck_id                 integer              NOT NULL DEFAULT nextval('seq_deck_id'),   --primary key
        deck_name               varchar(50)          NOT NULL,
        deck_description        varchar(350)         NOT NULL
);

CREATE TABLE card (
        card_id                 integer              NOT NULL DEFAULT nextval('seq_card_id'),   --primary key
        deck_id                 integer              NOT NULL,                                  --primary key
        card_front              varchar(100)         NOT NULL,
        card_back               varchar(100)         NOT NULL,
        card_tag                text                 NOT NULL
);

CREATE TABLE deckscreated(
        cool_secret_id          integer              NOT NULL DEFAULT nextval('seq_cool_secret_id')
        deck_id                 integer              NOT NULL,
        email                   text                 NOT NULL
);

CREATE TABLE audit (
        session_id              integer              NOT NULL DEFAULT nextval('seq_session_id'),--primary key
        deck_id                 integer              NOT NULL,                                  --foreign key
        num_right               integer              NOT NULL DEFAULT 0,
        date                    date                 NOT NULL,
        email                   text                 NOT NULL
);

ALTER TABLE audit               ADD FOREIGN KEY (deck_id) REFERENCES    deck(deck_id);
ALTER TABLE audit               ADD FOREIGN KEY (email)   REFERENCES    users(email);
ALTER TABLE card                ADD FOREIGN KEY (deck_id) REFERENCES    deck(deck_id);
ALTER TABLE deckscreated        ADD FOREIGN KEY (deck_id) REFERENCES    deck(deck_id);
ALTER TABLE deckscreated        ADD FOREIGN KEY (email)   REFERENCES    users(email);

COMMIT;