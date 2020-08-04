


INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO feature_toggles (display_name, technical_name, expires_on, description, archived, inverted) values ("my feature a", "my-feature-a" , "2020-11-01 10:10:10", "description a", false, true
);
INSERT INTO feature_toggles (display_name, technical_name, expires_on, description, archived, inverted) values ("my feature b", "my-feature-b" , "2020-11-02 10:10:10", "description b", false, false
);
INSERT INTO feature_toggles (display_name, technical_name, expires_on, description, archived, inverted) values ("my feature c", "my-feature-c" , "2020-01-03 10:10:10", "description c", false, true
);
INSERT INTO feature_toggles (display_name, technical_name, expires_on, description, archived, inverted) values ("my feature d", "my-feature-d" , "2020-11-04 10:10:10", "description d", false, false
);
INSERT INTO feature_toggle_customer_ids (feature_toggle_id, customer_ids) values (1, "1234");
INSERT INTO feature_toggle_customer_ids (feature_toggle_id, customer_ids) values (2, "1234");
