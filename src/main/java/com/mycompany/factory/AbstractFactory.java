package com.mycompany.factory;

import com.mycompany.domain.Entity;

public abstract class AbstractFactory {
    public abstract Entity create(Object ... objects);
}
