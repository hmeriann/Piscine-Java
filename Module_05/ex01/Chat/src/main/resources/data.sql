INSERT INTO chat.users (LOGIN, PASSWORD) VALUES ('hmeriann', '123');
INSERT INTO chat.users (LOGIN, PASSWORD) VALUES ('ikathrin', '234');
INSERT INTO chat.users (LOGIN, PASSWORD) VALUES ('lfornio', '345');
INSERT INTO chat.users (LOGIN, PASSWORD) VALUES ('mshad', '456');
INSERT INTO chat.users (LOGIN, PASSWORD) VALUES ('agidget', '567');

INSERT INTO chat.chatroom (CHATROOM_NAME, CHATROOM_OWNER) VALUES ('general', '2');
INSERT INTO chat.chatroom (CHATROOM_NAME, CHATROOM_OWNER) VALUES ('random', '4');
INSERT INTO chat.chatroom (CHATROOM_NAME, CHATROOM_OWNER) VALUES ('memes', '1');

INSERT INTO chat.message (MESSAGE_AUTHOR, MESSAGE_ROOM, MESSAGE_TEXT, MESSAGE_DATE_TIME) VALUES (1, 1, 'message 1', '2022-04-25 00:10:05');
INSERT INTO chat.message (MESSAGE_AUTHOR, MESSAGE_ROOM, MESSAGE_TEXT, MESSAGE_DATE_TIME) VALUES (4, 2, 'test message', '2022-02-25 00:10:05');
INSERT INTO chat.message (MESSAGE_AUTHOR, MESSAGE_ROOM, MESSAGE_TEXT, MESSAGE_DATE_TIME) VALUES (2, 1, 'sos message', '2022-03-25 00:10:05');
INSERT INTO chat.message (MESSAGE_AUTHOR, MESSAGE_ROOM, MESSAGE_TEXT, MESSAGE_DATE_TIME) VALUES (3, 3, 'lol message', '2022-05-25 00:10:05');
INSERT INTO chat.message (MESSAGE_AUTHOR, MESSAGE_ROOM, MESSAGE_TEXT, MESSAGE_DATE_TIME) VALUES (2, 2, 'serious message', '2022-06-25 00:10:05');
INSERT INTO chat.message (MESSAGE_AUTHOR, MESSAGE_ROOM, MESSAGE_TEXT, MESSAGE_DATE_TIME) VALUES (5, 3, 'meme message', '2022-01-25 00:10:05');
INSERT INTO chat.message (MESSAGE_AUTHOR, MESSAGE_ROOM, MESSAGE_TEXT, MESSAGE_DATE_TIME) VALUES (4, 2, 'random message', '2022-04-25 00:10:05');

INSERT INTO chat.users_chatrooms (USER_ID, CHATROOM_ID) VALUES ('1', '1');
INSERT INTO chat.users_chatrooms (USER_ID, CHATROOM_ID) VALUES ('4', '2');
INSERT INTO chat.users_chatrooms (USER_ID, CHATROOM_ID) VALUES ('2', '1');
INSERT INTO chat.users_chatrooms (USER_ID, CHATROOM_ID) VALUES ('3', '3');
INSERT INTO chat.users_chatrooms (USER_ID, CHATROOM_ID) VALUES ('2', '2');
INSERT INTO chat.users_chatrooms (USER_ID, CHATROOM_ID) VALUES ('5', '3');
INSERT INTO chat.users_chatrooms (USER_ID, CHATROOM_ID) VALUES ('4', '2');
