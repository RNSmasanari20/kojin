package com.example.kojin.entity;

public record UserRecord(int id, String login_id, String password,
                         String name, int role){}
