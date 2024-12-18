package com.nathan.picpay.service;

import com.nathan.picpay.client.NotificationClient;
import com.nathan.picpay.entity.Transfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    private NotificationClient notificationClient;

    public void sendNotification(Transfer transfer) {
        try{
            logger.info("Sending notification...");
            var resp = notificationClient.sendNotification(transfer);

            if(resp.getStatusCode().isError()) {
                logger.error("Error while sending notification, status code is not ok.");
            }

        }catch (Exception e) {
            logger.error("Error while sending notification", e);
        }
    }

}
