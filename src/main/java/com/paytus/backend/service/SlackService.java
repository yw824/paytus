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

    public void sendSlack(FaqDTO faqDTO) throws IOException {

        try {
            System.out.println("faqDTO"+faqDTO);
            List<TextObject> textObjects = new ArrayList<>();
            textObjects.add(markdownText("*이름:*\n" + faqDTO.getFaqname()));
            textObjects.add(markdownText("*문의 남긴 날짜:*\n" + faqDTO.getFaqdate()));
            textObjects.add(markdownText("*이메일:*\n" + faqDTO.getFaqemail()));
            textObjects.add(markdownText("*문의내용:*\n" + faqDTO.getFaqtext()));

            System.out.println("textobjext"+textObjects);

            MethodsClient methods = Slack.getInstance().methods(token);
            ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                    .channel(channel)
                    .blocks(asBlocks(
                            header(header -> header.text(plainText(faqDTO.getFaqname() + "님이 문의를 남겨주셨습니다!"))),
                            divider(),
                            section(section -> section.fields(textObjects)
                            ))).build();

            System.out.println("request"+request);

            methods.chatPostMessage(request);
            System.out.println("실행완료");

        } catch (SlackApiException e) {
            throw new RuntimeException(e);
        }


    }

}
