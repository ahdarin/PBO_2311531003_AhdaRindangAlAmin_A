package model;

public class CustomerBuilder {
	private String id,nama,email, alamat, hp;
	
	public CustomerBuilder() {	
	}
	public CustomerBuilder setId(String id) {
		this.id = id;
		return this;
	}
	public CustomerBuilder setNama(String nama) {
		this.nama = nama;
		return this;
	}
	public CustomerBuilder setEmail(String email) {
		this.email = email;
		return this;
	}
	public CustomerBuilder setAlamat(String alamat) {
		this.alamat = alamat;
		return this;
	}
	public CustomerBuilder setHp(String hp) {
		this.hp = hp;
		return this;
	}
	public Customer build() {
		return new Customer(id, nama, email, alamat, hp);
	}
}
