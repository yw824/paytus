package com.paytus.backend.service;

import com.paytus.backend.dto.FaqDTO;
import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.model.block.composition.TextObject;
import lombok.RequiredArgsConstructor;
import okhttp3.internal.http2.ErrorCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.slack.api.model.block.Blocks.*;
import static com.slack.api.model.block.composition.BlockCompositions.markdownText;
import static com.slack.api.model.block.composition.BlockCompositions.plainText;

@Service
@RequiredArgsConstructor
public class SlackService {

    // properties 정보 가져오기
    @Value(value="${slack.token}")
    private String token;
    @Value(value = "${slack.channel.monitor}")
    private String channel;

    public void sendSlack(FaqDTO faqDTO) {

        LocalDateTime now = LocalDateTime.now();
        String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분"));

        try {
            // slack에 알림이 올때 특정 정보를 추가적으로 주기 위해 TextObject를 활용
            List<TextObject> textObjects = new ArrayList<>();
            textObjects.add(markdownText("*이름:*\n" + faqDTO.getFaqname()));
            textObjects.add(markdownText("*문의 남긴 날짜:*\n" + formatedNow));
            textObjects.add(markdownText("*이메일:*\n" + faqDTO.getFaqemail()));
            textObjects.add(markdownText("*문의내용:*\n" + faqDTO.getFaqtext()));

            // MethodsClient 객체를 이용해 발급받은 슬랙 token을 지정
            MethodsClient methods = Slack.getInstance().methods(token);

            // ChatPostMessageRequest 객체를 이용해서 보내고자 하는 채널과 메시지를 지정
            // 단순한 한줄의 메세지가 아닌 특정 양식을 가지고 있기 때문에 .blocks를 사용하여 헤더 메세지와 tectObjects를 추가
            ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                    .channel(channel)
                    .blocks(asBlocks(
                            header(header -> header.text(plainText(faqDTO.getFaqname() + "님이 문의를 남겨주셨습니다!"))),
                            divider(),
                            section(section -> section.fields(textObjects)
                            ))).build();

            methods.chatPostMessage(request);
            System.out.println("슬랙 알람 전송완료");

        } catch (SlackApiException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
