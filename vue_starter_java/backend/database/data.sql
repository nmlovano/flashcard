-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;
-- Password for this user is 'greatwall'
INSERT INTO users ("username", "password", "email", "salt", "role", first_name, last_name) VALUES
('user',
'FjZDm+sndmsdEDwNtfr6NA==', 'hello@gmail.com',
'kidcasB0te7i0jK0fmRIGHSm0mYhdLTaiGkEAiEvLp7dAEHWnuT8n/5bd2V/mqjstQ198iImm1xCmEFu+BHyOz1Mf7vm4LILcrr17y7Ws40Xyx4FOCt8jD03G+jEafpuVJnPiDmaZQXJEpEfekGOvhKGOCtBnT5uatjKEuVWuDA=',
'user', 'Bob', 'Smith');

INSERT INTO users ("username", "password", "email", "salt", "role", first_name, last_name) VALUES
('admin',
'FjZDm+sndmsdEDwNtfr6NA==', 'admin@gmail.com',
'kidcasB0te7i0jK0fmRIGHSm0mYhdLTaiGkEAiEvLp7dAEHWnuT8n/5bd2V/mqjstQ198iImm1xCmEFu+BHyOz1Mf7vm4LILcrr17y7Ws40Xyx4FOCt8jD03G+jEafpuVJnPiDmaZQXJEpEfekGOvhKGOCtBnT5uatjKEuVWuDA=',
'admin', 'Lori', 'Brown');

-- this is dummy data for decks
Insert into deck (deck_name, deck_description, user_id) VALUES ('pizza', 'yumminess', 1);
Insert into deck (deck_name, deck_description, user_id) VALUES ('pie', 'more yumminess', 1);
Insert into deck (deck_name, deck_description, user_id) VALUES ('veggies', 'BLAH', 2);
Insert into deck (deck_name, deck_description, user_id) VALUES ('carrots', 'MORE BLAH', 2);

-- this is dummy data for card
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (1, 'pepperoni', 'is good', 'pizza');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (1, 'Hawaiian', 'is delicious and pineapple goes on pizza', 'pizza');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (1, 'Supreme', 'so many toppings', 'pizza');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (2, 'Cherry', 'pure yumminess', 'pie');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (2, 'Peach', 'with a cobbler crust is the best', 'pie');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (2, 'Blueberrt', 'is amazing with whipped cream', 'pie');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (3, 'Brocolli', 'is really bad', 'vomit');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (3, 'Brussel Sprouts', 'is gross', 'gag me');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (3, 'Cauliflower', 'I wish it was pizza', 'no flavor');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (4, 'Carrots', 'enough said!!', 'no flavor');

COMMIT;