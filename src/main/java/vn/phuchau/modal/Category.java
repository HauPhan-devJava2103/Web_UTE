package vn.phuchau.modal;

import java.io.Serializable;

public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String images;
	private int status;

	public Category(int id, String name, String images, int status) {
		super();
		this.id = id;
		this.name = name;
		this.images = images;
		this.status = status;
	}

	public Category() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", images=" + images + ", status=" + status + "]";
	}

}
