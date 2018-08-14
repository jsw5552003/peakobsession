--use PEAK_DB;

/*INSERT INTO USER_HIKES (DATE, MILEAGE, ELEVATION) VALUES
  (DATE '2015-12-17', '9.8', '2300'),
  (DATE '2015-06-17', '5.3', '3400');*/
  
 INSERT INTO mountains (NAME, ELEVATION, STATE) VALUES
  ('Washington', '6288', 'NH'),
  ('Adams', '5774', 'NH'),
  ('Jefferson', '5712', 'NH'),
  ('Monroe', '5384', 'NH'),
  ('Madison', '5367', 'NH'),
  ('Katahdin, Baxter Peak', '5268', 'ME'),
  ('Lafayette', '5260', 'NH'),
  ('Lincoln', '5089', 'NH'),
  ('South Twin', '4902', 'NH'),
  ('Carter Dome', '4832', 'NH'),
  ('Moosilauke', '4802', 'NH'),
  ('Eisenhower', '4780', 'NH'),
  ('North Twin', '4761', 'NH'),
  ('Katahdin, Hamlin Peak', '4756', 'ME'),
  ('Carrigain', '4700', 'NH'),
  ('Bond', '4698', 'NH'),
  ('Middle Carter', '4610', 'NH'),
  ('West Bond', '4540', 'NH'),
  ('Garfield', '4500', 'NH'),
  ('Liberty', '4459', 'NH'),
  ('South Carter', '4430', 'NH'),
  ('Wildcat, A peak', '4422', 'NH'),
  ('Hancock', '4420', 'NH'),
  ('Mansfield', '4393', 'VT'),
  ('South Kinsman', '4358', 'NH'),
  ('Field', '4340', 'NH'),
  ('Osceola', '4340', 'NH'),
  ('Flume', '4328', 'NH'),
  ('South Hancock', '4319', 'NH'),
  ('Pierce', '4310', 'NH'),
  ('North Kinsman', '4293', 'NH'),
  ('Willey', '4285', 'NH'),
  ('Bondcliff', '4265', 'NH'),
  ('Zealand', '4260', 'NH'),
  ('Sugarloaf', '4250', 'VT'),
  ('Killington', '4235', 'VT'),
  ('Crocker', '4228', 'ME'),
  ('North Tripyramid', '4180', 'NH'),
  ('Cabot', '4170', 'NH'),
  ('Old Speck', '4170', 'ME'),
  ('East Osceola', '4156', 'NH'),
  ('North Brother', '4151', 'ME'),
  ('Bigelow, West Peak', '4145', 'ME'),
  ('Middle Tripyramid', '4140', 'NH'),
  ('Saddleback', '4120', 'ME'),
  ('Cannon', '4100', 'NH'),
  ('Bigelow, Avery Peak', '4090', 'ME'),
  ('Camels Hump', '4083', 'VT'),
  ('Ellen', '4083', 'VT'),
  ('Hale', '4054', 'NH'),
  ('Jackson', '4052', 'NH'),
  ('Tom', '4051', 'NH'),
  ('Wildcat, D Peak', '4050', 'NH'),
  ('Abraham', '4050', 'ME'),
  ('South Crocker', '4050', 'ME'),
  ('Moriah', '4049', 'NH'),
  ('Passaconaway', '4043', 'NH'),
  ('Owls Head', '4025', 'NH'),
  ('Galehead', '4024', 'NH'),
  ('Saddleback Horn', '4023', 'ME'),
  ('Whiteface', '4020', 'NH'),
  ('Redington', '4010', 'ME'),
  ('Spaulding', '4010', 'ME'),
  ('Waumbek', '4006', 'NH'),
  ('Abraham', '4006', 'VT'),
  ('Isolation', '4004', 'NH'),
  ('Tecumseh', '4003', 'NH'); 
  
 INSERT INTO USERS (id, first_name, last_name, email, password, user_name) VALUES 
   (1, 'John', 'Wilson', 'jwilson@worcester.edu', 'password', 'Grizzly'),
   (2, 'Boring', 'User', 'a@b.com', 'password', 'User');
  
 INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN');
 INSERT INTO roles (id, name) VALUES (2, 'ROLE_USER');
 
 INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
 INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);
 INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);
 
 INSERT INTO mountain_lists (NAME, DESCRIPTION) VALUES 
 ('NH48', 'The highest 48 peaks in New Hampshire.'), 
 ('NE67', 'The highest 67 peaks in New England.');
 
 INSERT INTO mountain_lists_mountains VALUES (1, 1), (1, 2), (1,3), (1, 4), (1,5),
 (1,7), (1,8), (1,9), (1,10), (1,11), (1,12), (1,13), (1,15), (1,16), 
 (1,17), (1,18), (1,19), (1,20), (1,21), (1,22), (1,23), (1,25), (1,26),
 (1,27), (1,28), (1,29), (1,30), (1,31), (1,32), (1,33), (1,34), (1,38), (1,39),
 (1,41), (1,44), (1,46), (1,50), (1,51), (1,52), (1,53), (1,56), (1,57), (1,58),
 (1, 59), (1, 61), (1,64), (1, 66), (1,67) ;
 
-- INSERT INTO FEATURES (user_id, entered_date, accepted_date, completed_date, name, description, accepted, completed) VALUES
-- (1, DATE '2018-05-16', null, null, 'User Preferences', 'Add user preferences.', 0, 0),
-- (1, DATE '2018-05-16', null, null, 'Input Validation', 'Add input validation to all forms.', 0, 0),
-- (1, DATE '2018-05-16', null, null, 'Icons', 'Find a free icon library and add them to the UI as appropriate.', 0, 0),
-- (1, DATE '2018-05-16', null, null, 'Friend Grid View', 'Show a grid with you and your friend so you know which ones you still have left to hike together.', 0, 0),
-- (1, DATE '2018-03-20', DATE '2018-05-16', null, 'Add Users to Hikes.', 'Add ability to specify who you hiked with.', 1, 0),
-- (1, DATE '2018-03-20', DATE '2018-04-13', DATE '2018-05-04', 'Test Feature', 'Test Descriptioin', 1, 1);
-- 
-- INSERT INTO FEATURE_VOTES VALUES (1,1,1);
