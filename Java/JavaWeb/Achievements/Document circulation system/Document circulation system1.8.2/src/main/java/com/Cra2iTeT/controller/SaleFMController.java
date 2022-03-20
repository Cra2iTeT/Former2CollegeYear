package com.Cra2iTeT.controller;

import com.Cra2iTeT.bean.Document;
import com.Cra2iTeT.service.impl.DocumentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/saleFM")
public class SaleFMController {
    @Autowired
    private DocumentServiceImpl documentService;

    //查看公文
    public List<Document> queryDocument(HashMap<String, Object> map) {
        List<Document> documentList = documentService.queryDocument(map);

        for (Document document : documentList) {
            document.setState(document.getStateNum());
        }

        return documentList;
    }

    //修改公文
    public int updateDocument(HashMap<String, Object> map) {
        return documentService.updateDocument(map);
    }

    //浏览所有已发送公文
    @RequestMapping("/queryAllSentDocument")
    public String queryAllSentDocument(Model model) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("statenum", 1);
        map.put("departid", 3);

        List<Document> documentList = queryDocument(map);

        if (documentList.size() > 0) {
            model.addAttribute("documentList", documentList);
            return "./manager/saleFactoryManager/queryAllSentDocumentResult";
        } else {
            model.addAttribute("msg", "没有已发送公文");
            return "./manager/saleFactoryManager/main";
        }
    }

    //跳转到查询页面
    @RequestMapping("/toQueryDocumentPage")
    public String toQueryDocumentPage() {
        return "./manager/saleFactoryManager/queryDocumentPage";
    }

    //根据条件查询公文
    @RequestMapping("/queryDocument")
    public String queryDocument(HttpServletRequest request,
                                Model model) {
        System.out.println();
        System.out.println("================");
        System.out.println("saleFMController根据条件查询公文函数中");

        HashMap<String, Object> map = new HashMap<>();

        if (!request.getParameter("id").equals("")) {
            System.out.println("id=>" + request.getParameter("id"));
            map.put("id", request.getParameter("id"));
        }
        if (!request.getParameter("authorId").equals("")) {
            System.out.println("authorId=>" + request.getParameter("authorId"));
            map.put("authorid", request.getParameter("authorId"));
        }
        if (!request.getParameter("authorName").equals("")) {
            System.out.println("authorName=>" + request.getParameter("authorName"));
            map.put("authorname", request.getParameter("authorName"));
        }
        if (!request.getParameter("title").equals("")) {
            System.out.println("title=>" + request.getParameter("title"));
            map.put("title", request.getParameter("title"));
        }
        if (!request.getParameter("stateNum").equals("4")) {
            System.out.println("stateNum=>" + request.getParameter("stateNum"));
            map.put("statenum", request.getParameter("stateNum"));
        }

        map.put("departid", 3);

        System.out.println("================");
        System.out.println();

        List<Document> documentList = new ArrayList<>();

//        if (request.getParameter("stateNum").equals("2")) {
//            documentList = querySignedDocument(map);
//        } else {
//            documentList = queryAllDocument(map);
//        }

        documentList = queryDocument(map);

        for (int i = 0; i < documentList.size(); i++) {
            if (documentList.get(i).getDepartId() != 3) {
                documentList.remove(i);
            } else {
                documentList.get(i).setState(documentList.get(i).getStateNum());
            }
        }

        if (documentList.size() > 0) {
            model.addAttribute("documentList", documentList);
            return "./document/queryDocumentResult";
        } else {
            model.addAttribute("msg", "查询结果为空");
            return "./manager/saleFactoryManager/queryDocumentPage";
        }
    }

    //跳转到签审公文页面
    @RequestMapping("/toUpdateSentDocumentPage")
    public String toUpdateSentDocumentPage(HttpServletRequest request,
                                           Model model) {
        System.out.println();
        System.out.println("================");
        System.out.println("saleFMController签审公文函数中");

        HashMap<String, Object> map = new HashMap<>();
        System.out.println("得到的id=>" + request.getParameter("id"));
        map.put("id", request.getParameter("id"));

        model.addAttribute("document", queryDocument(map).get(0));

        System.out.println("================");
        System.out.println();

        return "./manager/saleFactoryManager/updateSentDocumentPage";
    }

    //签审公文
    @RequestMapping("/updateUnsignedDocument")
    public String updateUnsignedDocument(HttpServletRequest request,
                                         Model model,
                                         HttpSession session) {
        System.out.println();
        System.out.println("================");
        System.out.println("saleFMController签审公文函数中");

        HashMap<String, Object> map = new HashMap<>();
        map.put("id", request.getParameter("id"));
        System.out.println("得到的id=>" + request.getParameter("id"));
        map.put("advice", request.getParameter("advice"));
        System.out.println("得到的advice=>" + request.getParameter("advice"));
        map.put("statenum", 2);
        map.put("approveid", session.getAttribute("userId"));
        System.out.println("得到的approveid=>" + session.getAttribute("userId"));

        if (updateDocument(map) > 0) {
            model.addAttribute("msg", "公文审签成功");
        } else {
            model.addAttribute("msg", "公文审签失败");
        }

        map.clear();
        map.put("departid", 3);
        map.put("statenum", 2);

        model.addAttribute("documentList", queryDocument(map));

        System.out.println("================");
        System.out.println();

        return "./document/querySignedDocumentResult";
    }
}