package com.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

@Service
public class OllamaService {

	private ChatClient chatClient;
	
	public OllamaService(ChatClient.Builder builder) {
		//Advisor is used to store chat history using in memory space
		chatClient = builder.defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory())).build();
	}
	
	public ChatResponse generateAnswer(String question) {
		//To configure chatoptions in code ,same can be done in app.prop file as well
//		OpenAiChatOptions chatOptions = new OpenAiChatOptions();
//		chatOptions.setModel("gpt-4o-mini");
//		chatOptions.setTemperature(0.7);
//		chatOptions.setMaxTokens(20);
//		return chatClient.prompt(new Prompt(question, chatOptions)).call().chatResponse();
		return chatClient.prompt(question).call().chatResponse();
	}

}
