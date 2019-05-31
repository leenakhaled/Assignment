package com.example.asalassignment.users.model;

import com.example.asalassignment.users.presenter.RetrofitClient;
import com.example.asalassignment.users.presenter.UsersApi;
import java.util.List;
import retrofit2.Call;


public class UsersListImpl {

    private UsersApi usersApi;

    public UsersListImpl() {
        usersApi = RetrofitClient.getsInstance().getRetrofit().create(UsersApi.class);
    }

    public Call <List<UsersData>> getUsersList() {
        return usersApi.getUsersList();
    }


}
