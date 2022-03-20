package com.Cra2iTeT.controller;

import com.Cra2iTeT.pojo.Document;
import com.Cra2iTeT.service.impl.FmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping("/fm")
public class Fm {

    @Autowired
    private FmServiceImpl fmService;

    //浏览已发公文
    @PostMapping("/1/toScan")
    public String toExam(Model model) {
        model.addAttribute("list", fmService.docList());
        return "./1/1/scan";
    }

    //查询公文
    @PostMapping("/1/toQuery")
    public String toQuery() {
        return "./1/1/query";
    }

    @PostMapping("/1/query")
    public String query(@RequestParam("id") int id, Model model) {
        Document document = fmService.selectDocById(id);

        if (document != null) {
            model.addAttribute("doc", document);
            return "./1/1/queryRes";
        } else {
            model.addAttribute("msg", "查询失败，请检查id是否正确");
            return "./1/1/main";
        }
    }

    @PostMapping("/1/toUpdateDoc")
    public String tUpdateDoc(@RequestParam("id") int id, Model model) {
        model.addAttribute("id", id);
        return "./1/1/update";
    }

    @PostMapping("/1/updateDoc")
    public String updateDoc(@RequestParam("id") int id,
                            @RequestParam("title") String title,
                            @RequestParam("text") String text,
                            @RequestParam("state") int state,
                            @RequestParam("advice") String advice,
                            @RequestParam("up") int up,
                            Model model) {

        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("id", id);
        hashMap.put("title", title);
        hashMap.put("text", text);
        hashMap.put("state", state);
        hashMap.put("advice", advice);
        hashMap.put("up", up);

        if (fmService.updateDoc(hashMap) > 0) {
            model.addAttribute("msg", "修改成功");
        } else {
            model.addAttribute("msg", "修改失败");
        }

        return "./1/1/main";

    }

}
