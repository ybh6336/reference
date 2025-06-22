package ybh.ai.springai.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ybh.ai.springai.task.bookmark.BookmarkCategorizationService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final Logger log = LoggerFactory.getLogger(TaskController.class);

    private final BookmarkCategorizationService bookmarkCategorizationService;

    public TaskController(final BookmarkCategorizationService bookmarkCategorizationService) {
        this.bookmarkCategorizationService = bookmarkCategorizationService;
    }

    @PostMapping(path = "/categorize-bookmarks")
    public ResponseEntity<String> categorizeBookmarks(@RequestParam("file") MultipartFile bookmarksFile) throws IOException {
//        byte[] contents = bookmarksFile.getInputStream().readAllBytes();
//        log.info(new String(contents, StandardCharsets.UTF_8));

        bookmarkCategorizationService.processSafariBookmarks(bookmarksFile);

        return ResponseEntity.ok("Submitted");
    }
}
