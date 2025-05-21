package ybh.ai.springai.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ollamaChatService")
public class OllamaChatService implements ChatService {

    private final OllamaChatModel ollamaChatModel;

    public OllamaChatService(final OllamaChatModel ollamaChatModel) {
        this.ollamaChatModel = ollamaChatModel;
    }

    @Override
    public String chat(String prompt) {
        return ChatClient.create(this.ollamaChatModel)
                .prompt(prompt)
                .options(OllamaOptions.builder().model(OllamaModel.LLAMA3_2_1B).build()) // commenting this out throws an exception - [404] Not Found - {"error":"model \"mistral\" not found, try pulling it first"}
                .call()
                .content();
    }

}
