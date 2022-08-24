package com.example._0816test2.Service;


import com.example._0816test2.Dto.Item;
import com.example._0816test2.Dto.Member;
import com.example._0816test2.Mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper; //인터페이스와 의존관계 설정


    @Override
    public List<Member> getUserList() {

        return this.memberMapper.getUserList();
    }

    @Override
    public List<Item> getItem() {
        return this.memberMapper.getItem();
    }

    @Override
    public int insertItem(Item item) {
        return this.memberMapper.insertItem(item);
    }

    @Override
    public Item getItem_to_Item_id(int Item_id) {
        return this.memberMapper.getItem_to_Item_id(Item_id);
    }

    @Override
    public int update_Item(Item item) {
        return this.memberMapper.update_Item(item);
    }


}
