package com.joberty.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {
    private String text;
    private Integer userId;
    private Integer companyId;
    private double mark;
}
