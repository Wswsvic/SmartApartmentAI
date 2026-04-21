package org.wsws.apartment;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
public class DeepSeekConnectionTest {

    @Autowired
    private ChatClient.Builder chatClientBuilder;

    @Test
    public void testDeepSeekConnection() {
        ChatClient chatClient = chatClientBuilder.build();
        String response = chatClient.prompt()
                .user("请用一句话介绍你自己")
                .call()
                .content();
        System.out.println("DeepSeek 回复: " + response);
    }
}