package org.example;

public interface ChatMediator {
    void sendMessage(String message, ChatClientController sender, String receiver);
    void registerClient(ChatClientController client);
}
