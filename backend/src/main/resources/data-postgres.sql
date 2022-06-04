-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

--Roles
INSERT INTO role(id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role(id, name) VALUES (2, 'ROLE_COMPANY_OWNER');
INSERT INTO role(id, name) VALUES (3, 'ROLE_USER');


-- Users
INSERT INTO registered_user(email, enabled, first_name, gender, last_name, password, role_id) VALUES ('admin@gmail.com', true, 'Elon', 0, 'Musk', '$2a$10$3kfQZW0qQFJIlfDcadR9UOmPwUDDz4wwkcxxAi1aQmfqZqRxAU/FW', 1);
INSERT INTO registered_user(email, enabled, first_name, gender, last_name, password, role_id) VALUES ('srdjan@gmail.com', true, 'Srdjan', 0, 'Sukovic', '123456', 3);
INSERT INTO registered_user(first_name,last_name,email,password,gender,enabled,role_id) VALUES('Stefan','Ljubovic','stefanljubovic@gmail.com','$2a$10$3kfQZW0qQFJIlfDcadR9UOmPwUDDz4wwkcxxAi1aQmfqZqRxAU/FW',0,true,2);
INSERT INTO registered_user(email, enabled, first_name, gender, last_name, password, role_id) VALUES ('ana@gmail.com', true, 'Ana', 1, 'Gavrilovic', '123456', 3);
INSERT INTO registered_user(email, enabled, first_name, gender, last_name, password, role_id) VALUES ('marija@gmail.com', true, 'Marija', 1, 'Kljestan', '123456', 3);

-- Companies
INSERT INTO company(description, industry, name, size, email, website) VALUES ('Some description', 'IT', 'Synechron', 10000, 'synDragan', 'syn.dragan.com');
INSERT INTO company(description, industry, name, size, email, website) VALUES ('Some other description', 'IT', 'Levi9', 1000, 'leviNiner', 'levi.nine.com');
INSERT INTO company(description, industry, name, size, email, website) VALUES ('Google description', 'IT', 'Google', 100000, 'goooogle', 'google.com');

-- Synechron comments
INSERT INTO comment(creation_date, text, company_id, user_id, mark, caption, is_currently_working) VALUES (current_timestamp, 'Regular raises, juniors can also expect a raise if the team spirit is okay, although this may depend on the team, I''m not sure. Technologies are diverse, and the possibility of switching to another technology is also possible.', 1, 2, 5.0, 'Awesome!', true);
INSERT INTO comment(creation_date, text, company_id, user_id, mark, caption, is_currently_working) VALUES (current_timestamp, 'Great atmosphere in a company with a great team always ready to hang out. Opportunity for business trips to world capitals. Possibility of relocation. Working with new technologies, and constantly updating to newer versions.', 1, 4, 5.0, 'Cool', false);
INSERT INTO comment(creation_date, text, company_id, user_id, mark, caption, is_currently_working) VALUES (current_timestamp, 'Great team. People are in a good mood, they want to help, to do a good review, to give, consider and accept suggestions. They are mostly younger people, extremely professional and dedicated.', 1, 5, 4.0, 'Nice', false);
INSERT INTO comment(creation_date, text, company_id, user_id, mark, caption, is_currently_working) VALUES (current_timestamp, 'It takes a lot of responsibility around Security, like we have to be careful how we dispose of sensitive customer data because we mostly work with banking data and insurance companies.', 1, 6, 3.0, 'Could be better', true );

-- Levi9 comments
INSERT INTO comment(creation_date, text, company_id, user_id, mark, caption, is_currently_working) VALUES (current_timestamp, 'I met the Levi9 company last year when I participated in workshops organized by the company. I really liked the working atmosphere, the technologies used, which is why I decided to become a part of it one day.', 2, 5, 5.0, 'Great experience', true);
INSERT INTO comment(creation_date, text, company_id, user_id, mark, caption, is_currently_working) VALUES (current_timestamp, 'Great place for juniors because they will work on the right projects, with the right mentorship, without any stress. Great for intermediaries as well, since the clients are mostly strong and large foreign companies.', 2, 3, 4.0, 'Nice', false);

-- Levi9 comments
INSERT INTO comment(creation_date, text, company_id, user_id, mark, caption, is_currently_working) VALUES (current_timestamp, 'All the recommendations for the company, a lot of very high quality engineers from whom a lot can be learned. The company gave me a chance without previous experience, and time to continue to upgrade my knowledge and gain experience.', 3, 4, 5.0, 'Amazing!', true);
INSERT INTO comment(creation_date, text, company_id, user_id, mark, caption, is_currently_working) VALUES (current_timestamp, 'They take a lot of care of people and from the beginning there is a positive and relaxed atmosphere. The team is phenomenal and always ready to help, everyone is there to jump in if they get stuck somewhere, there is no stress during work.', 3, 5, 5.0, 'Cool!', false);
INSERT INTO comment(creation_date, text, company_id, user_id, mark, caption, is_currently_working) VALUES (current_timestamp, 'The company offers various benefits such as private health insurance, work from home, a solid number of vacation days (22), flexible working hours, etc. You can also get bonuses for every job recommendation.', 3, 3, 5.0, 'Absolutely great', true);

-- Synechron positions
INSERT INTO work_position(form_of_employment, title, company_id, seniority) VALUES (0, 'DevOps engineer', 1, 0);
INSERT INTO work_position(form_of_employment, title, company_id, seniority) VALUES (0, 'Software engineer', 1, 1);
INSERT INTO work_position(form_of_employment, title, company_id, seniority) VALUES (1, 'Frontend engineer', 1, 2);
INSERT INTO work_position(form_of_employment, title, company_id, seniority) VALUES (2, 'Backend engineer', 1, 1);

-- Levi9 positions
INSERT INTO work_position(form_of_employment, title, company_id, seniority) VALUES (0, 'DevOps engineer', 2, 1);
INSERT INTO work_position(form_of_employment, title, company_id, seniority) VALUES (0, 'Software engineer', 2, 1);
INSERT INTO work_position(form_of_employment, title, company_id, seniority) VALUES (1, 'Frontend engineer', 2, 0);
INSERT INTO work_position(form_of_employment, title, company_id, seniority) VALUES (2, 'Backend engineer', 2, 0);

-- Google positions
INSERT INTO work_position(form_of_employment, title, company_id, seniority) VALUES (0, 'DevOps engineer', 3, 0);
INSERT INTO work_position(form_of_employment, title, company_id, seniority) VALUES (0, 'DevOps engineer', 3, 2);
INSERT INTO work_position(form_of_employment, title, company_id, seniority) VALUES (0, 'Software engineer', 3, 1);
INSERT INTO work_position(form_of_employment, title, company_id, seniority) VALUES (1, 'Frontend engineer', 3, 1);
INSERT INTO work_position(form_of_employment, title, company_id, seniority) VALUES (2, 'Backend engineer', 3, 2);

-- Synechron interview impressions
INSERT INTO interview_impression(creation_date, hr_interview_impression, offer_status, technical_interview_impression, position_id, user_id, caption, mark)
    VALUES(current_timestamp, 'The pleasant atmosphere during the interview, without many classic HR questions, is more based on specific questions and essence.', 1, 'They are not too difficult. One task that everyone should be able to solve if they have passed some basic pogam constructions and have okay logic.', 1, 2, 'Good!', 5.0);
INSERT INTO interview_impression(creation_date, hr_interview_impression, offer_status, technical_interview_impression, position_id, user_id, caption, mark)
    VALUES(current_timestamp, 'HR is really wonderful! Very open and approachable. Easy conversation with checking each other''s wishes and expectations.', 1, 'Standard knowledge test with a small task.', 2, 3, 'Liked it', 4.0);
INSERT INTO interview_impression(creation_date, hr_interview_impression, offer_status, technical_interview_impression, position_id, user_id, caption, mark)
    VALUES(current_timestamp, 'Hr interview well conceived, keep your attention, there are no stupid questions like why are you doing this job, long but also well covered with questions, relaxed, literally the best I''ve been to', 1, 'The questions that were asked correctly so that 100 sub-questions can be drawn from them, from which much can be learned.', 3, 4, 'Awesome!', 5.0);

-- Levi9 interview impressions
INSERT INTO interview_impression(creation_date, hr_interview_impression, offer_status, technical_interview_impression, position_id, user_id, caption, mark)
    VALUES(current_timestamp, 'Very correct interview and pleasant experience. Talk about previous experiences and expectations.', 1, 'Also, very correct, mostly theoretical, with a couple of logical tasks (there was no live coding, just discussion).', 6, 2, 'Great!', 4.0);
INSERT INTO interview_impression(creation_date, hr_interview_impression, offer_status, technical_interview_impression, position_id, user_id, caption, mark)
    VALUES(current_timestamp, 'Very quick response to the application, HR conversation quite normal and relaxed. A story about previous experiences and a presentation of the company.', 1, 'Great technical interview Levi9!', 7, 3, 'Technically he was immediately 2 days after the HR interview and was briefly in place.', 5.0);

-- Google interview impressions
INSERT INTO interview_impression(creation_date, hr_interview_impression, offer_status, technical_interview_impression, position_id, user_id, caption, mark)
    VALUES(current_timestamp, 'Fast selection process and a very pleasant recruiter. The whole interview lasted less than 7 days, which is commendable.', 1, 'The process required technical knowledge in the field for which I applied. A very nice experience for me. I accepted the offer and the first working days in the company are at a very high level.', 9, 2, 'Great!', 4.0);
INSERT INTO interview_impression(creation_date, hr_interview_impression, offer_status, technical_interview_impression, position_id, user_id, caption, mark)
    VALUES(current_timestamp, 'I was not in favor of changing jobs because I am satisfied with the company, but at the urging of an extremely pleasant girl on Linkeiden, I agreed to meet. The conversation was completely relaxed, very pleasant.', 1, 'The technical interview was great. The examination was thorough and not easy, but before each topic there was a question whether you did this and that, in case the candidate had no contact with the given topic, no question was asked.', 12, 3, 'Super!', 5.0);

-- Synechron salary infos
INSERT INTO salary_info(amount_in_eur, creation_date, position_id, user_id) VALUES (1000.0, current_timestamp, 1, 2);
INSERT INTO salary_info(amount_in_eur, creation_date, position_id, user_id) VALUES (1700.0, current_timestamp, 2, 3);
INSERT INTO salary_info(amount_in_eur, creation_date, position_id, user_id) VALUES (2200.0, current_timestamp, 3, 4);
INSERT INTO salary_info(amount_in_eur, creation_date, position_id, user_id) VALUES (2500.0, current_timestamp, 3, 5);
INSERT INTO salary_info(amount_in_eur, creation_date, position_id, user_id) VALUES (1800.0, current_timestamp, 2, 6);

-- Levi9 salary infos
INSERT INTO salary_info(amount_in_eur, creation_date, position_id, user_id) VALUES (1300.0, current_timestamp, 5, 1);
INSERT INTO salary_info(amount_in_eur, creation_date, position_id, user_id) VALUES (900.0, current_timestamp, 6, 2);
INSERT INTO salary_info(amount_in_eur, creation_date, position_id, user_id) VALUES (1500.0, current_timestamp, 5, 6);
INSERT INTO salary_info(amount_in_eur, creation_date, position_id, user_id) VALUES (1800.0, current_timestamp, 6, 2);
INSERT INTO salary_info(amount_in_eur, creation_date, position_id, user_id) VALUES (1900.0, current_timestamp, 5, 3);
INSERT INTO salary_info(amount_in_eur, creation_date, position_id, user_id) VALUES (900.0, current_timestamp, 7, 4);
INSERT INTO salary_info(amount_in_eur, creation_date, position_id, user_id) VALUES (800.0, current_timestamp, 8, 5);

-- Google salary infos
INSERT INTO salary_info(amount_in_eur, creation_date, position_id, user_id) VALUES (1500.0, current_timestamp, 9, 2);
INSERT INTO salary_info(amount_in_eur, creation_date, position_id, user_id) VALUES (4000.0, current_timestamp, 10, 3);
INSERT INTO salary_info(amount_in_eur, creation_date, position_id, user_id) VALUES (3800.0, current_timestamp, 10, 4);
INSERT INTO salary_info(amount_in_eur, creation_date, position_id, user_id) VALUES (2700.0, current_timestamp, 11, 5);
INSERT INTO salary_info(amount_in_eur, creation_date, position_id, user_id) VALUES (2800.0, current_timestamp, 11, 6);
