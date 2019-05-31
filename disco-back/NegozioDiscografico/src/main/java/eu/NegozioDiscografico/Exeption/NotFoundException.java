package eu.NegozioDiscografico.Exeption;

public class NotFoundException extends RuntimeException {

	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	public NotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%s non trovato con %s : <%s>", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getResourceName() {
		return resourceName;
	}
	public String getFiledName() {
		return fieldName;
	}
	public Object getFieldValue() {
		return fieldValue;
	}
	
	
	
}
