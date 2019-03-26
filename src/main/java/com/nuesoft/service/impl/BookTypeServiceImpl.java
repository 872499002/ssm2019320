package com.nuesoft.service.impl;

import com.nuesoft.dao.BookInfoMapper;
import com.nuesoft.dao.BookTypeMapper;
import com.nuesoft.po.BookType;
import com.nuesoft.po.BookTypeExample;
import com.nuesoft.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookTypeServiceImpl implements BookTypeService {
    @Autowired
    private BookTypeMapper bookTypeDao;
    @Override
    public int deleteByPrimaryKey(Integer typeId) {
        return bookTypeDao.deleteByPrimaryKey(typeId);
    }

    @Override
    public int insert(BookType record) {
        return bookTypeDao.insert(record);
    }

    @Override
    public int insertSelective(BookType record) {
        return bookTypeDao.insertSelective(record);
    }

    @Override
    public List<BookType> selectByExample(BookTypeExample example) {
        return bookTypeDao.selectByExample(example);
    }

    @Override
    public BookType selectByPrimaryKey(Integer typeId) {
        return bookTypeDao.selectByPrimaryKey(typeId);
    }

    @Override
    public int updateByPrimaryKeySelective(BookType record) {
        return bookTypeDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BookType record) {
        return bookTypeDao.updateByPrimaryKey(record);
    }
}
