package com.joberty.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InterviewImpression extends BaseEntity {
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private RegisteredUser user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "position_id")
    private WorkPosition position;

    @Column(nullable = false)
    private Date creationDate;

    @Column(nullable = false)
    private OfferStatus offerStatus;

    @Column(nullable = false)
    private String technicalInterviewImpression;

    @Column(nullable = false)
    private String hrInterviewImpression;
}
