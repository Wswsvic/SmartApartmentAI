package org.wsws.apartment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wsws.apartment.service.AIService;

@RestController
@RequestMapping("/api/ai")
public class AIController {

    @Autowired
    private AIService aiService;

    @PostMapping("/chat")
    public String chat(@RequestParam String question) {
        // 临时：从数据库查一条房源信息作为上下文
        // 后续 W2-D4 会完善这部分
        String houseContext = "这是一条模拟的房源信息：朝南一居室，精装修，月租3500元，近地铁";
        
        return aiService.generateCustomerServiceReply(question, houseContext);
    }

    @PostMapping("/generate-desc")
    public String generateDescription(@RequestParam String keywords) {
        return aiService.generateHouseDescription(keywords);
    }
}