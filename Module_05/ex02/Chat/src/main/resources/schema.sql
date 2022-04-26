DROP SCHEMA IF EXISTS chat CASCADE;

CREATE SCHEMA IF NOT EXISTS  chat;

CREATE TABLE IF NOT EXISTS chat.users (
                       USER_ID serial primary key not null,
                       LOGIN varchar(255) not null,
                       PASSWORD varchar(255) not null
);

CREATE TABLE IF NOT EXISTS chat.chatroom (
                       CHATROOM_ID serial primary key not null ,
                       CHATROOM_NAME varchar(255) not null,
                       CHATROOM_OWNER int not null references chat.users(USER_ID)
);
CREATE TABLE IF NOT EXISTS chat.message (
                      MASSAGE_ID serial primary key,
                      MESSAGE_AUTHOR int not null references chat.users(USER_ID),
                      MESSAGE_ROOM int not null references chat.chatroom(CHATROOM_ID),
                      MESSAGE_TEXT varchar(255) null,
                      MESSAGE_DATE_TIME timestamp null
);

CREATE TABLE chat.users_chatrooms (
    USER_ID serial references chat.users(USER_ID) not null ,
    CHATROOM_ID serial references chat.chatroom(CHATROOM_ID) not null
);

