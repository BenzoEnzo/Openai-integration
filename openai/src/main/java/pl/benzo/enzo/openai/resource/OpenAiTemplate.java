package pl.benzo.enzo.openai.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class OpenAiTemplate {
    @Value("${openai.api}")
    private String openAiApi;

    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + openAiApi);
            return execution.execute(request,body);
        }));
        return restTemplate;
    }
}
