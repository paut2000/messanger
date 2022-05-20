package com.kapers.messanger.service;

import com.kapers.messanger.model.Dialogue;
import com.kapers.messanger.model.Message;
import com.kapers.messanger.repo.DialogueRepo;
import com.kapers.messanger.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DialogueService {

    @Autowired
    private DialogueRepo dialogueRepo;

    @Autowired
    private MessageRepo messageRepo;

    @Transactional
    public void createDialogue(Dialogue dialogue) {
        dialogueRepo.save(dialogue);
    }

    @Transactional
    public void addMessage(Message message) {
        messageRepo.save(message);
    }

}
