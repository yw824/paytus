package com.paytus.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SlackService {

    // properties 정보 가져오기
    @Value(value="${slack.token}")
    private String token;
    @Value(value = "${slack.channel.monitor}")
    private String channel;



}
