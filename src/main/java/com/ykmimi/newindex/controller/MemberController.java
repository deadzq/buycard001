package com.ykmimi.newindex.controller;

import com.ykmimi.newindex.bean.Member;
import com.ykmimi.newindex.mapper.MemberMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MemberController {

    @Resource
    private MemberMapper memberMapper;

    //动态插入会员数据
    @RequestMapping("insertOne")
    public Map<String,Object> insertMemberSelective(Member member){
        Map<String,Object> map = new HashMap<String,Object>();
        int insertCode =  memberMapper.insertSelective(member);
        map.put("code",insertCode);
        if(insertCode>0){
            map.put("message","OK");
        }else{
            map.put("message","X");
        }
        return map;
    }

//    动态获取会员数据
    @RequestMapping("selectMemberSelective")
    public List<Member> selectMemberSelective(Member member){
        return memberMapper.selectMemberSelective(member);
    }


}
