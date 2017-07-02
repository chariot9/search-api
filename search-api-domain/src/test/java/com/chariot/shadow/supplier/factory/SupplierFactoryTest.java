package com.chariot.shadow.supplier.factory;

import com.chariot.shadow.supplier.Supplier;
import com.chariot.shadow.supplier.SupplierCode;
import com.chariot.shadow.supplier.SupplierID;
import com.chariot.shadow.supplier.SupplierName;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Trung Vu on 2017/06/26.
 */
public class SupplierFactoryTest {

    @Test
    public void createSupplierByEachComponents() throws Exception {
        Supplier supplier = SupplierFactory.create(1, "S", "Sky News");
        assertThat(supplier.getId(), is(new SupplierID(1)));
        assertThat(supplier.getCode(), is(new SupplierCode("S")));
        assertThat(supplier.getName(), is(new SupplierName("Sky News")));
    }

    @Test
    public void createSupplierBy() throws Exception {
        Supplier supplier = SupplierFactory.create(1, "S", "Sky News");
        assertThat(supplier.getId(), is(new SupplierID(1)));
        assertThat(supplier.getCode(), is(new SupplierCode("S")));
        assertThat(supplier.getName(), is(new SupplierName("Sky News")));
    }
}