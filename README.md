# Caesar Cipher Java Application

A Java implementation of the Caesar Cipher encryption technique with client-server functionality for secure message transmission.

## Project Overview

This application implements the classical Caesar Cipher encryption algorithm, which is a substitution cipher where each letter in the plaintext is shifted a certain number of places down or up the alphabet. The project includes both encryption and decryption capabilities, as well as advanced features like brute force decryption and frequency analysis.

## Features

- **Basic Encryption/Decryption**: Encrypt and decrypt messages using a specified shift key
- **Client-Server Communication**: Send encrypted messages between client and server
- **Brute Force Attack**: Try all possible shift keys (1-25) to decrypt a message
- **Frequency Analysis**: Use letter frequency to attempt to determine the encryption key 
- **Socket Programming**: Implement network communications between client and server components


## File Structure

- `Main.java`: Entry point of the application
- `methods.java`: Contains the encryption, decryption, and cryptanalysis algorithms
- `Server.java`: Server implementation for receiving and processing encrypted messages
- `Client.java`: Client implementation for sending encrypted messages to the server

## How to Run

### Server
```
javac Server.java
java Server
```

### Client
```
javac Client.java
java Client
```

## Encryption Methods

### Caesar Cipher
The Caesar Cipher is a simple substitution cipher in which each letter in the plaintext is shifted a certain number of places down or up the alphabet. For example, with a shift of 3, 'A' would be replaced by 'D', 'B' would become 'E', and so on.

### Brute Force
When the encryption key is unknown, the application can use a brute force approach to try all possible 25 shift values and present all possible plaintext versions.

### Frequency Analysis
Leverages the fact that certain letters appear more frequently in English text (like 'e') to attempt to determine the most likely shift key.
