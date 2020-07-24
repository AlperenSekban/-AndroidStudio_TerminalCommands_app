package com.example.terminalcommands.Models;

import com.google.gson.annotations.SerializedName;

public class Categories {
	private int V;
	private String language;
	@SerializedName("_id")
	private String id;
	private String title;

	public Categories(int v, String language, String id, String title) {
		V = v;
		this.language = language;
		this.id = id;
		this.title = title;
	}

	public void setV(int v) {
		V = v;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getV(){
		return V;
	}

	public String getLanguage(){
		return language;
	}

	public String getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}
}
