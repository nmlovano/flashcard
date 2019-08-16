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
Insert into deck (deck_name, deck_description, user_id) VALUES ('Java', 'An intro to Java', 1);
Insert into deck (deck_name, deck_description, user_id) VALUES ('JavaScript', 'An intro to JavaScript', 1);
Insert into deck (deck_name, deck_description, user_id) VALUES ('SQL', 'An intro to SQL', 2);
Insert into deck (deck_name, deck_description, user_id) VALUES ('HTML', 'An intro to HTML', 2);

-- this is dummy data for card
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (1, 'Fundamental building blocks of java programs', 'classes', 'Java');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (1, 'Every java app contains a class with a _ method', 'main', 'Java');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (1, 'things you manipulate', 'objects', 'Java');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (1, 'things you implement', 'classes', 'Java');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (1, 'System.out is a(n)', 'object', 'Java');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (1, 'when to use "int" type', 'for quantities that never have fractional parts, such as length of a string', 'Java');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (2, 'Variable Data Types', 'Number, string, Boolean, null, Object', 'JavaScript');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (2, 'String', 'Any string of alphanumeric characters', 'JavaScript');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (2, 'How do you declare a variable?', 'By using the var keyword', 'JavaScript');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (2, 'True or False: JavaScript is case sensitive', 'True', 'JavaScript');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (2, 'What is the Logical expression', 'evaluates to true or false', 'JavaScript');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (2, 'What statement returns values to the calling statement.', 'The return statement', 'JavScript');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (3, 'What is a database?', 'A database is a collection of related information', 'SQL');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (3, 'What is a collection of rows and columns?', 'In SQL, a collection of rows and columns is a database table', 'SQL');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (3, 'What is the value of NULL?', 'NULL means nothing or unassigned', 'SQL');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (3, 'What is a constraint?', 'A constraint is a way to limit the information or ability of the data, table or database', 'SQL');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (3, 'What is another name for the data within a field or column?', 'Data within a field or column is known as the column or field value', 'SQL');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (3, 'What does SQL stand for?', '"S"tructured "Q"uery "L"anguage', 'SQL');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (3, 'What is SQL?', 'SQL is a computer language that is used to manipulate data in a computer database', 'SQL');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (4, '<p>   </p>', 'Paragragh', 'HTML');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (4, '<body>   </body>', 'everything in between is the body of the page', 'HTML');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (4, '<html>   </html>', 'defines the html for that page', 'HTML');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (4, '<a href="http://www.w3schools.com">This is a link</a>   what is the attribute?', 'href=""', 'HTML');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (4, '<b>   </b>', 'bold tags', 'HTML');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (4, '<strong>   </strong>', 'Strong tags (bolds text, and places more emphasis on text)', 'HTML');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (4, '<!--...-->   ex.   <!--what is this?-->', 'this is a comment tag', 'HTML');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (4, 'unordered lists', 'lists whose items are denoted with bullet points', 'HTML');
INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (4, 'ordered lists', 'lists whose items denoted with numbers', 'HTML');

COMMIT;