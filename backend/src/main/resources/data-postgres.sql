--Roles
INSERT INTO role(id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role(id, name) VALUES (2, 'ROLE_COMPANY_OWNER');
INSERT INTO role(id, name) VALUES (3, 'ROLE_USER');

-- Users
INSERT INTO registered_user(email, enabled, first_name, gender, last_name, password, role_id) VALUES ('admin@gmail.com', true, 'Elon', 0, 'Musk', '$2a$10$3kfQZW0qQFJIlfDcadR9UOmPwUDDz4wwkcxxAi1aQmfqZqRxAU/FW', 1);
INSERT INTO registered_user(email, enabled, first_name, gender, last_name, password, role_id) VALUES ('srdjan@gmail.com', true, 'Srdjan', 0, 'Sukovic', '123456', 3);
INSERT INTO registered_user(email, enabled, first_name, gender, last_name, password, role_id) VALUES ('srdjan.s@gmail.com', true, 'Serhio', 0, 'Ramos', '123456', 3);

-- Companies
INSERT INTO company(description, industry, name, size, email, website) VALUES ('Some description', 'IT', 'Synechron', 10000, 'synDragan', 'syn.dragan.com');
INSERT INTO company(description, industry, name, size, email, website) VALUES ('Some other description', 'IT', 'Levi9', 1000, 'leviNiner', 'levi.nine.com');

-- Synechron comments
INSERT INTO comment(creation_date, text, company_id, user_id, mark) VALUES (current_timestamp, 'First comment Synechron.', 1, 1, 5.0);
INSERT INTO comment(creation_date, text, company_id, user_id, mark) VALUES (current_timestamp, 'Second comment Synechron.', 1, 2, 5.0);

-- Levi9 comments
INSERT INTO comment(creation_date, text, company_id, user_id, mark) VALUES (current_timestamp, 'First comment Levi9.', 2, 1, 5.0);
INSERT INTO comment(creation_date, text, company_id, user_id, mark) VALUES (current_timestamp, 'Second comment Levi9.', 2, 2, 5.0);

-- Synechron positions
INSERT INTO work_position(form_of_employment, title, company_id) VALUES (0, 'DevOps engineer', 1);
INSERT INTO work_position(form_of_employment, title, company_id) VALUES (0, 'Software engineer', 1);
INSERT INTO work_position(form_of_employment, title, company_id) VALUES (1, 'Frontend engineer', 1);
INSERT INTO work_position(form_of_employment, title, company_id) VALUES (2, 'Backend engineer', 1);

-- Levi9 positions
INSERT INTO work_position(form_of_employment, title, company_id) VALUES (0, 'DevOps engineer', 2);
INSERT INTO work_position(form_of_employment, title, company_id) VALUES (0, 'Software engineer', 2);
INSERT INTO work_position(form_of_employment, title, company_id) VALUES (1, 'Frontend engineer', 2);
INSERT INTO work_position(form_of_employment, title, company_id) VALUES (2, 'Backend engineer', 2);

-- Synechron interview impressions
INSERT INTO interview_impression(creation_date, hr_interview_impression, offer_status, technical_interview_impression, position_id, user_id)
    VALUES(current_timestamp, 'Great hr interview Synechron!', 1, 'Great technical interview Synechron!', 1, 1);
INSERT INTO interview_impression(creation_date, hr_interview_impression, offer_status, technical_interview_impression, position_id, user_id)
    VALUES(current_timestamp, 'Great hr interview Syne!', 1, 'Great technical interview Syne!', 2, 2);

-- Levi9 interview impressions
INSERT INTO interview_impression(creation_date, hr_interview_impression, offer_status, technical_interview_impression, position_id, user_id)
    VALUES(current_timestamp, 'Great hr interview Levi!', 1, 'Great technical interview Levi!', 6, 1);
INSERT INTO interview_impression(creation_date, hr_interview_impression, offer_status, technical_interview_impression, position_id, user_id)
    VALUES(current_timestamp, 'Great hr interview Levi9!', 1, 'Great technical interview Levi9!', 7, 2);

-- Synechron salary infos
INSERT INTO salary_info(amount_in_eur, creation_date, position_id, user_id) VALUES (1000.0, current_timestamp, 1, 1);
INSERT INTO salary_info(amount_in_eur, creation_date, position_id, user_id) VALUES (1200.0, current_timestamp, 2, 2);

-- Levi9 salary infos
INSERT INTO salary_info(amount_in_eur, creation_date, position_id, user_id) VALUES (1300.0, current_timestamp, 5, 1);
INSERT INTO salary_info(amount_in_eur, creation_date, position_id, user_id) VALUES (900.0, current_timestamp, 6, 2);