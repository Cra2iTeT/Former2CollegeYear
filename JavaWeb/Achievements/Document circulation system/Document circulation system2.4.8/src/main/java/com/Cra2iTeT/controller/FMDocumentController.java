package com.Cra2iTeT.controller;

import com.Cra2iTeT.bean.Document;
import com.Cra2iTeT.service.impl.DocumentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/fm")
public class FMDocumentController {
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

    //超链接查询
    @GetMapping("/queryDocumentById")
    public String queryDocumentById(HttpServletRequest request,
                                    Model model) {
        HashMap<String, Object> map = new HashMap<>();

        map.put("id", request.getParameter("id"));
        System.out.println("得到的id=>" + request.getParameter("id"));
        model.addAttribute("documentList", queryDocument(map).get(0));

        return "./document/queryDocumentDetailedResult";
    }

    //浏览所有已发送公文
    @PostMapping("/queryAllSentDocument")
    public String queryAllSentDocument(HttpSession httpSession,
                                       Model model) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("statenum", 1);

        int jurisdictionNum = (Integer) httpSession.getAttribute("jurisdictionNum") + 1;

        if (jurisdictionNum != 1) {
            map.put("departid", jurisdictionNum);
        }

        List<Document> documentList = queryDocument(map);

        if (documentList.size() > 0) {
            model.addAttribute("documentList", documentList);
            return "./manager/queryAllSentDocumentResult";
        } else {
            model.addAttribute("msg", "没有已发送公文");
            return "./manager/main";
        }
    }

    //跳转到查询页面
    @PostMapping("/toQueryDocumentPage")
    public String toQueryDocumentPage(HttpSession httpSession) {
        if ((Integer) httpSession.getAttribute("jurisdictionNum") == 0) {
            return "./manager/mainFM/queryDocumentPage";
        } else {
            return "./manager/queryDocumentPage";
        }
    }

    //根据条件查询公文
    @PostMapping("/queryDocument")
    public String queryDocument(HttpServletRequest request,
                                HttpSession httpSession,
                                Model model) {
        System.out.println();
        System.out.println("================");
        System.out.println("fMDocumentController根据条件查询公文函数中");

        HashMap<String, Object> map = new HashMap<>();

        if (!request.getParameter("id").equals("")) {
            System.out.println("id=>" + request.getParameter("id"));
            map.put("id", request.getParameter("id"));
        }
        if (request.getParameter("departId") != null && !request.getParameter("departId").equals("0")) {
            System.out.println("departId=>" + request.getParameter("departId"));
            map.put("departid", request.getParameter("departId"));
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

        int jurisdictionNum = (Integer) httpSession.getAttribute("jurisdictionNum") + 1;

        if (jurisdictionNum != 1) {
            map.put("departid", jurisdictionNum);
        }

        System.out.println("================");
        System.out.println();

        List<Document> documentList = queryDocument(map);

        if (jurisdictionNum != 1) {
            for (int i = 0; i < documentList.size(); i++) {
                documentList.get(i).setState(documentList.get(i).getStateNum());    //给状态码转成中文
            }
        }

        if (documentList.size() > 0) {
            model.addAttribute("documentList", documentList);
            return "./document/queryDocumentResult";
        } else {
            model.addAttribute("msg", "查询结果为空");
            if (jurisdictionNum == 1) {
                return "./manager/mainFM/queryDocumentPage";
            } else {
                return "./manager/queryDocumentPage";
            }
        }
    }

    //跳转到签审公文页面
    @PostMapping("/toUpdateSentDocumentPage")
    public String toUpdateSentDocumentPage(HttpServletRequest request,
                                           Model model) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", request.getParameter("id"));

        model.addAttribute("document", queryDocument(map).get(0));
        return "./manager/updateSentDocumentPage";
    }

    //签审公文
    @PostMapping("/updateUnsignedDocument")
    public String updateUnsignedDocument(HttpServletRequest request,
                                         Model model,
                                         HttpSession httpSession) {
        System.out.println();
        System.out.println("================");
        System.out.println("fMDocumentController签审公文函数中");

        HashMap<String, Object> map = new HashMap<>();
        map.put("id", request.getParameter("id"));
        System.out.println("得到的id=>" + request.getParameter("id"));
        map.put("advice", request.getParameter("advice"));
        System.out.println("得到的advice=>" + request.getParameter("advice"));
        map.put("statenum", 2);
        map.put("approveid", httpSession.getAttribute("userId"));
        System.out.println("得到的approveid=>" + httpSession.getAttribute("userId"));

        if (documentService.updateDocument(map) > 0) {
            model.addAttribute("msg", "公文审签成功");
        } else {
            model.addAttribute("msg", "公文审签失败");
        }

        map.clear();

        int jurisdictionNum = (Integer) httpSession.getAttribute("jurisdictionNum") + 1;

        if (jurisdictionNum != 1) {
            map.put("departid", jurisdictionNum);
        }

        map.put("statenum", 2);

        model.addAttribute("documentList", queryDocument(map));

        System.out.println("================");
        System.out.println();

        return "./document/querySignedDocumentResult";
    }
}
