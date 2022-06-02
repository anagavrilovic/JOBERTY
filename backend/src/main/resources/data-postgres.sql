INSERT INTO role(id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role(id, name) VALUES (2, 'ROLE_COMPANY_OWNER');
INSERT INTO role(id, name) VALUES (3, 'ROLE_USER');

INSERT INTO registered_user(id,first_name,last_name,email,password,gender,enabled,role_id) VALUES
(1,'Stefan','Ljubovic','stefanljubovic@gmail.com','$2a$10$3kfQZW0qQFJIlfDcadR9UOmPwUDDz4wwkcxxAi1aQmfqZqRxAU/FW',0,true,2);