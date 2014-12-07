package br.com.cdsl.validator.object;

import java.math.BigDecimal;

import br.com.cdsl.annotations.field.Range;

class Valor {
	
	@Range(max="10", min="1", messageException="Valor inesperado")
	private int intValue;
	
	@Range(max="10", min="0", messageException="Valor inesperado")
	private BigDecimal bigDecimal;
	
	
	public int getIntValue() {
		return intValue;
	}
	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}
	public BigDecimal getBigDecimal() {
		return bigDecimal;
	}
	public void setBigDecimal(BigDecimal bigDecimal) {
		this.bigDecimal = bigDecimal;
	}
	

}
