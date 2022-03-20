package com.Cra2iTeT.controller;

import com.Cra2iTeT.bean.Document;
import com.Cra2iTeT.service.impl.DocumentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/production")
public class ProductionController {
    @Autowired
    private DocumentServiceImpl documentService;

    //跳转拟制公文页面
    @RequestMapping("/toAddDocumentPage")
    public String toAddDocumentPage() {
        return "./finance/addDocumentPage";
    }

    //添加公文
    @RequestMapping("/addDocument")
    public String addDocument(HttpSession session,
                              HttpServletRequest request,
                              Model model) {
        HashMap<String, Object> map = new HashMap<>();

        map.put("title", request.getParameter("title"));
        map.put("text", request.getParameter("text"));
        map.put("authorid", session.getAttribute("userId"));
        map.put("departid", session.getAttribute("departId"));
        map.put("statenum", 0);

        if (documentService.addDocument(map) > 0) {
            model.addAttribute("msg", "公文拟制成功");
        } else {
            model.addAttribute("msg", "公文拟制失败");
        }

        return "./production/main";
    }

    //查询未签收公文
    @RequestMapping("/queryUnsignedDocument")
    public String queryUnsignedDocument(HttpSession session,
                                        Model model) {
        HashMap<String, Object> map = new HashMap<>();

        System.out.println();
        System.out.println("================");
        System.out.println("productionController查询未签收公文函数中");

        System.out.println("得到的departId=>"+session.getAttribute("departId"));

        map.put("departid", session.getAttribute("departId"));
        map.put("statenum", 0);

        List<Document> documentList = documentService.queryDocument(map);

        System.out.println("================");
        System.out.println();

        if (documentList.size() <= 0) {
            model.addAttribute("msg", "没有未签收的公文");
            return "./production/main";
        }

        model.addAttribute("documentList", documentList);
        return "./document/queryUnsignedDocumentResult";
    }

    //浏览已签收公文
    @RequestMapping("/querySignedDocument")
    public String querySignedDocument(HttpSession session,
                                      Model model){
        HashMap<String, Object> map = new HashMap<>();

        System.out.println();
        System.out.println("================");
        System.out.println("productionController浏览已签收公文中");

        System.out.println("得到的departId=>"+session.getAttribute("departId"));

        map.put("departid", session.getAttribute("departId"));
        map.put("statenum", 2);

        List<Document> documentList = documentService.queryDocument(map);

        System.out.println("================");
        System.out.println();

        if (documentList.size() <= 0) {
            model.addAttribute("msg", "没有已签收的公文");
            return "./production/main";
        }

        model.addAttribute("documentList", documentList);
        return "./document/querySignedDocumentResult";
    }
}
