package com.chariot.shadow.supplier.factory;

import com.chariot.shadow.supplier.Supplier;
import com.chariot.shadow.supplier.SupplierCode;
import com.chariot.shadow.supplier.SupplierID;
import com.chariot.shadow.supplier.SupplierName;

/**
 * Created by Trung Vu on 2017/06/26.
 */
public class SupplierFactory {

    public static Supplier create(SupplierID id, SupplierCode code, SupplierName name) {
        return new Supplier(id, code, name);
    }

    public static Supplier create(int id, String code, String name) {
        return new Supplier(
                new SupplierID(id),
                new SupplierCode(code),
                new SupplierName(name)
        );
    }
}
