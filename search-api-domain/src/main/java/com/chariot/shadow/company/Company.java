package com.chariot.shadow.company;

import com.chariot.shadow.Data;
import com.chariot.shadow.common.Contents;
import com.chariot.shadow.supplier.Supplier;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Created by Trung Vu on 2017/06/26.
 */
@EqualsAndHashCode(callSuper = false)
@Getter
public class Company extends Data implements Comparable<Company> {

    private CompanyID id;
    private Supplier supplier;
    private CompanyName name;
    private CompanyAddress address;
    private CompanyCountry country;
    private CompanyTelephoneNumber number;
    private CompanyWebUrl url;
    private CompanyShortDescription description;

    public Company(float score, Contents contents, CompanyID id, Supplier supplier, CompanyName name, CompanyAddress address, CompanyCountry country, CompanyTelephoneNumber number, CompanyWebUrl url, CompanyShortDescription description) {
        super(score, contents);
        this.id = id;
        this.supplier = supplier;
        this.name = name;
        this.address = address;
        this.country = country;
        this.number = number;
        this.url = url;
        this.description = description;
    }

    @Override
    public int compareTo(Company o) {
        return Float.compare(score, o.getScore());
    }
}
