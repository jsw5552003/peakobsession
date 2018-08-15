--USE PEAK_DB;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
  ID BIGINT PRIMARY KEY auto_increment,
  FIRST_NAME VARCHAR(50),
  LAST_NAME VARCHAR(50),
  USER_NAME VARCHAR(50),
  EMAIL VARCHAR(50),
  PASSWORD VARCHAR(60));

DROP TABLE IF EXISTS user_hikes;

DROP TABLE IF EXISTS friends;

CREATE TABLE friends (
  ID BIGINT PRIMARY KEY auto_increment,
  USER_ID BIGINT,
  FRIEND_USER_ID BIGINT,
  NAME VARCHAR(50),
  foreign key (USER_ID ) references users(ID),
  foreign key (FRIEND_USER_ID ) references users(ID)
  );

CREATE TABLE user_hikes (
  ID BIGINT PRIMARY KEY auto_increment,
  USER_ID BIGINT,
  DATE DATE NOT NULL,
  MILEAGE   DOUBLE NOT NULL,
  ELEVATION INTEGER,
  foreign key (USER_ID ) references users(ID));
  
DROP TABLE IF EXISTS mountains;

CREATE TABLE mountains (
  ID BIGINT PRIMARY KEY auto_increment,
  NAME VARCHAR(50),
  ELEVATION INTEGER,
  STATE VARCHAR(10));
  
DROP TABLE IF EXISTS user_hikes_mountains;

CREATE TABLE user_hikes_mountains (
  USER_HIKE_ID BIGINT,
  MOUNTAIN_ID BIGINT,
  foreign key (USER_HIKE_ID ) references user_hikes(ID),
  foreign key (MOUNTAIN_ID ) references mountains(ID) );
  
DROP TABLE IF EXISTS user_hikes_friends;

CREATE TABLE user_hikes_friends (
  USER_HIKE_ID BIGINT,
  FRIEND_ID BIGINT,
  foreign key (USER_HIKE_ID ) references user_hikes(ID),
  foreign key (FRIEND_ID ) references friends(ID) );
  
DROP TABLE IF EXISTS roles;

CREATE TABLE roles(
  ID BIGINT PRIMARY KEY auto_increment,
  NAME VARCHAR(50));
  
DROP TABLE IF EXISTS users_roles;

CREATE TABLE users_roles (
  USER_ID BIGINT,
  ROLE_ID BIGINT,
  foreign key (USER_ID ) references users(ID),
  foreign key (ROLE_ID ) references roles(ID) );
  
DROP TABLE IF EXISTS mountain_lists;

CREATE TABLE mountain_lists (
  ID BIGINT PRIMARY KEY auto_increment,
  NAME VARCHAR(100),
  DESCRIPTION VARCHAR(250));

DROP TABLE IF EXISTS mountain_lists_mountains;  
  
CREATE TABLE mountain_lists_mountains (
  MOUNTAIN_LIST_ID BIGINT,
  MOUNTAIN_ID BIGINT,
  foreign key (MOUNTAIN_LIST_ID ) references mountain_lists(ID),
  foreign key (MOUNTAIN_ID ) references mountains(ID) );
  
DROP TABLE IF EXISTS features;

CREATE TABLE features (
  ID BIGINT PRIMARY KEY auto_increment,
  USER_ID BIGINT,
  foreign key (USER_ID ) references users(ID),
  ENTERED_DATE DATE,
  ACCEPTED_DATE DATE,
  COMPLETED_DATE DATE,
  NAME VARCHAR(100),
  DESCRIPTION TEXT,
  ACCEPTED TINYINT NOT NULL DEFAULT 0,
  COMPLETED TINYINT NOT NULL DEFAULT 0
  );
  
DROP TABLE IF EXISTS feature_votes;

CREATE TABLE feature_votes (
  ID BIGINT PRIMARY KEY auto_increment,
  USER_ID BIGINT,
  FEATURE_ID BIGINT,
  foreign key (USER_ID ) references users(ID),
  foreign key (FEATURE_ID ) references features(ID)
  );
  

