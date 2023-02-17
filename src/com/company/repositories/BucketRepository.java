package com.company.repositories;

import com.company.data.interfaces.DataBaseInterface;
import com.company.users.Customer;

import java.sql.*;
import java.util.ArrayList;

public class BucketRepository extends GeneralRepository {

    public BucketRepository(DataBaseInterface db){
        super((db));
    }

}
