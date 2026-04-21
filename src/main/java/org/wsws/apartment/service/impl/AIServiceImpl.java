package org.wsws.apartment.service.impl;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wsws.apartment.generator.entity.AiConversation;
import org.wsws.apartment.generator.entity.AiHouseDesc;
import org.wsws.apartment.generator.mapper.AiConversationMapper;
import org.wsws.apartment.generator.mapper.AiHouseDescMapper;
import org.wsws.apartment.service.AIService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
public class AIServiceImpl implements AIService {

    @Autowired
    private ChatClient.Builder chatClientBuilder;

    @Autowired
    private AiConversationMapper aiConversationMapper;

    @Autowired
    @Qualifier("aiLogExecutor")
    private Executor aiLogExecutor;

    @Autowired
    private AiHouseDescMapper aiHouseDescMapper;

    @Override
    public String chat(String prompt) {
        return "";
    }

    @Override
    public String generateCustomerServiceReply(String userQuestion, String houseContext) {
//        long startTime = System.currentTimeMillis();

        String systemPrompt = """
                你是尚庭公寓的智能客服助手，你的任务是：
                1. 根据提供的房源信息，用热情、专业的语气回答用户问题
                2. 如果房源信息不足以回答用户问题，请礼貌地告知用户并建议联系人工客服
                3. 回答要简洁明了，不超过150字
                
                当前可用的房源信息如下：
                %s
                """.formatted(houseContext);

        String aiAnswer = chatClientBuilder.build()
                .prompt()
                .system(systemPrompt)
                .user(userQuestion)
                .call()
                .content();

//        long duration = System.currentTimeMillis() - startTime;

        CompletableFuture.runAsync(()->{
            // 记录日志到数据库
            AiConversation conversation = new AiConversation();
            conversation.setUserQuestion(userQuestion);
            conversation.setAiAnswer(aiAnswer);
            conversation.setPrompt(systemPrompt + "\n\n用户问题：" + userQuestion);
//        conversation.setDurationMs((int) duration);
            aiConversationMapper.insert(conversation);
        },aiLogExecutor);

        return aiAnswer;
    }

    @Override
    public String generateHouseDescription(String keywords) {
        long startTime = System.currentTimeMillis();

        String prompt = """
            你是一位专业的房产文案编辑。请根据以下关键词，生成一段约150字的房源描述文案。
            要求：
            1. 语言生动有吸引力，突出房源优势
            2. 包含关键词中的所有要素
            3. 字数控制在150字左右
            
            关键词：%s
            """.formatted(keywords);

        String generatedDesc = chatClientBuilder.build()
                .prompt()
                .user(prompt)
                .call()
                .content();

        long duration = System.currentTimeMillis() - startTime;

        // 异步记录生成日志
        CompletableFuture.runAsync(() -> {
            AiHouseDesc desc = new AiHouseDesc();
            desc.setKeywords(keywords);
            desc.setGeneratedDesc(generatedDesc);
            desc.setDurationMs((int) duration);
            aiHouseDescMapper.insert(desc);
        }, aiLogExecutor);

        return generatedDesc;
    }
}