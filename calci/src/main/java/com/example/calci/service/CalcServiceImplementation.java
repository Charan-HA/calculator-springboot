package com.example.calci.service;

import org.springframework.stereotype.Service;

@Service
public class CalcServiceImplementation implements CalcService {

	@Override
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int sub(int num1, int num2) {
		return num1 - num2;
	}

	@Override
	public int mul(int num1, int num2) {
		return num1 * num2;
	}

	@Override
	public int div(int num1, int num2) {
		return num1 / num2;
	}

}
