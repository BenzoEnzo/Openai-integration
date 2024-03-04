package pl.benzo.enzo.openai.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.benzo.enzo.openai.resource.OpenAiTemplate;
import pl.benzo.enzo.openai.model.ChatRequest;
import pl.benzo.enzo.openai.model.ChatResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bot")
public class MainController {


    private final OpenAiTemplate restTemplate;

    @PostMapping("/openApi")
    public String getOpenaiResponse(@RequestBody String prompt)
    {
        ChatRequest chatRequest = new ChatRequest("gpt-3.5-turbo",prompt);
        ChatResponse response = restTemplate.restTemplate().postForObject
                ("https://api.openai.com/v1/chat/completions", chatRequest, ChatResponse.class);
        assert response != null;
        return response.getChoices().get(0).getMessage().getContent();
    }
}
