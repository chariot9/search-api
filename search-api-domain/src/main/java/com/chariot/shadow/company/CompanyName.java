package com.chariot.shadow.company;

import com.chariot.shadow.company.name.CompanyNameEnglish;
import com.chariot.shadow.company.name.CompanyNameLocal;
import lombok.Value;

/**
 * Created by Trung Vu on 2017/06/26.
 */
@Value
public class CompanyName implements Comparable<CompanyName> {

    private CompanyNameEnglish englishName;
    private CompanyNameLocal localName;

    @Override
    public int compareTo(CompanyName o) {
        int compare = englishName.compareTo(o.getEnglishName());
        if (compare != 0)
            return compare;
        return localName.compareTo(o.getLocalName());
    }
}
