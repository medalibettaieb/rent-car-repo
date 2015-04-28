package mBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class MrBean {
	private String nameOne;
	private String nameTow;

	public String doSomeStuff() {
		nameTow = nameOne;
		return "/login";
	}

	public void doValidate(){
		
	}
	public String getNameOne() {
		return nameOne;
	}

	public void setNameOne(String nameOne) {
		this.nameOne = nameOne;
	}

	public String getNameTow() {
		return nameTow;
	}

	public void setNameTow(String nameTow) {
		this.nameTow = nameTow;
	}

}
