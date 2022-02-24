package com.alice.controller;
import com.alibaba.fastjson.JSON;
import com.alice.pojo.BPIS;
import com.alice.service.BpisService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
@Controller
@RequestMapping("/Bpis")
public class TestController {
    @Autowired
    @Qualifier("BpisServiceImpl")
    private BpisService bpisService;
    @RequestMapping("/getAll")
    @ResponseBody
    public String getAllBpis(){
        List<BPIS> bpisList=bpisService.getAllBPIS();
        String data1= JSON.toJSONString(bpisList);
        String data="{\"code\":0,\"msg\":\"\",\"count\":1000,\"data\":"+data1+"}";
        System.out.println(data);
        return data;
    }
}
