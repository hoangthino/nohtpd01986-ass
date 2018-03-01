/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



/**
 *
 * @author 8470p
 */
public class Product {
    private int id;
private String name;
private int quantity;
private double price;

private Category idDanhMuc;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(Category idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public Product(int id, String name, int quantity, double price, Category idDanhMuc) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.idDanhMuc = idDanhMuc;
    }

    public Product() {
    }
}
