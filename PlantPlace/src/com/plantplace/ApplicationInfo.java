package com.plantplace;




import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import org.springframework.context.annotation.Scope;

@Named
@ManagedBean
@Scope("session")
public class ApplicationInfo {

	String slogan = "promoting plant diversity through edu";

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
}
