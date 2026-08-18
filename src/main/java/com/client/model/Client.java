package src.main.java.com.client.model;

import java.time.LocalDate;

public class Client {

    private static int nextId = 1;

    private int id;
    private String name;
    private String nif;
    private String email;
    private String phone;
    private String address;
    private LocalDate createdAt;

    public Client(String name, String nif, String email, String phone, String address) {
        this.id = nextId++;
        this.setName(name);
        this.setNif(nif);
        this.setEmail(email);
        this.setPhone(phone);
        this.setAddress(address);
        this.createdAt = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Client{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", nif='" + nif + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", address='" + address + '\'' +
            ", created At='" + createdAt + '\'' +
            '}';
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null");
        } 
        
        this.name = name;
        
    }

    public void setNif(String nif) {
        String validation = "^[0-9]{8}[A-Z]$";

        if (nif == null || !nif.matches(validation)) {
            throw new IllegalArgumentException("NIF has to be like: 00000000A");           
        } 

        this.nif = nif;
    }

    public void setEmail(String email) {
        String validation = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        if (email == null || !email.matches(validation)) {
            throw new IllegalArgumentException("Not a valid email");           
        }

        this.email = email;
    }

    public void setPhone(String phone) {
        String validation = "^[0-9]{9}$";

        if (phone != null && !phone.matches(validation)) {
            throw new IllegalArgumentException("Phone must have 9 numbers without spaces");           
        }

        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address cannot be null");
        } 
        
        this.address = address;
    }
    
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getNif() {
        return this.nif;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getAddress() {
        return this.address;
    }

    public LocalDate getCreatedAt() {
        return this.createdAt;
    }

}