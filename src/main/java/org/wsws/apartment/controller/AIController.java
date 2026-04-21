package org.wsws.apartment.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wsws.apartment.service.AIService;

@RestController
@RequestMapping("/api/ai")
@Tag(name = "AI 智能服务", description = "AI 客服对话与房源描述生成接口")
public class AIController {

    @Autowired
    private AIService aiService;

    @PostMapping("/chat")
    @Operation(summary = "AI 智能客服", description = "根据房源信息回答用户问题")
    public String chat(@RequestParam String question) {
        // 临时：从数据库查一条房源信息作为上下文
        // 后续 W2-D4 会完善这部分
        String houseContext = "这是一条模拟的房源信息：朝南一居室，精装修，月租3500元，近地铁";
        
        return aiService.generateCustomerServiceReply(question, houseContext);
    }

    @PostMapping("/generate-desc")
    @Operation(summary = "生成房源描述", description = "根据关键词生成房源介绍文案")
    public String generateDescription(@RequestParam String keywords) {
        return aiService.generateHouseDescription(keywords);
    }
}