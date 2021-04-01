package com.bdshadow.java11.service;

import com.bdshadow.java11.api.Say;
import com.bdshadow.java11.impl.SayMore;

public class SayProvider {

    public static Say provider() {
        return new SayMore();
    }
}
