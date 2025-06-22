package ybh.ai.springai.task.bookmark;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ybh.ai.springai.chat.ChatService;

public class BookmarkCategorizationTask implements Runnable {
    private final Logger log = LoggerFactory.getLogger(BookmarkCategorizationTask.class);

    private final Bookmark bookmark;
    private final HttpClientWrapper httpClientWrapper;
    private final ChatService chatService;
    private static final String PROMPT_CATEGORIZE = """
            The field of computer science and software engineering has many different concepts, like programming languages, 
            databases, distributed systems, systems programming, etc.
            Using less than 5 words, categorize the following content into a computer science concept: %s
            """;

    public BookmarkCategorizationTask(
            final Bookmark bookmark,
            final HttpClientWrapper httpClientWrapper,
            final ChatService chatService) {
        this.bookmark = bookmark;
        this.httpClientWrapper = httpClientWrapper;
        this.chatService = chatService;
    }

    public void run() {
        log.info("Processing bookmark: [{}]", bookmark);
        String category = httpClientWrapper.fetchUrlContent(bookmark.url())
                .map(content -> chatService.chat(String.format(PROMPT_CATEGORIZE, content)))
                .orElse("");
        log.info("Bookmark: [{}] | Category: [{}]", bookmark.url(), category);
    }
}
