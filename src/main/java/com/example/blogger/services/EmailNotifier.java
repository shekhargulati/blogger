package com.example.blogger.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service
class EmailNotifier implements Notifier {

    private Logger logger = LoggerFactory.getLogger(EmailNotifier.class);

    @Override
    public void notify(String message) {
        logger.info(message);
    }
}
