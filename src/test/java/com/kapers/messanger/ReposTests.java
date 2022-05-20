package com.kapers.messanger;

import com.kapers.messanger.model.Dialogue;
import com.kapers.messanger.model.Message;
import com.kapers.messanger.model.User;
import com.kapers.messanger.repo.UserRepo;
import com.kapers.messanger.service.DialogueService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ReposTests {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private DialogueService dialogueService;

    @Test
    void saveUserTest() {
        User ivan = new User("Ivan");
        userRepo.save(ivan);

        Iterable<User> users = userRepo.findAll();

        System.out.println(ivan.getId() + " " + ivan.getNickname());
        users.forEach(user -> {
            System.out.println(user.getId() + " " + user.getNickname());
        });
    }

    @Test
    void createDialogTest() {
        User user = new User("Peter");
        userRepo.save(user);
        Dialogue dialogue = new Dialogue("My dialogue", user, List.of(user));
        dialogueService.createDialogue(dialogue);
    }

    @Test
    void addMessageTest() {
        User user = new User("Peter");
        userRepo.save(user);
        Dialogue dialogue = new Dialogue("My dialogue", user, List.of(user));
        dialogueService.createDialogue(dialogue);
        Message message = new Message("Any text", user, dialogue);
        dialogueService.addMessage(message);
    }

}
