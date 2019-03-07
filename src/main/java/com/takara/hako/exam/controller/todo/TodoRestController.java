package com.takara.hako.exam.controller.todo;

import com.takara.hako.exam.controller.todo.service.TodoService;
import com.takara.hako.exam.model.Todo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoRestController {
	@Autowired
	private TodoService service;

	@ApiOperation(value = "返回todo对象list(json)",notes = "无参数")
	@GetMapping(value = "/todo/")
	public List<Todo> listAllTodos() {
		List<Todo> users = service.retrieveTodos("tdn20244");
		return users;
	}

	@ApiOperation(value = "返回todo对象(json)",notes = "对象id,类型int")
	@GetMapping(value = "/todo/{id}")
	public Todo retrieveTodo(@PathVariable("id") int id) {
		return service.retrieveTodo(id);
	}
}