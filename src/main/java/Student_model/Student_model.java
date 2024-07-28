package Student_model;

public class Student_model {
      private  int id;
      private String name;
      private String address;
      private String Mob;
      private String  email;
      private String Gender;
      
      
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMob() {
		return Mob;
	}
	public void setMob(String mob) {
		Mob = mob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	@Override
	public String toString() {
		return "Student_model [id=" + id + ", name=" + name + ", address=" + address + ", Mob=" + Mob + ", email="
				+ email + ", Gender=" + Gender + "]";
	}
      
}
