package org.wsws.apartment.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * AI房源描述生成记录表
 * </p>
 *
 * @author wsws
 * @since 2026-04-16
 */
@TableName("t_ai_house_desc")
public class AiHouseDesc implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 生成房源描述的关键词
     */
    private String keywords;

    /**
     * AI生成的房源描述
     */
    private String generatedDesc;

    /**
     * 调用耗时（毫秒）
     */
    private Integer durationMs;

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

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getGeneratedDesc() {
        return generatedDesc;
    }

    public void setGeneratedDesc(String generatedDesc) {
        this.generatedDesc = generatedDesc;
    }

    public Integer getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(Integer durationMs) {
        this.durationMs = durationMs;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "AiHouseDesc{" +
            "id = " + id +
            ", keywords = " + keywords +
            ", generatedDesc = " + generatedDesc +
            ", durationMs = " + durationMs +
            ", createdAt = " + createdAt +
            "}";
    }
}
