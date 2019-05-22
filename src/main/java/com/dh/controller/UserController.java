package com.dh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dh.entity.Tree;
import com.dh.service.IPermissionService;
import com.dh.utils.JsonResult;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IPermissionService permissionService;

	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String jumpIndex() {
		return "index";
	}


	/**
	 * json
	 * 
	 * @return
	 */
	@RequestMapping("/jsonIndex")
	@ResponseBody
	public String jsonIndex() {
		return "nihao";
	}

	/**
	 * 权限展示
	 * 
	 * @param uiId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryListMenu")
	@ResponseBody
	public List queryListMenu(String uiId) throws Exception {
		List<Tree> trees = permissionService.queryListMenu(uiId);
		for (int i = 0; i < trees.size(); i++) {
			if (trees.get(i).getStatus() == 1) {
				trees.get(i).setCheck(true);
			} else {
				trees.get(i).setCheck(false);
			}
		}
		return trees;
	}

	/**
	 * 授权
	 * 
	 * @param uiId
	 * @param arrayTrees
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertPermission")
	@ResponseBody
	public JsonResult insertPermission(String uiId, String arrayTrees, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		int num = permissionService.insertPermission(uiId, arrayTrees);
		return new JsonResult(JsonResult.SUCCESS_CODE, "授权成功", num);
	}
}
