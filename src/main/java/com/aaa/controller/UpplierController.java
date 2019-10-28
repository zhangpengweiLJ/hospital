package com.aaa.controller;

import com.aaa.entity.Upplier;
import com.aaa.service.UpplierService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("upplier")
public class UpplierController {
    @Autowired
    private UpplierService upplierService;
    /*
     * 查询供货单位
     * */
    @RequestMapping("findAllUpplier")
    @ResponseBody
    public Object UpplierList(Upplier upplier, Integer page, Integer limit){
        PageHelper.startPage(page, limit);
        List<Upplier> listAll = upplierService.findAllUpplier(upplier);
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> tableData = new HashMap<String, Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", pageInfo.getTotal());
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", pageInfo.getList());

        return tableData;
    }
    /*
     * 添加供货单位
     * */
    @RequestMapping("addUpplier")
    @ResponseBody
    public Object addUpplier(Upplier upplier){
        int i = upplierService.addUpplier(upplier);
        if(i==1){
            return "添加成功";
        }else{
            return "添加失败";
        }
    }
    /*
     * 修改供货单位
     * */
    @RequestMapping("editUpplier")
    @ResponseBody
    public Object editUpplier(Upplier upplier){
        int i = upplierService.editUpplier(upplier);
        if(i==1){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }
    /*
     * 删除供货单位
     * */
    @RequestMapping("deleteUpplier")
    @ResponseBody
    public Object deleteUpplier(Integer upplierId){
        int i = upplierService.deleteUpplier(upplierId);
        if(i==1){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }
}