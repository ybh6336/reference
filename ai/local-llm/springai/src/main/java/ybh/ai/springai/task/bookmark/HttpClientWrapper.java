package ybh.ai.springai.task.bookmark;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;

@Service
public class HttpClientWrapper {
    private final Logger log = LoggerFactory.getLogger(HttpClientWrapper.class);

    private final HttpClient httpClient;

    public HttpClientWrapper(final HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Optional<String> fetchUrlContent(String url) {
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(10))
                .GET()
                .build();
        try {
            return Optional.of(
                    httpClient
                            .send(request, HttpResponse.BodyHandlers.ofString())
                            .body());
        } catch (final Exception e) {
            log.error("Could not fetch URL: [{}]", url, e);
        }

        return Optional.empty();
    }

}
