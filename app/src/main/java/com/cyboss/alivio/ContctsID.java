package com.cyboss.alivio;

import androidx.annotation.NonNull;

public class ContctsID {
    public String cntcsID;
    public <T extends ContctsID> T withId(@NonNull final String id){
        this.cntcsID=id;
        return (T)this;
    }
}
