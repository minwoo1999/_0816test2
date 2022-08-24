package com.example._0816test2.Mapper;

import com.example._0816test2.Dto.Item;
import com.example._0816test2.Dto.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<Member> getUserList();

    List<Item> getItem();

    int insertItem(Item item);

    Item getItem_to_Item_id(int Item_id);

    int update_Item(Item item);
}
