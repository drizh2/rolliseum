SET GLOBAL log_bin_trust_function_creators = 1;

INSERT INTO users (email,password,username)
    VALUES ('drizh2@ukr.net', '$2a$08$VWw4UjkRq0qZ53MHLCFYguNxMenlbagZ8aZ60uqt/JE.ypfiS/5tm', 'DeanWin');

INSERT INTO user_role (user_id, roles)
    VALUES (1, 0);