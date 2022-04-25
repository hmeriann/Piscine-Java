DROP SCHEMA IF EXISTS chat CASCADE;

CREATE SCHEMA IF NOT EXISTS  chat;

CREATE TABLE IF NOT EXISTS chat.users (
                       USER_ID serial primary key,
                       LOGIN varchar(255) not null,
                       PASSWORD varchar(255) not null,
                       CREATED_ROOMS varchar(255),
                       USERS_CHATROOMS varchar(255)
);

CREATE TABLE IF NOT EXISTS chat.chatroom (
                       CHATROOM_ID serial primary key ,
                       CHATROOM_NAME varchar(255) not null,
                       CHATROOM_OWNER int not null references chat.users(USER_ID)
--                        MESSAGES_IN_CHATROOM int references chat.message(MASSAGE_ID)
);

CREATE TABLE IF NOT EXISTS chat.message (
                      MASSAGE_ID serial primary key,
                      MESSAGE_AUTHOR int not null references chat.users(USER_ID),
                      MESSAGE_ROOM int not null references chat.chatroom(CHATROOM_ID),
                      MESSAGE_TEXT varchar(255) not null,
                      MESSAGE_DATE_TIME timestamp
);
