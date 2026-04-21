package org.wsws.apartment.service;

public interface AIService {
    /**
     * 发送 prompt 到 AI 并返回回复内容
     * @param prompt 用户输入的提示词
     * @return AI 生成的回复文本
     */
    String chat(String prompt);

    /**
     * 根据用户问题和房源上下文，生成客服回复
     * @param userQuestion 用户输入的问题
     * @param houseContext 从数据库查出的房源信息（JSON 或文本）
     * @return AI 生成的人性化回复
     */
    String generateCustomerServiceReply(String userQuestion, String houseContext);

    /**
     * 根据关键词生成房源描述文案
     * @param keywords 管理员输入的关键词（如“精装修 近地铁 拎包入住”）
     * @return AI 生成的房源描述（约150字）
     */
    String generateHouseDescription(String keywords);
}