package ybh.ai.springai.task.bookmark;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ybh.ai.springai.chat.ChatService;
import ybh.ai.springai.task.InMemoryTaskProcessor;

import javax.validation.constraints.NotNull;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BookmarkCategorizationService {
    private final Logger log = LoggerFactory.getLogger(BookmarkCategorizationService.class);
    private final Pattern bookmarkPattern = Pattern.compile(
            "<A\\s+[^>]*HREF=\"([^\"]+)\"[^>]*>(.*?)</A>",
            Pattern.CASE_INSENSITIVE);

    private final InMemoryTaskProcessor inMemoryTaskProcessor;
    private final HttpClientWrapper httpClientWrapper;
    private final ChatService chatService;

    public BookmarkCategorizationService(
            final InMemoryTaskProcessor inMemoryTaskProcessor,
            final HttpClientWrapper httpClientWrapper,
            @Qualifier("ollamaChatService") final ChatService chatService) {
        this.inMemoryTaskProcessor = inMemoryTaskProcessor;
        this.httpClientWrapper = httpClientWrapper;
        this.chatService = chatService;
    }

    public void processSafariBookmarks(@NotNull final MultipartFile bookmarksFile) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(bookmarksFile.getInputStream()))) {
            //final List<Bookmark> bookmarks = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isBlank()) {
//                    bookmarks.addAll(parseBookmark(line));

                    final List<Bookmark> bookmarks = parseBookmark(line);
                    log.info("Parsed bookmarks: [{}]", bookmarks);
                    processBookmarks(bookmarks);
                }
            }
        } catch (final Exception e) {
            log.error("Failed to process file: [{}]", bookmarksFile.getName(), e);
        }
    }

    private void processBookmarks(final List<Bookmark> bookmarks) {
        log.info("Submitting bookmarks [{}] for processing", bookmarks);
        bookmarks.stream()
                .map(bookmark -> new BookmarkCategorizationTask(bookmark, httpClientWrapper, chatService))
                .forEach(inMemoryTaskProcessor::submit);
        log.info("Submitted");
    }

    /**
     * Assumes each bookmark to be of the format:
     * <DT><A HREF="https://url" ...>Description</A>
     *
     * @param htmlDescriptionTermTag a single bookmark link and description pair
     */
    private List<Bookmark> parseBookmark(String htmlDescriptionTermTag) {
        Matcher matcher = bookmarkPattern.matcher(htmlDescriptionTermTag);

        final List<Bookmark> bookmarks = new ArrayList<>();
        while (matcher.find()) {
            // each line would ideally only contain one bookmark, but handle more, if present
            bookmarks.add(new Bookmark(matcher.group(1), matcher.group(2)));
        }

        return bookmarks;
    }
}
