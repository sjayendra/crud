package com.jay.crud1.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import com.jay.crud1.model.Part;
import com.jay.crud1.model.Car;
import com.jay.crud1.model.Customer;


@Entity
@Table(name = "job")
@SecondaryTables({
        @SecondaryTable(name = "labour")
})
public class Job {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String description;

    @Column
    private String date;

    @OneToMany
    @JoinColumn(name = "JOBID", referencedColumnName = "ID")
    private List<Part> parts;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CARID", referencedColumnName = "ID")
    private Car car;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMERID", referencedColumnName = "ID")
    private Customer customer;

    @Column(name = "repairTime", table = "labour")
    private int repairTime;

    @Column(name = "rate", table = "labour")
    private double rate;

    @Column(name = "total", table = "labour")
    private double total;

    public Job() {
        this.parts = new ArrayList<>();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public int getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(int repairTime) {
        this.repairTime = repairTime;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void addPart(Part part) {
        this.parts.add(part);
    }

    public String getPartsName() {
        String name = "";
        for (Part p : parts
        ) {
            name += "|| Invoice: " + p.getInvoiceNumber() + ", " + "name: " + p.getName() + " ";
        }
        return name;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }
}
