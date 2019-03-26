package com.nuesoft.dao;

import com.nuesoft.po.BookInfo;
import com.nuesoft.po.BookInfoExample;
import java.util.List;

public interface BookInfoMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(BookInfo record);

    int insertSelective(BookInfo record);

    List<BookInfo> selectByExample(BookInfoExample example);

    BookInfo selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(BookInfo record);

    int updateByPrimaryKey(BookInfo record);

    BookInfo selectById(Integer bookId);

    List<BookInfo> selectAll();

    int delectByIds(String[] ids);
}