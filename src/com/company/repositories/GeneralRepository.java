package com.company.repositories;

import com.company.data.interfaces.DataBaseInterface;

public abstract class GeneralRepository {
    final DataBaseInterface db;

    public GeneralRepository(DataBaseInterface db) {
        this.db = db;
    }

}
