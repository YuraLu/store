package org.example.store.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stores", schema="public")
public class Store extends AbstractEntity {

    @Column(name = "name", nullable = false, length = 58)
    private String name;

    @Column(name = "phoneNumber", nullable = false, length = 15)
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "store_codes",
            joinColumns = @JoinColumn(name = "store_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "companyCode_id", referencedColumnName = "id"))
    private CompanyCode companyCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "geoLocation_id")
    private GeoLocation geoLocation;


    public Store() {
    }

    public Store(Long id) {
        super(id);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public CompanyCode getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(CompanyCode companyCode) {
        this.companyCode = companyCode;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Store other = (Store) o;
        return Objects.equals(name, other.name) &&
                Objects.equals(phoneNumber, other.phoneNumber) &&
                Objects.equals(address, other.address) &&
                Objects.equals(companyCode, other.companyCode) &&
                Objects.equals(geoLocation, other.geoLocation);
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, phoneNumber, address, companyCode, geoLocation);
    }


    @Override
    public String toString() {
        return "Store{" +
                super.toString() +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address +
                ", companyCode=" + companyCode +
                ", geoLocation=" + geoLocation +
                '}';
    }
}
