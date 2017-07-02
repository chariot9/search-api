package com.chariot.shadow.company.factory;

import com.chariot.shadow.common.Contents;
import com.chariot.shadow.company.*;
import com.chariot.shadow.supplier.Supplier;

/**
 * Created by Trung Vu on 2017/06/26.
 */
public class CompanyFactory {

    public static Company create(float score, Contents contents, CompanyID companyID, Supplier supplier, CompanyName companyName,
                                 CompanyAddress companyAddress, CompanyCountry companyCountry,
                                 CompanyTelephoneNumber companyTelephoneNumber, CompanyWebUrl companyWebUrl,
                                 CompanyShortDescription companyShortDescription) {
        return new Company(score, contents, companyID, supplier, companyName, companyAddress, companyCountry, companyTelephoneNumber, companyWebUrl, companyShortDescription);
    }
}
