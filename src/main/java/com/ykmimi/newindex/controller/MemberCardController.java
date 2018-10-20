package com.ykmimi.newindex.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ykmimi.newindex.bean.MemberCard;
import com.ykmimi.newindex.mapper.MemberCardMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MemberCardController {

    @Resource
    private MemberCardMapper memberCardMapper;

    //查询membercard表中MCARD_TYPEID字段为cardType的会员卡List集合
    @RequestMapping("cardList")
    public List<MemberCard> showCardList(int cardType){
        //select * from membercard where MCARD_TYPEID = #{cardType}
        System.out.println("get parameter from showCards0.jsp : "+cardType);
        return memberCardMapper.showCardList(cardType);
    }

    //动态获取会员卡数据并分页
    @RequestMapping("selectMemberCardSelective")
    public Map<String,Object> selectMemberCardSelective(MemberCard memberCard, Integer page, Integer rows){
        Map<String,Object> map = new HashMap<String,Object>();
        PageHelper.startPage(page,rows);
        List list = memberCardMapper.selectMemberCardSelective(memberCard);
        PageInfo<MemberCard> pageInfo = new PageInfo<MemberCard>(list);

        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());

        return map;
    }

    //动态插入会员卡数据 会员卡号,会员卡类别,会员卡状态 必填
    @RequestMapping("insertSelective")
    public Integer insertSelective(MemberCard memberCard){
        return memberCardMapper.insertSelective(memberCard);

    }

    //动态更新会员卡信息
    @RequestMapping("updateSelective")
    public Integer updateByPrimaryKeySelective(MemberCard memberCard){
        return memberCardMapper.updateByPrimaryKeySelective(memberCard);
    }

    //根据序列号删除会员卡
    @RequestMapping("deleteByPK")
    public Integer deleteByPrimaryKey(Long mcardId){
        return memberCardMapper.deleteByPrimaryKey(mcardId);
    }
}
