package com.example.impls;

import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Invoice;
import com.example.ifaces.MyDao;

@Repository
public class InvoiceDaoImpl implements MyDao<Invoice> {

	private JdbcTemplate template;
	
	
	// Constructor DI will happen here
	public InvoiceDaoImpl(JdbcTemplate template) {
		super();
		this.template = template;
	}

	@Override
	public boolean add(Invoice t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Invoice> findAll() {
		
		String sql ="select * from invoice";
		
			return  template.query(sql, rowMapper());
			
	}

	private RowMapper<Invoice> rowMapper() {

		
		return (rs,rowNum) -> new Invoice(rs.getInt("invoiceNumber"),
				  rs.getString("customerName"),
				  rs.getDate("invoiceDate").toLocalDate(),
				  rs.getDouble("amount"));
	}

	@Override
	public Invoice findById(int id) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
