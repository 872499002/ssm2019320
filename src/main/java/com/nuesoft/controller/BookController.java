package com.nuesoft.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nuesoft.po.BookInfo;
import com.nuesoft.po.BookType;
import com.nuesoft.po.BookTypeExample;
import com.nuesoft.service.BookInfoService;
import com.nuesoft.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.List;

@Controller
public class BookController implements ServletContextAware {

    @Autowired
    private BookTypeService bookTypeService;
    @Autowired
    private BookInfoService bookInfoService;
    @Autowired
    private ServletContext servletContext;
    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext=servletContext;
    }

    @RequestMapping("/toDelectIds.do")
    public String delectByIds(String[] bookid){
        int rows = bookInfoService.delectByIds(bookid);
        System.out.println(rows);
        return "forward:toSelectPage.do";
    }

    @RequestMapping("/toDelect.do")
    public String delectById(int bookId){
        int rows = bookInfoService.deleteByPrimaryKey(bookId);
        return "forward:toSelectPage.do" ;
    }

    @RequestMapping("/toSelectPage.do")
    public String toSelectPage(@RequestParam(value="now",defaultValue = "1",required = false) int now
            ,ModelMap map){
        List<BookType> bookTypes = bookTypeService.selectByExample(new BookTypeExample());
        map.put("bookTypes",bookTypes);
        System.out.println(now);
        PageHelper.startPage(now,2);
        List<BookInfo> bookInfos = bookInfoService.selectAll();
        PageInfo<BookInfo> pageInfo=new PageInfo<>(bookInfos);
        map.put("pageInfo",pageInfo);

        return "index";
    }

    @RequestMapping("/toUpdatePage.do")
    public String toUpdatePage(int bookId,ModelMap map){
        List<BookType> bookTypes = bookTypeService.selectByExample(new BookTypeExample());
        map.put("bookTypes",bookTypes);
        BookInfo bookInfo = bookInfoService.selectById(bookId);
        map.put("bookInfo",bookInfo);
        return "update";
    }
    @RequestMapping("/updatePage.do")
    public String updatePage(BookInfo bookInfo){
        bookInfoService.updateByPrimaryKeySelective(bookInfo);
        return "forward:toSelectPage.do";
    }
    //页面跳转
    @RequestMapping("/add.do")
    public String goAdd(ModelMap map){
        List<BookType> bookTypes = bookTypeService.selectByExample(new BookTypeExample());
        map.put("bookTypes",bookTypes);
        return "add";
    }
    @RequestMapping("/addtwo.do")
    public String insert(BookInfo bookInfo){
        bookInfo.setIsBorrow(0);
        bookInfoService.insertSelective(bookInfo);
        return "forward:toSelectPage.do";
    }
        @RequestMapping("imageupload.do")
        @ResponseBody
        public String imageUpload(@RequestParam("fileImage") CommonsMultipartFile fileImage){
            //获取上传图片的位置
            String path = servletContext.getRealPath("resource/upload/");
            System.out.println("上传路径为:" + path);
        //获取文件名称
        String name=fileImage.getOriginalFilename();
        //创建file对象 写入
        File file = new File(path,name);
        try {
            fileImage.getFileItem().write(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 将上传的图片路径以json的方式返回客户端
        String imagePath = "resource/upload/"+name;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("imagePath",imagePath);
        // 将对象转为json格式
        String json = jsonObject.toJSONString();
        System.out.println("json:"+json);
        return json;

    }
}
