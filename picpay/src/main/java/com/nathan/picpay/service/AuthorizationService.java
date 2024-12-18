package com.nathan.picpay.service;

import com.nathan.picpay.client.AuthorizationClient;
import com.nathan.picpay.entity.Transfer;
import com.nathan.picpay.exception.PicPayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    @Autowired
    AuthorizationClient authorizationClient;

    public boolean isAuthorized(Transfer transfer) {
        var resp = authorizationClient.isAuthorized();

        if(resp.getStatusCode().isError()) {
            throw new PicPayException();
        }

        return resp.getBody().authorized();
    }

}
