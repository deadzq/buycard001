package com.ykmimi.newindex.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberCard {
    private Long mcardId;

    private Long mcardNumber;

    private Integer mcardTypeid;

    private Long memberId;

    private Integer mcardState;

    private Double mcardBalance;

    private Long mcardVd;

    private Integer mcardUsecount;

    @JsonFormat(pattern="yyyy-MM-dd  HH:mm:ss" ,  timezone="GMT+8")
    private Date regDate;

    @JsonFormat(pattern="yyyy-MM-dd  HH:mm:ss" ,  timezone="GMT+8")
    private Date mcardCancelDate;

    private String mcardPic;

    private Boolean expand01;

    private Boolean expand02;

    private Boolean expand03;

}