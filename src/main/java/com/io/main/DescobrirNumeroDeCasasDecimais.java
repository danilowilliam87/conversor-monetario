package com.io.main;

public class DescobrirNumeroDeCasasDecimais {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        double num = 9.03965846125;
        String [] nums = Double.toString(num).split("\\.");
        
        for(int i = 0; i< nums.length; i++) {
        	System.out.println(nums[i]);
        }
	}

}
