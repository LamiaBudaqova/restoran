package com.backend.restoran.services;

import com.backend.restoran.models.ContactMessage;

public interface MailService {
    void sendAutoReply(ContactMessage message);
}
