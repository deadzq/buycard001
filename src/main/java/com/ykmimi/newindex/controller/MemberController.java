package com.ykmimi.newindex.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        int insertCode =  memberMapper.insertMemberSelective(member);
        map.put("code",insertCode);
        if(insertCode>0){
            map.put("message","OK");
        }else{
            map.put("message","X");
        }
        return map;
    }


    //动态获取会员数据并分页
    @RequestMapping("selectMemberSelective")
    public Map<String,Object> selectMemberSelective(Member member,Integer page,Integer rows){
        Map<String,Object> map = new HashMap<String,Object>();
        PageHelper.startPage(page,rows);
        List list = memberMapper.selectMemberSelective(member);
        PageInfo<Member> pageInfo = new PageInfo<Member>(list);

        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());

        return map;
    }

    //动态插入用户数据
    @RequestMapping("insertMemberSelective")
    public Integer insertSelective(Member member){
        return memberMapper.insertMemberSelective(member);
    }

    //根据ID删除用户
    @RequestMapping("deleteByPrimaryKey")
    public Integer deleteByPrimaryKey(Long memberId){
        return memberMapper.deleteByPrimaryKey(memberId);
    }

}
