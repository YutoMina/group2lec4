package oit.is.group2.lec4.group2lec4.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.group2.lec4.group2lec4.model.Chamber;
import oit.is.group2.lec4.group2lec4.model.ChamberMapper;

/**
 * /sample3へのリクエストを扱うクラス authenticateの設定をしていれば， /sample3へのアクセスはすべて認証が必要になる
 */
@Controller
@RequestMapping("/sample4")
public class Sample41Controller {

  @Autowired
  ChamberMapper chamberMapper;

  @GetMapping("step1")
  public String sample41() {
    return "sample41.html";
  }

  @GetMapping("step3")
  public String sample43() {
    return "sample43.html";
  }

  @GetMapping("step5")
  public String sample44() {
    return "sample45.html";
  }

  @GetMapping("step2/{id}")
  public String sample42(@PathVariable Integer id, ModelMap model) {
    Chamber chamber2 = chamberMapper.selectById(id);
    model.addAttribute("chamber2", chamber2);

    return "sample41.html";
  }

  @PostMapping("step3")
  @Transactional
  public String sample43(@RequestParam String chamberName, ModelMap model, Principal prin) {
    String loginUser = prin.getName(); // ログインユーザ情報
    Chamber chamber3 = new Chamber();
    chamber3.setChamberName(chamberName);
    chamber3.setUserName(loginUser);
    chamberMapper.insertChamber(chamber3);
    model.addAttribute("chamber3", chamber3);
    // System.out.println("ID:" + chamber3.getId());
    return "sample43.html";
  }

  @PostMapping("step5")
  public String sample45(@RequestParam String chamberName, ModelMap model) {
    ArrayList<Chamber> chambers5 = chamberMapper.selectAllByChamberName(chamberName);
    model.addAttribute("chambers5", chambers5);
    return "sample45.html";
  }

}
