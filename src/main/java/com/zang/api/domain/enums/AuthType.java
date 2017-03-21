package com.zang.api.domain.enums;

import com.zang.api.domain.enums.util.EnumUtil;
import org.codehaus.jackson.annotate.JsonCreator;

import java.util.HashMap;
import java.util.Map;

public enum AuthType {
    IP_ACL,
    CREDENTIAL_LIST;

    private static Map<AuthType, String> map;

    static {
        map = new HashMap<AuthType, String>();
        map.put(IP_ACL, "LOCAL");
        map.put(CREDENTIAL_LIST, "TOLLFREE");
    }

    @JsonCreator
    public static AuthType forValue(String s) {
        return EnumUtil.getValue(s, map, null);
    }

    @Override
    public String toString() {
        return map.get(this);
    }
}
