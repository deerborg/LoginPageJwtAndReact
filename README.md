# Fullstack Web Application with Spring Security, JWT, and React

## Overview

This application allows users to register, log in, and send/receive messages.

- **Spring Security** is used for authentication and authorization.
- **JWT** (JSON Web Token) is utilized for secure token-based user sessions.
- **React** handles the front-end interface for user interaction.

Logged-out users can send messages, and logged-in users are able to view those messages. Once the user logs in, they can see a list of all previously sent messages.

## Features

- **User Registration**: New users can sign up with a username and password.
- **User Login**: Returning users can authenticate using JWT.
- **Message Sending**: Users can send messages before and after logging in.
- **Message Viewing**: Logged-in users can see all messages sent by others.

## Tech Stack

- **Backend**:
  - Spring Boot
  - Spring Security
  - JWT (JSON Web Token)
- **Frontend**:
  - React
  - Axios (for API calls)
- **Database**:
  - PostgreSQL

## License

This project is licensed under the MIT License.
