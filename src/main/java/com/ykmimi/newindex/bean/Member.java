package com.ykmimi.newindex.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private Long memberId;

    private String memberName;

    private Long memberPhone;

    private Integer memberSexual;

    private String memberAddr;

    private Long memberIdentity;

    private String memberCarnumber;

    private String memberLoginname;

    private String memberPassword;

    private Integer memberType;

    private String memberCardid;

    private String memberNickname;

    private Long memberPoints;

    private Integer receiveAddrid;

    private String memberPic;

    @JsonFormat(pattern="yyyy-MM-dd  HH:mm:ss" ,  timezone="GMT+8")
    private Date regDate;

    @JsonFormat(pattern="yyyy-MM-dd  HH:mm:ss" ,  timezone="GMT+8")
    private Date updateDate;

    @JsonFormat(pattern="yyyy-MM-dd  HH:mm:ss" ,  timezone="GMT+8")
    private Date lastLogindate;

    @JsonFormat(pattern="yyyy-MM-dd  HH:mm:ss" ,  timezone="GMT+8")
    private Date lastOutdate;

    private Boolean expand01;

    private Boolean expand02;

    private Boolean expand03;

    private Boolean expand04;

}