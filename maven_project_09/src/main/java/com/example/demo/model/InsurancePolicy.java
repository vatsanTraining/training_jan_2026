package com.example.demo.model;

public abstract sealed class InsurancePolicy permits AutoPolicy,HomePolicy {

	public abstract double calculatePremium();
}
