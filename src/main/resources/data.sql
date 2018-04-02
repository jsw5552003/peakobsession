/*INSERT INTO USER_HIKES (DATE, MILEAGE, ELEVATION) VALUES
  (DATE '2015-12-17', '9.8', '2300'),
  (DATE '2015-06-17', '5.3', '3400');*/
  
 INSERT INTO MOUNTAINS (NAME, ELEVATION) VALUES
  ('Washington', '6288'),
  ('Adams', '5774'),
  ('Jefferson', '5712'),
  ('Monroe', '5384'),
  ('Madison', '5367'),
  ('Lafayette', '5260'),
  ('Lincoln', '5089'),
  ('South Twin', '4902'),
  ('Carter Dome', '4832'),
  ('Moosilauke', '4802'),
  ('Carter Dome', '4780'),
  ; 
  
 INSERT INTO USERS (id, first_name, last_name, email, password, user_name) VALUES (1, 'John', 'Wilson', 'jwilson@worcester.edu', 'password', 'Grizzly');
  
 INSERT INTO ROLES (id, name) VALUES (1, 'ROLE_ADMIN');
 INSERT INTO ROLES (id, name) VALUES (2, 'ROLE_USER');
 
 INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
 INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);
 
 INSERT INTO HIKE_LISTS (NAME) VALUES ('NH48'), ('NE67'), ('Terrifying 25');
 
 INSERT INTO HIKE_LISTS_MOUNTAINS VALUES (1, 1), (1, 2), (1,3);