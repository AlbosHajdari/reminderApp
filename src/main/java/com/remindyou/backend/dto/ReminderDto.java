package com.remindyou.backend.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReminderDto {
    private String message;
    private LocalDateTime date;
    private String fromUserUuid;
    private String toUserUuid;
}
