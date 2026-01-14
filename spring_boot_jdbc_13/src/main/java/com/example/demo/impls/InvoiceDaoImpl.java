package com.example.demo.impls;

import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Invoice;
import com.example.demo.ifaces.MyDao;

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
		
		String sql ="INSERT INTO INVOICE(invoiceNumber,customerName,invoiceDate,amount) values(?,?,?,?)";
		
		
		return this.template.update(sql,t.invoiceNumber(),t.customerName(),t.invoiceDate(),t.amount())==1?true:false;
		
	}
	@Override
	public List<Invoice> findAll() {
		
		String sql ="select * from invoice";
		
			return  template.query(sql, rowMapper());
			
	}
	@Override
	public Invoice findById(int id) throws RuntimeException {
		
		return this.template.queryForObject(
				"select * from invoice where invoiceNumber=?",rowMapper(),id);

		
	}
	private RowMapper<Invoice> rowMapper() {

		return (rs,rowNum) -> new Invoice(rs.getInt("invoiceNumber"),
				  rs.getString("customerName"),
				  rs.getDate("invoiceDate").toLocalDate(),
				  rs.getDouble("amount"));
	}


	
	
}
