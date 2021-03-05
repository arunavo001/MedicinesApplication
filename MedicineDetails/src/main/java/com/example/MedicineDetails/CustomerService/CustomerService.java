package com.example.MedicineDetails.CustomerService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.MedicineDetails.Model.Customer;
import com.example.MedicineDetails.repository.CustomerDTO;
@Service
public class CustomerService 
{
	@Autowired
	private CustomerDTO cdto;
	public void saveCustomerData()
	{
		String line="";
		try {
			BufferedReader br=new BufferedReader(new FileReader("src/main/resources/Product list - Sheet1.csv"));
			while((line=br.readLine())!=null)
			{
				String data[]=line.split(",");
				Customer c=new Customer();
				c.setC_name(data[0]);
				c.setC_batch_no(data[1]);
				c.setD_expiry_date(data[2]);
				c.setN_balance_qty(data[3]);
				c.setC_packaging(data[4]);
				c.setC_unique_code(data[5]);
				c.setC_schema(data[6]);
				c.setN_mrp(data[7]);
				c.setC_manufacturer(data[8]);
				c.setHsn_code(data[9]);
				cdto.save(c);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
