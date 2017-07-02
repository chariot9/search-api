package com.chariot.shadow.supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Trung Vu on 2017/06/26.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierJson {

    private SupplierIDJson id;
    private SupplierCodeJson code;
    private SupplierNameJson name;
}
