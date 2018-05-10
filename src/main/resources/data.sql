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
  ('Eisenhower', '4780'),
  ('North Twin', '4761'),
  ('Carrigain', '4700'),
  ('Bond', '4698'),
  ('Middle Carter', '4610'),
  ('West Bond', '4540'),
  ('Garfield', '4500'),
  ('Liberty', '4459'),
  ('South Carter', '4430'),
  ('Wildcat, A peak', '4422'),
  ('Hancock', '4420'),
  ('South Kinsman', '4358'),
  ('Field', '4340'),
  ('Osceola', '4340'),
  ('Flume', '4328'),
  ('South Hancock', '4319'),
  ('Pierce', '4310'),
  ('North Kinsman', '4293'),
  ('Willey', '4285'),
  ('Bondcliff', '4265'),
  ('Zealand', '4260'),
  ('North Tripyramid', '4180'),
  ('Cabot', '4170'),
  ('Mansfield', '4395')
  ; 
  
 INSERT INTO USERS (id, first_name, last_name, email, password, user_name) VALUES (1, 'John', 'Wilson', 'jwilson@worcester.edu', 'password', 'Grizzly');
  
 INSERT INTO ROLES (id, name) VALUES (1, 'ROLE_ADMIN');
 INSERT INTO ROLES (id, name) VALUES (2, 'ROLE_USER');
 
 INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
 INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);
 
 INSERT INTO MOUNTAIN_LISTS (NAME, DESCRIPTION) VALUES 
 ('NH48', 'The highest 48 peaks in New Hampshire.'), 
 ('NE67', 'The highest 67 peaks in New England.');
 
 INSERT INTO MOUNTAIN_LISTS_MOUNTAINS VALUES (1, 1), (1, 2), (1,3), (1, 4), (1,5),
 (1,6), (1,7), (1,8), (1,9), (1,10), (1,11), (1,12), (1,13), (1,14), (1,15), (1,16), 
 (1,17), (1,18), (1,19), (1,20), (1,21), (1,22), (1,23), (1,24), (1,25), (1,26),
 (2, 1), (2, 2), (2,3), (2, 4), (2,12) ;
 
 INSERT INTO FEATURES (user_id, entered_date, name, description) VALUES
 (1, DATE '2015-12-17','Test Feature', 'Test Descriptioin');
 
 INSERT INTO FEATURE_VOTES VALUES (1,1);
