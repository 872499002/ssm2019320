package com.nuesoft.service;

import com.nuesoft.po.BookInfo;
import com.nuesoft.po.BookInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookInfoService {
    int deleteByPrimaryKey(Integer bookId);

    int insert(BookInfo record);

    int insertSelective(BookInfo record);

    List<BookInfo> selectByExample(BookInfoExample example);

    BookInfo selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(BookInfo record);

    int updateByPrimaryKey(BookInfo record);

    BookInfo selectById( Integer bookId);

    List<BookInfo> selectAll();

    int delectByIds(String[] ids);
}
