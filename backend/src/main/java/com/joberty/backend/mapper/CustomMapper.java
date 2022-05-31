package com.joberty.backend.mapper;

import com.joberty.backend.dto.CommentDto;
import com.joberty.backend.dto.InterviewImpressionDto;
import com.joberty.backend.dto.SalaryInfoDto;
import com.joberty.backend.model.*;

import java.util.Date;

public class CustomMapper {

    public static Comment mapComment(CommentDto commentDto){
        Company company = new Company();
        company.setId(commentDto.getCompanyId());

        RegisteredUser user = new RegisteredUser();
        user.setId(commentDto.getUserId());

        Comment comment = Comment.builder().company(company)
                .user(user)
                .creationDate(new Date())
                .text(commentDto.getText())
                .mark(commentDto.getMark())
                .build();

        return comment;
    }

    public static SalaryInfo mapSalaryInfo(SalaryInfoDto salaryInfoDto){
        WorkPosition position = new WorkPosition();
        position.setId(salaryInfoDto.getPositionId());

        RegisteredUser user = new RegisteredUser();
        user.setId(salaryInfoDto.getUserId());

        SalaryInfo salaryInfo = SalaryInfo.builder().position(position)
                .user(user)
                .creationDate(new Date())
                .amountInEur(salaryInfoDto.getAmountInEur())
                .build();

        return salaryInfo;
    }

    public static InterviewImpression mapInterviewImpression(InterviewImpressionDto interviewImpressionDto){
        WorkPosition position = new WorkPosition();
        position.setId(interviewImpressionDto.getPositionId());

        RegisteredUser user = new RegisteredUser();
        user.setId(interviewImpressionDto.getUserId());

        InterviewImpression impression = InterviewImpression.builder()
                .user(user)
                .position(position)
                .hrInterviewImpression(interviewImpressionDto.getHrInterviewImpression())
                .technicalInterviewImpression(interviewImpressionDto.getTechnicalInterviewImpression())
                .creationDate(new Date())
                .offerStatus(interviewImpressionDto.getOfferStatus())
                .build();

        return impression;
    }
}
