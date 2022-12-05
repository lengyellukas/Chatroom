# Chat Room
Chat room application implementation using WebSocket.

## Background
WebSocket is a communication protocol that makes it possible to establish a two-way communication channel between a server and a client.

## The message model
Message model is the message payload that will be exchanged between the client and the server. It covers all there basic actions.

1.ENTER

After entering username, user enters the chatroom. Number of online users increases by 1 and the user can send messages to other online users and read their messages.

2.CHAT

Each message is displayed to all connected users including the name of the sender.

3.LEAVE

User can leave the chatroom. Number of online users decreases by 1.

### Run the application with command:
mvn spring-boot:run

Open at least two browser and navigate to localhost:8080 to test chat functionality

