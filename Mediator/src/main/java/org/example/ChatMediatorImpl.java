package org.example;

import java.util.HashMap;
import java.util.Map;

public class ChatMediatorImpl implements ChatMediator {

    private Map<String, ChatClientController> clients = new HashMap<>();

    @Override
    public void registerClient(ChatClientController client) {
        clients.put(client.getUsername(), client);
    }

    @Override
    public void sendMessage(String message, ChatClientController sender, String receiver) {
        ChatClientController client = clients.get(receiver);

        if (client != null) {
            client.receiveMessage(sender.getUsername(), message);
        }
    }
}
