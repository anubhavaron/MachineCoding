package com.machinecoding.splitwise.dao;

import com.machinecoding.splitwise.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class SplitWiseDao {
    @Getter
    @Setter
    private Map<User, Double> userDoubleMap = new HashMap<>();
}
