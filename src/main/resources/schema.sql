USE PEAK_DB;

DROP TABLE IF EXISTS USERS;

CREATE TABLE users (
  ID BIGINT PRIMARY KEY auto_increment,
  FIRST_NAME VARCHAR(50),
  LAST_NAME VARCHAR(50),
  USER_NAME VARCHAR(50),
  EMAIL VARCHAR(50),
  PASSWORD VARCHAR(60));

DROP TABLE IF EXISTS USER_HIKES;

DROP TABLE IF EXISTS FRIENDS;

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
  
DROP TABLE IF EXISTS MOUNTAINS;

CREATE TABLE mountains (
  ID BIGINT PRIMARY KEY auto_increment,
  NAME VARCHAR(50),
  ELEVATION INTEGER);
  
DROP TABLE IF EXISTS USER_HIKES_MOUNTAINS;

CREATE TABLE user_hikes_mountains (
  USER_HIKE_ID BIGINT,
  MOUNTAIN_ID BIGINT,
  foreign key (USER_HIKE_ID ) references user_hikes(ID),
  foreign key (MOUNTAIN_ID ) references mountains(ID) );
  
DROP TABLE IF EXISTS USER_HIKES_FRIENDS;

CREATE TABLE user_hikes_friends (
  USER_HIKE_ID BIGINT,
  FRIEND_ID BIGINT,
  foreign key (USER_HIKE_ID ) references user_hikes(ID),
  foreign key (FRIEND_ID ) references friends(ID) );
  
DROP TABLE IF EXISTS ROLES;

CREATE TABLE roles(
  ID BIGINT PRIMARY KEY auto_increment,
  NAME VARCHAR(50));
  
DROP TABLE IF EXISTS USERS_ROLES;

CREATE TABLE users_roles (
  USER_ID BIGINT,
  ROLE_ID BIGINT,
  foreign key (USER_ID ) references users(ID),
  foreign key (ROLE_ID ) references roles(ID) );
  
DROP TABLE IF EXISTS MOUNTAIN_LISTS;

CREATE TABLE mountain_lists (
  ID BIGINT PRIMARY KEY auto_increment,
  NAME VARCHAR(100),
  DESCRIPTION VARCHAR(250));

DROP TABLE IF EXISTS MOUNTAIN_LISTS_MOUNTAINS;  
  
CREATE TABLE mountain_lists_mountains (
  MOUNTAIN_LIST_ID BIGINT,
  MOUNTAIN_ID BIGINT,
  foreign key (MOUNTAIN_LIST_ID ) references mountain_lists(ID),
  foreign key (MOUNTAIN_ID ) references mountains(ID) );
  
DROP TABLE IF EXISTS FEATURES;

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
  
DROP TABLE IF EXISTS FEATURE_VOTES;

CREATE TABLE feature_votes (
  ID BIGINT PRIMARY KEY auto_increment,
  USER_ID BIGINT,
  FEATURE_ID BIGINT,
  foreign key (USER_ID ) references users(ID),
  foreign key (FEATURE_ID ) references features(ID)
  );
  

