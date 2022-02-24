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
@RequestMapping("/sale")
public class SaleController {
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

        return "./sale/main";
    }

    //查询未签审公文
    @RequestMapping("/queryUnsignedDocument")
    public String queryUnsignedDocument(HttpSession session,
                                        Model model) {
        HashMap<String, Object> map = new HashMap<>();

        System.out.println();
        System.out.println("================");
        System.out.println("saleController查询未签审公文函数中");

        System.out.println("得到的departId=>" + session.getAttribute("departId"));

        map.put("departid", session.getAttribute("departId"));
        map.put("statenum", 0);

        List<Document> documentList = documentService.queryDocument(map);

        System.out.println(documentList.size());

        System.out.println("================");
        System.out.println();

        if (documentList.size() <= 0) {
            model.addAttribute("msg", "没有未签审的公文");
            return "./sale/main";
        }

        model.addAttribute("documentList", documentList);
        return "./document/queryUnsignedDocumentResult";
    }

    //浏览已签审公文
    @RequestMapping("/querySignedDocument")
    public String querySignedDocument(HttpSession session,
                                      Model model) {
        HashMap<String, Object> map = new HashMap<>();

        System.out.println();
        System.out.println("================");
        System.out.println("saleController浏览已签收公文中");

        System.out.println("得到的departId=>" + session.getAttribute("departId"));

        map.put("departid", session.getAttribute("departId"));
        map.put("statenum", 2);

        List<Document> documentList = documentService.queryDocument(map);

        System.out.println("================");
        System.out.println();

        if (documentList.size() <= 0) {
            model.addAttribute("msg", "没有已签审的公文");
            return "./sale/main";
        }

        model.addAttribute("documentList", documentList);
        return "./document/querySignedDocumentResult";
    }
}
