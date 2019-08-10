package com.spring.boot.entity.base.genid;

import com.baomidou.mybatisplus.incrementer.IKeyGenerator;
import com.wu.ObjectId;

public class ObjectIdGenId  {
    public static String genId() {
        return new ObjectId().toString();
    }
}
