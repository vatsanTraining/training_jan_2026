package com.example.demo.model;

public non-sealed class AutoPolicy extends InsurancePolicy {

	@Override
	public double calculatePremium() {
		return 500;
	}

}
