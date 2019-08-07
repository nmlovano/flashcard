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
COMMIT;