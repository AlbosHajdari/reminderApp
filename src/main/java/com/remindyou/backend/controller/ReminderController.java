package com.remindyou.backend.controller;


import com.remindyou.backend.domain.Reminder;
import com.remindyou.backend.domain.User;
import com.remindyou.backend.dto.ReminderDto;
import com.remindyou.backend.repository.ReminderRepository;
import com.remindyou.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping
public class ReminderController {
    @Autowired
    private ReminderRepository reminderRepository;

    @Autowired
    private UserRepository userRepository;

    public ReminderController(ReminderRepository reminderRepository, UserRepository userRepository) {
        this.reminderRepository = reminderRepository;
        this.userRepository = userRepository;
    }


    @PostMapping("reminder")
    public Reminder saveReminder(@RequestBody ReminderDto reminderDto) throws Exception{

        Reminder reminder = new Reminder();
        reminder.setDate(reminderDto.getDate());
        reminder.setMessage(reminderDto.getMessage());

        Optional<User> fromUser = userRepository.findByUuid((reminderDto.getFromUserUuid()));
        Optional<User> toUser = userRepository.findByUuid((reminderDto.getToUserUuid()));

        if(!fromUser.isPresent() || !toUser.isPresent()){
            throw new Exception("User UUID not found");
        }
        reminder.setFromUser(fromUser.get());
        reminder.setToUser(toUser.get());
        reminder.setUuid(UUID.randomUUID().toString());

        return reminderRepository.save(reminder);
    }

    @GetMapping("reminders")
    public List<Reminder> getAllReminders(){
        return reminderRepository.findAll();
    }

    @DeleteMapping("reminders/{uuid}")
    public boolean deleteReminder(@PathVariable("uuid") String uuid) throws Exception {

        Optional<Reminder> reminder = reminderRepository.findByUuid(uuid);

        if(reminder.isPresent()){
            reminderRepository.delete(reminder.get());
            return true;
        }
        throw new Exception("Reminder with the provided " + " uuid does not exist");
    }

    @PutMapping("reminders/approval/{uuid}")
    public Reminder updateReminderStatus(
            @PathVariable("uuid") String uuid,
            @NotNull @RequestParam("status") String status) throws Exception {
    Optional<Reminder> reminder = reminderRepository.findByUuid((uuid));

        if(reminder.isPresent()){
            reminder.get().setStatus(status);
            return reminderRepository.save(reminder.get());
        }
        throw new Exception("Reminder with the provided " + "uuid does not exist");
    }
}