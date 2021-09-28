
public class Person {
	public String name;
	public long phoneNo;
	public String emailAddress;
	public String address;
	
	public Person() {
		name="";
	}

	public Person(String name, long phoneNo, String emailAddress, String address) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.emailAddress = emailAddress;
		this.address = address;
	}

	String commaInfo() {
		return name+",0"+phoneNo+","+emailAddress+","+address;
	}
	@Override
	public String toString() {
		return "Name:"+name+"\n"+
				"Phone No:"+phoneNo+"\n"+
				"Email:"+emailAddress+"\n"+
				"Address:"+address;
	}
}
