package com.example.diy4rent.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

@Entity
@Table (name = "herramientas")
public class Herramientas {
    @Id
    private String uuid;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private float price;
    @Column(name = "photo")
    private byte[] photo;
    @Column(name = "timestamp")
    private String timestamp;
    @Column(name = "category")
    private String category; 
    @Column(name = "location")
    private String location; 
    @Column(name = "charge_info")
    private String charge_info;

    public Herramientas() {
        // empty constructor body
    }

    public Herramientas(String title, String description, float price, byte[] photo, String category, String location, String charge_info){
        this.uuid = UUID.randomUUID().toString();
        this.title = title;
        this. description = description;
        this.price = price;
        this.photo = photo;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        this.timestamp = formattedDateTime;
        this.category = category;
        this.location = location;
        this.charge_info = charge_info;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPhoto() {
        // Aqui vamos a convertir nuestro String a Base64:
        // Assume imageData is a String containing the hex representation of the image
        String base64String = null;
        try {
            byte[] binaryBytes = jakarta.xml.bind.DatatypeConverter.parseHexBinary(jakarta.xml.bind.DatatypeConverter.printHexBinary(photo));
            base64String = Base64.encodeBase64String(binaryBytes);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return base64String;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCharge_info() {
        return charge_info;
    }

    public void setCharge_info(String charge_info) {
        this.charge_info = charge_info;
    }
}

