package com.takara.hako.exam.controller.todo;

import com.takara.hako.exam.controller.todo.service.TodoService;
import com.takara.hako.exam.model.Todo;
import com.takara.hako.exam.model.Todo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class TodoController {

	@Autowired
	private TodoService service;

	@ApiOperation(value="格式化webdata:String to Date")
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	@ApiOperation(value = "返回todolist",notes = "无参数")
	@GetMapping(value = "/list-todos")
	public String showTodosList(ModelMap model) {
		String user = getLoggedInUserName();
		model.addAttribute("todos", service.retrieveTodos(user));
		return "list-todos";
	}

	@ApiOperation(value = "跳转新增todo页面",notes = "无参数")
	@GetMapping(value = "/add-todo")
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo());
		return "todo";
	}

	@ApiOperation(value = "新增todo方法",notes = "根据页面对应字段自动封装成todo对象")
	@PostMapping(value = "/add-todo")
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()){
			return "todo";
		}
		//测试全局异常异常
		int o=1/0;
		service.addTodo(getLoggedInUserName(), todo.getDesc(),
				todo.getTargetDate(), false);
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-todos";
	}

	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails){
			return ((UserDetails) principal).getUsername();
		}
		return principal.toString();
	}

	@ApiOperation(value = "跳转修改todo方法",notes = "对象id,类型int")
	@GetMapping(value = "/update-todo")
	public String showUpdateTodoPage(ModelMap model, @RequestParam int id) {
		model.addAttribute("todo", service.retrieveTodo(id));
		return "todo";
	}

	@ApiOperation(value = "修改todo方法",notes = "根据页面对应字段自动封装成todo对象")
	@PostMapping(value = "/update-todo")
	public String updateTodo(ModelMap model, @Valid Todo todo,
                             BindingResult result) {
		if (result.hasErrors()){
			return "todo";
		}
		todo.setUser(getLoggedInUserName());
		service.updateTodo(todo);

		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-todos";
	}

	@ApiOperation(value = "删除todo方法",notes = "对象id,类型int")
	@GetMapping(value = "/delete-todo")
	public String deleteTodo(@RequestParam int id) {
		service.deleteTodo(id);

		return "redirect:/list-todos";
	}

}