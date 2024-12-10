package model;

public class Customer {
	private String id,nama,email, alamat, hp;
	
	public Customer(String id, String nama, String email, String alamat, String hp) {
		this.id = id;
		this.nama = nama;
		this.email = email;
		this.alamat = alamat;
		this.hp = hp;
	}

	public String getId() {
		return id;
	}

	public String getNama() {
		return nama;
	}

	public String getEmail() {
		return email;
	}
	
	public String getAlamat() {
		return alamat;
	}
	
	public String getHp() {
		return hp;
	}

}
