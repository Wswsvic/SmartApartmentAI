package org.wsws.apartment.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * AI对话记录表
 * </p>
 *
 * @author wsws
 * @since 2026-04-16
 */
@TableName("t_ai_conversation")
public class AiConversation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户提问
     */
    private String userQuestion;

    /**
     * AI回复
     */
    private String aiAnswer;

    /**
     * 发送给AI的完整提示词
     */
    private String prompt;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserQuestion() {
        return userQuestion;
    }

    public void setUserQuestion(String userQuestion) {
        this.userQuestion = userQuestion;
    }

    public String getAiAnswer() {
        return aiAnswer;
    }

    public void setAiAnswer(String aiAnswer) {
        this.aiAnswer = aiAnswer;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "AiConversation{" +
            "id = " + id +
            ", userQuestion = " + userQuestion +
            ", aiAnswer = " + aiAnswer +
            ", prompt = " + prompt +
            ", createdAt = " + createdAt +
            "}";
    }
}
