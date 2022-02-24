package com.Cra2iTeT.controller;

import com.Cra2iTeT.bean.Document;
import com.Cra2iTeT.service.impl.DocumentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/office")
public class OfficeController {
    @Autowired
    private DocumentServiceImpl documentService;

    //查看未签审公文
    @PostMapping("/queryUnsignedDocument")
    public String queryUnsignedDocument(Model model) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("statenum", 0);

        List<Document> documentList = documentService.queryDocument(map);

        if (documentList.size() > 0) {
            model.addAttribute("documentList", documentList);
            return "./office/queryUnsignedDocumentResult";
        } else {
            model.addAttribute("msg", "没有未签审的公文");
            return "./office/main";
        }
    }

    //查看已签审公文
    @PostMapping("/querySignedDocument")
    public String querySignedDocument(Model model) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("statenum", 2);

        List<Document> documentList = documentService.queryDocument(map);

        if (documentList.size() > 0) {
            model.addAttribute("documentList", documentList);
            return "./document/querySignedDocumentResult";
        } else {
            model.addAttribute("msg", "没有已签审的公文");
            return "./office/main";
        }
    }

    //发送未签审公文给主管
    @PostMapping("/sendUnsignedDocumentById")
    public String sendUnsignedDocumentById(HttpServletRequest request,
                                           Model model) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", request.getParameter("id"));
        map.put("statenum", 1);

        if (documentService.updateDocument(map) > 0) {
            model.addAttribute("msg", "发送成功");
        } else {
            model.addAttribute("msg", "发送失败");
        }

        map.clear();
        map.put("statenum", 1);

        model.addAttribute("documentList", documentService.queryDocument(map));
        return "./office/querySentDocumentResult";
    }

    //跳转到修改公文页面
    @PostMapping("/toUpdateUnsignedDocumentPage")
    public String toUpdateUnsignedDocumentPage(@RequestParam("id") int id,
                                               Model model) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);

        System.out.println(documentService.queryDocument(map).get(0));

        model.addAttribute("document", documentService.queryDocument(map).get(0));
        return "./office/updateUnsignedDocumentPage";
    }

    //修改公文
    @PostMapping("/updateUnsignedDocument")
    public String updateUnsignedDocument(@RequestParam("id") int id,
                                         @RequestParam("title") String title,
                                         @RequestParam("text") String text,
                                         Model model) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);

        if (!title.equals("")) {
            map.put("title", title);
        }
        if (!text.equals("")) {
            map.put("text", text);
        }

        if (documentService.updateDocument(map) > 0) {
            model.addAttribute("msg", "修改成功");
        } else {
            model.addAttribute("msg", "修改失败");
        }

        map.clear();
        map.put("statenum", 0);

        model.addAttribute("documentList", documentService.queryDocument(map));
        return "./office/queryUnsignedDocumentResult";
    }

    //根据id删除未签审公文
    @PostMapping("/deleteUnsignedDocumentById")
    public String deleteUnsignedDocumentById(@RequestParam("id") int id,
                                             Model model) {
        if (documentService.deleteDocumentById(id) > 0) {
            model.addAttribute("msg", "删除成功");
        } else {
            model.addAttribute("msg", "删除失败");
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("statenum", 0);

        model.addAttribute("documentList", documentService.queryDocument(map));
        return "./office/queryUnsignedDocumentResult";
    }

}
