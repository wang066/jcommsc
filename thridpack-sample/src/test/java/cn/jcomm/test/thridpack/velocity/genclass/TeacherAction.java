package cn.jcomm.test.thridpack.velocity.genclass;//
//package com.liuxiang.velocity.action;
//
//import java.util.List;
//
//import com.liuxiang.velocity.annotation.Action;
//import com.liuxiang.velocity.annotation.Autowired;
//import com.liuxiang.velocity.dao.TeacherDao;
//import com.liuxiang.velocity.model.Teacher;
//import com.liuxiang.velocity.util.WebUtil;
//
//@Action("teacherAction")
//public class TeacherAction extends BaseAction{
//	@Autowired
//	public TeacherDao teacherDao;
//	private List<Teacher> teachers;
//	private Teacher teacher;
//	private Integer id;
//	private String name;
//	private String serializeNo;
//	private String titile;
//	private String subject;
//	public String teacherList() {
//		teachers = teacherDao.retrieveAllTeachers();
//		return "teacherList.jsp";
//	}
//
//	public String toTeacherModify() {
//		teacher = teacherDao.retrieveById(id);
//		return "teacherModify.jsp";
//	}
//	public void teacherModify() {
//		teacher = new Teacher(#generateParam(${attrs}));
//		teacherDao.update(teacher);
//		WebUtil.sendMessage("success");
//	}
//
//	public String toTeacherAdd() {
//		return "teacherAdd.jsp";
//	}
//	public void teacherAdd() {
//		teacher = new Teacher(#generateParam(${attrs}));
//		teacherDao.add(teacher);
//		WebUtil.sendMessage("success");
//	}
//	public void teacherDelete() {
//		teacherDao.delete(id);
//		WebUtil.sendMessage("success");
//	}
//
//	public List<Teacher> getTeachers() {
//		return teachers;
//	}
//	public void setTeachers(List<Teacher> teachers) {
//		this.teachers = teachers;
//	}
//	public Integer get#toUpperCase($attrName)() {
//		return id;
//	}
//
//	public void set#toUpperCase($attrName)(Integer id) {
//		this.id = id;
//	}
//	public String get#toUpperCase($attrName)() {
//		return name;
//	}
//
//	public void set#toUpperCase($attrName)(String name) {
//		this.name = name;
//	}
//	public String get#toUpperCase($attrName)() {
//		return serializeNo;
//	}
//
//	public void set#toUpperCase($attrName)(String serializeNo) {
//		this.serializeNo = serializeNo;
//	}
//	public String get#toUpperCase($attrName)() {
//		return titile;
//	}
//
//	public void set#toUpperCase($attrName)(String titile) {
//		this.titile = titile;
//	}
//	public String get#toUpperCase($attrName)() {
//		return subject;
//	}
//
//	public void set#toUpperCase($attrName)(String subject) {
//		this.subject = subject;
//	}
//	public Teacher getTeacher() {
//		return teacher;
//	}
//
//	public void setTeacher(Teacher teacher) {
//		this.teacher = teacher;
//	}
//}
