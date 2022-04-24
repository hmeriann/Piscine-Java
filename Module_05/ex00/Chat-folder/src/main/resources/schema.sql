CREATE TABLE Users (
                       USER_ID int,
                       LOGIN varchar(255),
                       PASSWORD varchar(255),
                       CREATED_ROOMS varchar(255),
                       USERS_CHATROOMS varchar(255)
);

CREATE TABLE Chatrooms (
                           CHATROOM_ID int,
                           CHATROOM_NAME varchar(255),
                           CHATROOM_OWNER varchar(255),
                           MESSAGES_IN_CHATROOM varchar(255)
);

CREATE TABLE Messages (
                          MASSAGE_ID int,
                          MESSAGE_AUTHOR varchar(255),
                          MESSAGE_ROOM varchar(255),
                          MESSAGE_TEXT varchar(255),
                          MESSAGE_DATE_TIME date
);