import java.io.*;
class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String contactNo;
    private String address;
    public Customer(int id, String name, String contactNo, String address) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
    }
    public int getId() { return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        Customer customer = new Customer(1, "John Doe", "1234567890", "123 Main St, City");
        try (FileOutputStream fileOut = new FileOutputStream("JavaObject.txt");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(customer);
            System.out.println("Customer object has been serialized and saved to JavaObject.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileInputStream fileIn = new FileInputStream("JavaObject.txt");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            Customer deserializedCustomer = (Customer) objectIn.readObject();
            System.out.println("Customer object has been deserialized from JavaObject.txt:");
            System.out.println(deserializedCustomer);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
