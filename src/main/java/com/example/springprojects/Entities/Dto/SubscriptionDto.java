package com.example.springprojects.Entities.Dto;

import com.example.springprojects.Entities.Model.Subscription;

public class SubscriptionDto {

    private Long id;
    private String userCode;
    private Boolean subscription;

    public Subscription getUpdatedValues(Subscription subscription) {
        if (null != this.id) subscription.setId(this.id);
        if (null != this.userCode) subscription.setUserCode(this.userCode);
        if (null != this.subscription) subscription.setSubscription(false);
        return subscription;
    }
}
