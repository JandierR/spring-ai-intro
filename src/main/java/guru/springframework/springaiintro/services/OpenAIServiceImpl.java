package guru.springframework.springaiintro.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class OpenAIServiceImpl implements OpenAIService {

    private final ChatClient chatClient;

    public OpenAIServiceImpl(ChatModel chatModel) {
        this.chatClient = ChatClient.create(chatModel);
    }

    @Override
    public String getAnswer(String question) {
        return chatClient.prompt()
                .user(question)
                .call()
                .content();
    }
}
