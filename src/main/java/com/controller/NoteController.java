package com.controller;

import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.NoteDao;
import com.entity.Note;
import com.util.GzipUtils;
import com.util.JsonUtils;


@Controller
@Slf4j
public class NoteController {
	@Autowired
	private NoteDao noteDao;
	//跳转Note编辑页面
	@RequestMapping("/noteEdit")
	public String addNote(HttpServletResponse response){
		return "note/note-edit";
	}
	
	//保存Note
	@RequestMapping(value="/note", method=RequestMethod.POST)
	public void saveNote(Note note, HttpServletResponse response){
//		log.info("{}",noteDao.save(note));
		System.out.println(note);
		GzipUtils.writeResponseDataStr(JsonUtils.object2Json(note), response);
	}
}
