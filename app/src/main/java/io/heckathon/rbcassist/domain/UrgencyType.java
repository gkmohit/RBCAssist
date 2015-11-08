package io.heckathon.rbcassist.domain;

import java.io.Serializable;

/**
 * Created by Nilesh on 11/7/2015.
 */
public class UrgencyType implements Serializable {

    private String urgencyTypeId;

    private String urgencyType;

    public UrgencyType(String urgencyTypeId, String urgencyType) {
        this.urgencyTypeId = urgencyTypeId;
        this.urgencyType = urgencyType;
    }

    public String getUrgencyTypeId() {
        return urgencyTypeId;
    }

    public String getUrgencyType() {
        return urgencyType;
    }
}
